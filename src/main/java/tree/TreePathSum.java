package tree;

import java.util.ArrayList;
import java.util.List;

// 113 https://leetcode-cn.com/problems/path-sum-ii/
public class TreePathSum {

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> solutions = new ArrayList<List<Integer>>();
    if (root == null) {
      return solutions;
    }

    ArrayList<Integer> state = new ArrayList<>();
    pathSum(root, solutions, state, sum);
    return solutions;
  }

  public void pathSum(TreeNode root, List<List<Integer>> solutions,
                      ArrayList<Integer> state, int sum) {
    if (root == null) {
      return;
    }
    if (root.right == null && root.left == null && root.val == sum) {
      ArrayList<Integer> newState = new ArrayList<>(state);
      newState.add(root.val);
      solutions.add(newState);
      return;
    }

    state.add(root.val);
    if (root.left != null) {
      pathSum(root.left, solutions, state, sum - root.val);
    }

    if (root.right != null) {
      pathSum(root.right, solutions, state, sum - root.val);
    }
    state.remove(state.size() - 1);
    return;
  }

}
