import java.util.List;
import java.util.Stack;

import org.w3c.dom.Node;

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
        if (Node == null) {
            return Node;
        }

        Node p = root;
        Stack<Node> stack = new Stack<>();
        stack.push(p);
        while (!stack.empty()) {
            p = stack.pop();
            res.add(node.val);

            if (p.children != null) {
                for (int i = p.children.size() - 1; i >= 0; i--) {
                    stack.add(e)
                }
            }
        }
        return res;
    }
}
// @lc code=end


