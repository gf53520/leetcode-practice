package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 145. Binary Tree PostOrder Traversal
// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrder {

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> solutions = new ArrayList<>();
    if (root == null) {
      return solutions;
    }

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cut = root;
    TreeNode prev = null;
    while (cut != null || !stack.empty()) {
      while (cut != null) {
        stack.push(cut);
        cut = cut.left;
      }
      cut = stack.peek();
      // 当前点right为null，或者之前已经访问
      if (cut.right == null || cut.right == prev) {
        stack.pop();
        solutions.add(cut.val);
        prev = cut;
        cut = null;
      } else { // 右边
        cut = cut.right;
      }
    }
    return solutions;
  }

  // 可解决N叉树的遍历
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> solutions = new ArrayList<>();
    if (root == null) {
      return solutions;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    TreeNode prev = null;
    while (!stack.empty()) {
      TreeNode cut = stack.peek();
      // 如果prev节点已经是最右边节点，表示当前节点可以出栈；
      TreeNode rightMostNode = (cut.right != null) ? cut.right : cut.left;
      if ((cut.left == null && cut.right == null) || rightMostNode == prev) {
        stack.pop();
        solutions.add(cut.val);
        prev = cut;
      } else {
        if (cut.right != null) {
          stack.push(cut.right);
        }
        if (cut.left != null) {
          stack.push(cut.left);
        }
      }
    }
    return solutions;
  }

}
