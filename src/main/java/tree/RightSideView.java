package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 199, 视为层次遍历的最后一个节点
public class RightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> solutions = new ArrayList<>();
    if (root == null) {
      return solutions;
    }

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
        if (size == 0) {
          solutions.add(node.val);
        }
      }
    }
    return solutions;
  }
}
