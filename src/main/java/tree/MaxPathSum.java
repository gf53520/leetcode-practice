package tree;

// 124. 二叉树中的最大路径和，路径的起点和终点可以是任意的树节点
public class MaxPathSum {
  public int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    aux_maxPathSum(root);
    return this.max;
  }

  public int aux_maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = Math.max(0, aux_maxPathSum(root.left));
    int r = Math.max(0, aux_maxPathSum(root.right));
    this.max = Math.max(max, l + r + root.val);
    return root.val + Math.max(l, r);
  }

}
