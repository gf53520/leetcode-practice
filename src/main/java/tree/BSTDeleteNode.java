package tree;

// 450. Delete Node in a BST,
// https://leetcode.com/problems/delete-node-in-a-bst/
// 这里注意需要调整树结构，保证二叉搜索树的性质不变。
public class BSTDeleteNode {

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (key == root.val) {
      if (root.left == null || root.right == null) {
        return root.left == null ? root.right : root.left;
      }
      // 左右非空
      TreeNode min = root.right;
      while (min.left != null) {
        min = min.left;
      }
      root.val = min.val;
      root.right = deleteNode(root.right, min.val);
      return root;
      //     下面solution会超时。。
      //      TreeNode pre = root;
      //      TreeNode cur = root.right;// 最小节点，新root
      //      while (cur.left != null) {
      //        pre = cur;
      //        cur = cur.left;
      //      }
      //      pre.left = cur.right;
      //      cur.left = root.left;
      //      cur.right = root.right;
      //      return cur;
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      root.left = deleteNode(root.left, key);
    }
    return root;
  }

}
