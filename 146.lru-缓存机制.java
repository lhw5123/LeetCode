import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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

class LRUCache {
    private int cap;
    private Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if (map.size() > cap) {
            Node last = tail.prev;
            remove(last);
            map.remove(last.key);
        }
    }

    // 头插
    private void add(Node node) {
        Node next = head.next;
        next.prev = node;
        node.prev = head;
        node.next = next;
        head.next = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

