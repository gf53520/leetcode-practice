package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 515
public class TreeLargestValues {

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> solutions = new ArrayList<>();
    if (root == null) {
      return solutions;
    }

    int max;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      max = Integer.MIN_VALUE;

      while (size-- > 0) {
        TreeNode node = queue.poll();
        max = Math.max(max, node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      solutions.add(max);
    }
    return solutions;
  }
}
