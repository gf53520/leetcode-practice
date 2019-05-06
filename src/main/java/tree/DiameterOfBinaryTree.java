package tree;

// 543 https://leetcode-cn.com/problems/diameter-of-binary-tree/
/*
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
这条路径可能穿过根结点。
        1
       / \
      2   3
     / \
    4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 */
// 定义D(root), 为以经过root节点，且返回值只能取左右子child之一
// 类似 687 124
public class DiameterOfBinaryTree {
  private int max;

  public int diameterOfBinaryTree(TreeNode root) {
    max = 0;
    loop(root);
    return max;
  }

  public int loop(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = loop(root.left);
    int r = loop(root.right);
    max = Math.max(max, l + r);
    return Math.max(l, r) + 1;
  }
}
