package tree;

import java.util.LinkedList;

// 111 https://leetcode.com/problems/minimum-depth-of-binary-tree/
// The minimum depth is the number of nodes along the shortest pathfrom the root node down to the nearest leaf node.
// recursive(dfs) or bfs

public class MinDepth {

  public int minDepth(TreeNode root) { // dfs
    if (root == null) {
      return 0;
    }
    if (root.left == null) { // 区别于求max，不能 1 + Math.min(minDepth(root.left), minDepth(root.right))
      return minDepth(root.right) + 1;
    }
    if (root.right == null) {
      return minDepth(root.left) + 1;
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }


  public int minDepth_bfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int cutLevelNodes = 1;
    int nextLevalNodes = 0;
    int depth = 1;
    while (!queue.isEmpty()) {
      TreeNode node = queue.pop();
      cutLevelNodes--;
      if (node.left != null) {
        queue.add(node.left);
        nextLevalNodes++;
      }
      if (node.right != null) {
        queue.add(node.right);
        nextLevalNodes++;
      }
      if (node.left == null && node.right == null) {
        break;
      }
      if (cutLevelNodes == 0) {
        depth++;
        cutLevelNodes = nextLevalNodes;
        nextLevalNodes = 0;
      }
    }
    return depth;
  }

  private int min = Integer.MAX_VALUE;

  public void minDepth_dfs(TreeNode root, int depth) {
    if (depth >= min)
      return;
    if (root.left == null && root.right == null) {
      this.min = depth;
    }
    if (root.left != null)
      minDepth_dfs(root.left, depth + 1);
    if (root.right != null)
      minDepth_dfs(root.right, depth + 1);
  }

  public int minDepth_dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    minDepth_dfs(root, 1);
    return this.min;
  }

}
