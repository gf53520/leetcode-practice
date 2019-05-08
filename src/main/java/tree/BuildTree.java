package tree;

// 106 从中序与后序遍历序列构造二叉树
// https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
/*
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：
            3
           / \
          9  20
            /  \
           15   7
 */
// preOrd: root -> left -> right
// inOrd: left -> root -> right
// PostOrd: left -> right -> root
// 思路：先确定根节点，再递归解决左子树与右子树
public class BuildTree {

  public TreeNode buildTree(int[] inorder, int[] postorder) {

    return null;
  }
}
