/*
 * @lc app=leetcode.cn id=981 lang=java
 *
 * [981] 基于时间的键值存储
 */

// @lc code=start
class TimeMap {

    private Map<String, Node> nodeMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        nodeMap = new HashMap<String, Node>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!nodeMap.containsKey(key)) {
            nodeMap.put(key, new Node(key, value, timestamp, null));
        } else {
            Node head = nodeMap.get(key);
            nodeMap.remove(key);
            nodeMap.put(key, new Node(key, value, timestamp, head));
        }
    }
    
    public String get(String key, int timestamp) {
        if (!nodeMap.containsKey(key)) {
            return "";
        }

        Node p = nodeMap.get(key);
        while (p != null && p.timestamp > timestamp) {
            p = p.next;
        }
        
        if (p == null) {
            return "";
        }
        return p.value;
    }

    private class Node {
        public String key;
        public String value;
        public int timestamp;
        public Node next;

        public Node(String key, String value, int timestamp, Node next) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
            this.next = next;
        } 
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

