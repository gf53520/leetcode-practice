package tree;

// 98 https://leetcode-cn.com/problems/validate-binary-search-tree/
// right subtree > val, left subtree < val
// 中序遍历，是否有序数组
public class ValidBST {

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean isValidBST(TreeNode root, long min, long max) {

    if (root == null) {
      return true;
    }

    if (root.val <= min && root.val >= max) {
      return false;
    }

    return isValidBST(root.right, root.val, max) &&
        isValidBST(root.left, min, root.val);
  }
}
