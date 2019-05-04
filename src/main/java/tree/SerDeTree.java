package tree;

// 297 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

import java.util.LinkedList;

//    1    => 1,2,$,$,3,$,$
//   /
//  2
//   \
//    3
// queue 1; 1,2,null; 1,2,null,null,3,null,null
public class SerDeTree {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder builder = new StringBuilder();
    if (root == null) {
      return builder.toString();
    }

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode node = queue.poll();
        if (node == null) {
          builder.append('$');
          builder.append(',');
        } else {
          builder.append(node.val);
          builder.append(',');
          queue.add(node.left);
          queue.add(node.right);
        }
      }
    }
    return builder.deleteCharAt(builder.length() - 1).toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null || data.length() == 0) {
      return null;
    }
    String[] nodes = data.split(",");
    int start = 0;
    TreeNode root = new TreeNode(Integer.valueOf(nodes[start++]));
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      String leftStr = nodes[start++];
      TreeNode left = null;
      if (!"$".equals(leftStr)) {
        left = new TreeNode(Integer.valueOf(leftStr));
      }
      node.left = left;
      if (left != null) {
        queue.add(left);
      }

      String rightStr = nodes[start++];
      TreeNode right = null;
      if (!"$".equals(rightStr)) {
        right = new TreeNode(Integer.valueOf(rightStr));
      }
      node.right = right;
      if (right != null) {
        queue.add(right);
      }
    }
    return root;
  }
}
