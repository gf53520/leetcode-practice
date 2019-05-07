package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 144  https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class PreOrder {

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> solutions = new ArrayList<>();
    if (root == null) {
      return solutions;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cut = root;
    while (cut != null || !stack.isEmpty()) {
      while (cut != null) {
        solutions.add(cut.val);
        stack.push(cut);
        cut = cut.left;
      }
      TreeNode peek = stack.pop();
      cut = peek.right;
    }
    return solutions;
  }
}
