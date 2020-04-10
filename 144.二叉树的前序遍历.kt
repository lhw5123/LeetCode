/*
 * @lc app=leetcode.cn id=144 lang=kotlin
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val outputList = mutableListOf<Int>()

        if (root == null) {
            return outputList
        }

        val stack = mutableListOf<TreeNode>()
        stack.add(root)

        while (stack.isNotEmpty()) {
            val p = stack.removeAt(stack.lastIndex)
            outputList.add(p.`val`)
            if (p.right != null) {
                stack.add(p.right!!)
            }
            if (p.left != null) {
                stack.add(p.left!!)
            }
        }

        return outputList
    }
}
// @lc code=end

