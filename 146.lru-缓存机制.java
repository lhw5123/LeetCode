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
// 目前这个解法会超时。
// 如果不想自己实现双向列表，可能就只能选择直接用 LinkedHashMap 了。
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
    private LinkedList<Node> list;  // 保存的是所有的 key。

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
        list.addFirst(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // 修改已存在 node 中的值，并将其已到链表前部。
        Node node = map.get(key);
        if (node != null) {
            list.remove(node);
            node.val = value;
            list.addFirst(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            list.addFirst(node);
            if (list.size() > cap) {
                Node last = list.pollLast();
                if (last != null) {
                    map.remove(last.key);
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

