import "container/list"

/*
 * @lc app=leetcode.cn id=460 lang=golang
 *
 * [460] LFU 缓存
 */

// @lc code=start
type LFUCache struct {
	nodes    map[int]*list.Element
	lists    map[int]*list.List
	capacity int
	min      int
}

type node struct {
	key, value, frequency int
}

func Constructor(capacity int) LFUCache {
	return LFUCache{
		nodes:    make(map[int]*list.Element),
		lists:    make(map[int]*list.List),
		capacity: capacity,
		min:      0,
	}
}

func (this *LFUCache) Get(key int) int {
	value, ok := this.nodes[key]
	if !ok {
		return -1
	}

	currentNode := value.Value.(*node)
	this.lists[currentNode.frequency].Remove(value)
	currentNode.frequency++
	if _, ok := this.lists[currentNode.frequency]; !ok {
		this.lists[currentNode.frequency] = list.New()
	}
	newList := this.lists[currentNode.frequency]
	newNode := newList.PushFront(currentNode)
	this.nodes[key] = newNode
	if currentNode.frequency-1 == this.min && this.lists[currentNode.frequency-1].Len() == 0 {
		this.min++
	}

	return currentNode.value
}

func (this *LFUCache) Put(key int, value int) {
	if this.capacity == 0 {
		return
	}

	if currentValue, ok := this.nodes[key]; ok {
		currentNode := currentValue.Value.(*node)
		currentNode.value = value
		this.Get(key)
		return
	}

	if this.capacity == len(this.nodes) {
		currentList := this.lists[this.min]
		backNode := currentList.Back()
		delete(this.nodes, backNode.Value.(*node).key)
		currentList.Remove(backNode)
	}

	// 新建结点，插入两个列表中
	this.min = 1
	currentNode := &node{
		key:       key,
		value:     value,
		frequency: 1,
	}
	if _, ok := this.lists[1]; !ok {
		this.lists[1] = list.New()
	}
	newList := this.lists[1]
	newNode := newList.PushFront(currentNode)
	this.nodes[key] = newNode
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
// @lc code=end

