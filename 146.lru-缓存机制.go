
import "container/list"

type LRUCache struct {
	Cap  int
	List *list.List
	Keys map[int]*list.Element
}

type pair struct {
	K, V int
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		Cap:  capacity,
		List: list.New(),
		Keys: make(map[int]*list.Element),
	}
}

func (c *LRUCache) Get(key int) int {
	if el, ok := c.Keys[key]; ok {
		c.List.MoveToFront(el)
		return el.Value.(pair).V
	}
	return -1
}

func (c *LRUCache) Put(key, val int) {
	if el, ok := c.Keys[key]; ok {
		el.Value = pair{K: key, V: val}
		c.List.MoveToFront(el)
	} else {
		el := c.List.PushFront(pair{K: key, V: val})
		c.Keys[key] = el
	}

	if c.List.Len() > c.Cap {
		el := c.List.Back()
		c.List.Remove(el)
		delete(c.Keys, el.Val.(pair).K)
	}
}
