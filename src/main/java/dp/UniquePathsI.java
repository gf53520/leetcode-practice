package dp;

// 62 不同路径 https://leetcode-cn.com/problems/unique-paths/
// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）
// 无障碍物
// 输入: m = 3, n = 2
// 输出: 3
public class UniquePathsI {

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[n + 1][m + 1]; // n为行，m为列
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (i == 1 && j == 1) {
          dp[1][1] = 1;
        } else { // dp[1][1->n]
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[n][m];
  }

  public int uniquePaths2(int m, int n) {
    int[] dp = new int[m + 1]; // n为行，m为列
    for (int j = 1; j < m + 1; j++) {
      dp[j] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (i == 1 && j == 1) {
          dp[1] = 1;
        } else {
          dp[j] = dp[j] + dp[j - 1];
        }
      }
    }
    return dp[m];
  }

}
