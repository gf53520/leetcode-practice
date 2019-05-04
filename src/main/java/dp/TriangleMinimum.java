package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//120. Triangle https://leetcode.com/problems/triangle/
//Given a triangle, find the minimum path sum from top to bottom.
// Each step you may move to adjacent numbers on the row below.

// 状态方程: dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + nums[i][j]
public class TriangleMinimum {

  // 反向dp
  public int minimumTotal2(List<List<Integer>> triangle) {
    int[] dp = new int[triangle.size() + 1]; // 当前层的节点到最底层的最小和值
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
      }
    }
    return dp[0];
  }

  // 正向dp
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.size() == 0) {
      return 0;
    }
    // 根据最后一列构建dp数组
    int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
    for (int i = 0; i < triangle.size(); i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    dp[0][0] = triangle.get(0).get(0);

    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> row = triangle.get(i);
      for (int j = 0; j < row.size(); j++) {
        if (j == 0) { // 特例
          dp[i][j] = dp[i - 1][j] + row.get(j);
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + row.get(j);
        }
      }
    }
    return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
  }

  public static void main(String[] args) {
    TriangleMinimum triangleMinimum = new TriangleMinimum();

    ArrayList<List<Integer>> input = new ArrayList<>();
    input.add(Arrays.asList(2));
    input.add(Arrays.asList(3, 4));
    input.add(Arrays.asList(6, 5, 7));
    input.add(Arrays.asList(4, 1, 8, 3));

    System.out.println(triangleMinimum.minimumTotal(input));
  }
}
