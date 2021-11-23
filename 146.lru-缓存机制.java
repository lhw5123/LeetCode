import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存机制
 */

// @lc code=start
class Node {
    public int key;
    public int val;

    public Node(int k, int v) {
        key = k;
        val = v;
    }
}

class LRUCache {
    private int cap;
    private Map<Integer, Node> map;
    // 设定只能从尾部插入，头部删除。
    private LinkedList<Node> list;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Node>();
        list = new LinkedList<Node>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        list.remove(node);
        list.add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // 修改已存在 node 中的值，并将其重新插入到链表尾部。
            list.remove(node);
            node.val = value;
            list.add(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            list.add(node);
            if (list.size() > cap) {
                Node first = list.removeFirst();
                if (first != null) {
                    map.remove(first.key);
                }
            }
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

