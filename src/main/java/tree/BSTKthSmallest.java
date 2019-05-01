package tree;

import java.util.Stack;

// 230
// 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
// 中序遍历到第k个节点

public class BSTKthSmallest {

  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cut = root;
    while (cut != null || !stack.isEmpty()) {
      while (cut != null) {
        stack.push(cut);
        cut = cut.left;
      }

      cut = stack.pop();
      if (--k == 0) {
        return cut.val;
      }

      cut = cut.right;
    }
    return -1;
  }

}
