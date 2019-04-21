package dp;

import java.util.List;

//120. Triangle https://leetcode.com/problems/triangle/
//Given a triangle, find the minimum path sum from top to bottom.
// Each step you may move to adjacent numbers on the row below.
public class MinimumTotal {

  public int minimumTotal(List<List<Integer>> triangle) {
    int[] dp = new int[triangle.size() + 1]; // 当前层的节点到最底层的最小和值
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
      }
    }
    return dp[0];
  }
}
