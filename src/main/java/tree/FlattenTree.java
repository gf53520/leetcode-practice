package tree;

// 114 给定一个二叉树，原地将它展开为链表。
// https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
/*
给定一个二叉树，原地将它展开为链表。
将其展开为：
                    1
                     \
                      2
                       \
                        3
                         \
                          4
                           \
                            5
                             \
                              6
          /0
        1
       / \
      2   5
     / \   \
    3   4   6
 */
// 先序遍历
public class FlattenTree {

  public void flattenRecursive(TreeNode root) {
    if (root == null) {
      return;
    }
    flattenRecursive(root.left);
    flattenRecursive(root.right);
    if (root.left == null) {
      return;
    } else {
      TreeNode tmp = root.right;
      root.right = root.left;
      root.left = null;
      TreeNode cut = root;
      while (cut.right != null) {
        cut = cut.right;
      }
      cut.right = tmp;
    }
    return;
  }
}
