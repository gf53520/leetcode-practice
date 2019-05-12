package tree;

// 863 https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
// 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
// 输出：[7,4,1]

import java.util.ArrayList;
import java.util.List;

public class DistanceKNodes {

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    ArrayList<Integer> solutions = new ArrayList<>();
    dfs(root, target, K, solutions);
    return solutions;
  }

  // 返回距离target的长度
  public int dfs(TreeNode root, TreeNode target, int K, List<Integer> solutions) {
    if (root == null) {
      return -1;
    }
    if (root == target) {
      collect(target, K, solutions);
      return 0;
    }

    // 最多有一个非负数
    int l = dfs(root.left, target, K, solutions);
    int r = dfs(root.right, target, K, solutions);

    if (l >= 0) {
      if (l == K - 1) {
        solutions.add(root.val);
      } else { // 继续去右子树中查找K - l - 2
        collect(root.right, K - l - 2, solutions);
      }
      return l + 1;
    }

    if (r >= 0) {
      if (r == K - 1) {
        solutions.add(root.val);
      } else { // 继续去右子树中查找K - r - 2
        collect(root.left, K - r - 2, solutions);
      }
      return r + 1;
    }
    return -1;
  }

  // 使用dfs获取第level层的节点，或者使用bfs
  public void collect(TreeNode root, int level, List<Integer> solutions) {
    if (root == null || level < 0) {
      return;
    }
    if (level == 0) solutions.add(root.val);
    collect(root.left, level - 1, solutions);
    collect(root.right, level - 1, solutions);
  }


}
