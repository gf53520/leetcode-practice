package tree;

// 236. Lowest Common Ancestor of a Binary Tree
public class LowestCommonAncestor {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q)
      return root;
    TreeNode l = lowestCommonAncestor(root.left, p, q);
    TreeNode r = lowestCommonAncestor(root.right, p, q);
    if (l == null || r == null)
      return l == null ? r : l;
    return root;
  }

}
