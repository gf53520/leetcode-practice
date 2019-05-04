package tree;

import java.util.ArrayList;
import java.util.List;

// 655 https://leetcode-cn.com/problems/print-binary-tree/
/*
输入:
     1
    / \
   2   3
    \
     4
输出:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
 */
public class PrintTree {

  public List<List<String>> printTree(TreeNode root) {
    int heightSize = getHeight(root);
    int widthSize = (1 << heightSize) - 1;

    List<List<String>> solution = new ArrayList<>();
    for (int i = 0; i < heightSize; i++) {
      List<String> oneRow = new ArrayList<>();
      for (int j = 0; j < widthSize; j++) {
        oneRow.add("");
      }
      solution.add(oneRow);
    }
    fillMatrix(solution, root, 0, 0, widthSize - 1);
    return solution;
  }

  private void fillMatrix(List<List<String>> solution, TreeNode node, int depth, int left, int right) {
    if (node == null)
      return;
    int mid = left + (right - left) / 2;
    List<String> row = solution.get(depth);
    row.set(mid, String.valueOf(node.val));
    fillMatrix(solution, node.left, depth + 1, left, mid - 1);
    fillMatrix(solution, node.right, depth + 1, mid + 1, right);
  }

  public int getHeight(TreeNode root) {
    if (root == null) return 0;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }

}
