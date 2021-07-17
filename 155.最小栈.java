/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    private class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private int minVal;
    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        minVal = Integer.MAX_VALUE;
        head = new Node(0, null);
    }
    
    public void push(int val) {
        Node newNode = new Node(val, head.next);
        head.next = newNode;
        if (val < minVal) {
            minVal = val;
        }
    }
    
    public void pop() {
        if (head.next != null) {
            Node top = head.next;
            head.next = top.next;
            if (top.val == minVal) {
                // find new `minVal`.
                Node p = head.next;
                if (p == null) {
                    minVal = Integer.MAX_VALUE;
                } else {
                    minVal = p.val;
                    while (p != null) {
                        if (p.val < minVal) {
                            minVal = p.val;
                        }
                        p = p.next;
                    }
                }
            }
        }
    }
    
    public int top() {
        if (head.next != null) {
            return head.next.val;
        }
        return 0;
    }
    
    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

