package main

import (
	"math/rand"
	"time"
)

const MaxLevel = 32
const p = 0.5

type Node struct {
	value  uint32
	levels []*Level // 索引节点，index = 0 是底层基础链表
}

type Level struct {
	next *Node
}

type SkipList struct {
	header *Node
	len    uint32
	height uint32
}

func NewSkipList() *SkipList {
	return &SkipList{
		header: &Node{
			levels: make([]*Level, MaxLevel),
		},
		len:    0,
		height: 1,
	}
}

func NewNode(level, value uint32) *Node {
	node := new(Node)
	node.value = value
	node.levels = make([]*Level, level)

	for i := 0; i < len(node.levels); i++ {
		node.levels[i] = new(Level)
	}
	return node
}

// 确定插入的新节点需要多少层索引。根据配好的晋升概率，随机选择一个层级。
func (sl *SkipList) randomLevel() int {
	level := 1
	r := rand.New(rand.NewSource(time.Now().UnixNano()))
	for r.Float64() < p && level < MaxLevel {
		level++
	}
	return level
}

func (sl *SkipList) Add(value uint32) bool {
	if value <= 0 {
		return false
	}

	update := make([]*Node, MaxLevel)
	tmp := sl.header
	for i := int(sl.height) - 1; i >= 0; i-- {
		for tmp.levels[i].next != nil && tmp.levels[i].next.value < value {
			tmp = tmp.levels[i].next
		}
		// 避免插入相同元素
		if tmp.levels[i].next != nil && tmp.levels[i].next.value == value {
			return false
		}
		update[i] = tmp
	}

	level := sl.randomLevel()
	node := NewNode(uint32(level), value)

	if uint32(level) > sl.height {
		sl.height = uint32(level)
	}

	for i := 0; i < level; i++ {
		// 说明新节点对应的层数已经超过了当前链表的高度，需要重新分配内存
		if update[i] == nil {
			sl.header.levels[i].next = node
			continue
		}
		node.levels[i].next = update[i].levels[i].next
		update[i].levels[i].next = node
	}
	sl.len++

	return true
}

// Delete 从上往下寻找要删除节点的前置节点并记录在 last 数组中，然后修改前置节点指针的指向。
func (sl *SkipList) Delete(value uint32) bool {
	var node *Node
	last := make([]*Node, sl.height)
	tmp := sl.header

	for i := int(sl.height) - 1; i >= 0; i-- {
		for tmp.levels[i].next != nil && tmp.levels[i].next.value < value {
			tmp = tmp.levels[i].next
		}
		last[i] = tmp
		// 拿到 value 对应的 node
		if tmp.levels[i].next != nil && tmp.levels[i].next.value == value {
			node = tmp.levels[i].next
		}
	}

	if node == nil {
		return false
	}

	for i := 0; i < len(node.levels); i++ {
		last[i].levels[i].next = node.levels[i].next
		node.levels[i].next = nil
	}

	// 重定向跳表高度
	for i := 0; i < len(node.levels); i++ {
		if sl.header.levels[i].next == nil {
			sl.height = uint32(i)
			break
		}
	}
	sl.len--

	return true
}

func (sl *SkipList) Find(value uint32) *Node {
	var node *Node
	tmp := sl.header
	for i := int(sl.height) - 1; i >= 0; i-- {
		for tmp.levels[i].next != nil && tmp.levels[i].next.value < value {
			tmp = tmp.levels[i].next
		}
		if tmp.value == value {
			node = tmp
			break
		}
	}
	return node
}
