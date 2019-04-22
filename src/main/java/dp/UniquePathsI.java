package dp;

// https://leetcode-cn.com/problems/unique-paths/
// 输入: m = 3, n = 2
// 输出: 3
public class UniquePathsI {

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[n + 1][m + 1]; // n为行，m为列
    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = 0;
    }
    for (int j = 1; j < m + 1; j++) {
      dp[0][j] = 0;
    }

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
