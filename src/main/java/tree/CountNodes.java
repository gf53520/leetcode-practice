package tree;

// 222. 完全二叉树的节点个数
// https://leetcode-cn.com/problems/count-complete-tree-nodes/
public class CountNodes {

  public int countNodes(TreeNode root) {
    int l = 0, r = 0;
    TreeNode left = root, right = root;
    while (left != null) {
      l++;
      left = left.left;
    }
    while (right != null) {
      r++;
      right = right.right;
    }
    if (l == r) { // 左右层数一样，说明是一个满二叉树
      return (1 << l) - 1;
    }
    return countNodes(root.left) + countNodes(root.right) + 1;
  }

}
