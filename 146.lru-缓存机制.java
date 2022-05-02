import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 * 自己实现双向链表，效率会好很多。
 */

// @lc code=start
class Node {
    int key;
    int val;
    Node prev, next;

    public Node(int k, int v) {
        key = k;
        val = v;
    }
}

// 避免命名冲突
class MList {
    // head 和 tail 都是哨兵节点
    Node head, tail;

    MList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    Node last() {
        return this.tail.prev;
    }
}

class LRUCache {
    private int cap;
    private Map<Integer, Node> map;
    private MList list;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Node>();
        list = new MList();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        list.remove(node);
        list.addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        list.addFirst(node);

        if (map.size() > cap) {
            Node last = list.last();
            list.remove(last);
            map.remove(last.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

