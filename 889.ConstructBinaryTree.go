/**
 * Construct binary tree from postorder and postorder traversal.
 * Definition for a binary tree node.
 * If there exist multiple answers, you can return any of them.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func constructFromPrePost(preorder []int, postorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	root := &TreeNode{Val: preorder[0]}
	if len(preorder) == 1 {
		return root
	}

	leftRoot := preorder[1]
	leftSize := 0
	for i, v := range postorder {
		if v == leftRoot {
			leftSize = i + 1
			break
		}
	}

	root.Left = constructFromPrePost(preorder[1:leftSize+1], postorder[:leftSize])
	root.Right = constructFromPrePost(preorder[leftSize+1:], postorder[leftSize:len(postorder)-1])

	return root
}