import (
	"container/list"
	"sync"
)

// 高并发且线程安全的 LRU cache.

type command int

const (
	MoveToFront command = iota
	PushFront
	Delete
)

type clear struct {
	done chan struct{}
}

type CLRUCache struct {
	sync.RWMutex
	cap         int
	list        *list.List
	buckets     []*bucket
	bucketMask  uint32
	deletePairs chan *list.Element
	movePairs   chan *list.Element
	control     chan interface{}
}

type Pair struct {
	key   string
	value interface{}
	cmd   command
}

func New(capacity int) *CLRUCache {
	c := &CLRUCache{
		cap:        capacity,
		list:       list.New(),
		bucketMask: uint(1024) - 1,
		buckets:    make([]*bucket, 1024),
	}
	for i := 0; i < 1024; i++ {
		c.buckets[i] = &bucket{
			keys: make(map[string]*list.Element),
		}
	}
	c.restart()
	return c
}
