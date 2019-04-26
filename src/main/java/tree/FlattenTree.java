package tree;

// 114 给定一个二叉树，原地将它展开为链表。
public class FlattenTree {

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode cut = root;
    while (cut != null) {
      if (cut.left != null) {
        TreeNode left = cut.left;
        while (left.right != null) {
          left = left.right;
        }
        left.right = cut.right;
        cut.right = cut.left;
        cut.left = null;
      }
      cut = cut.right;
    }
  }

}
