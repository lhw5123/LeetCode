import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Node p = root;
        Deque<Node> stack = new LinkedList<>();
        stack.push(p);
        while (!stack.isEmpty()) {
            p = stack.pop();
            res.add(p.val);

            if (p.children != null) {
                for (int i = p.children.size() - 1; i >= 0; i--) {
                    stack.push(p.children.get(i));
                }
            }
        }
        return res;
    }
}
// @lc code=end


