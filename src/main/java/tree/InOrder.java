package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> solutions = new ArrayList<>();
    if (root == null) {
      return solutions;
    }

    Stack<TreeNode> stack = new Stack<>();

    TreeNode cut = root;
    while (cut != null || !stack.empty()) {
      while (cut != null) {
        stack.push(cut);
        cut = cut.left;
      }

      TreeNode node = stack.pop();
      solutions.add(node.val);
      cut = node.right;
    }
    return solutions;
  }

}
