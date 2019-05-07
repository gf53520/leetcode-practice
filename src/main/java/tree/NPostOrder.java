package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 590. N叉树的后序遍历
// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
public class NPostOrder {

  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public List<Integer> postorder(Node root) {
    List<Integer> solutions = new ArrayList<>();
    if (root == null) {
      return solutions;
    }

    Stack<Node> stack = new Stack<>();
    Node prev = null;
    stack.push(root);
    while (!stack.empty()) {
      Node cut = stack.peek();
      if (cut.children.size() == 0 || prev == cut.children.get(cut.children.size() - 1)) {
        stack.pop();
        prev = cut;
        solutions.add(cut.val);
        cut = null;
      } else {
        for (int i = cut.children.size() - 1; i >= 0; i--) {
          stack.push(cut.children.get(i));
        }
      }
    }
    return solutions;
  }

}

