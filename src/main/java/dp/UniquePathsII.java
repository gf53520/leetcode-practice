package dp;

// 63 https://leetcode-cn.com/problems/unique-paths-ii/
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
public class UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length;
    if (n == 0) { // 空行
      return 0;
    }
    int m = obstacleGrid[0].length;
    if (m == 0) { // 空列
      return 0;
    }
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i < n + 1; i++) {
      dp[i][0] = 0;
    }
    for (int j = 1; j < m + 1; j++) {
      dp[0][j] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (obstacleGrid[i - 1][j - 1] == 1) {
          dp[i][j] = 0;
        } else if (i == 1 && j == 1) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[n][m];
  }

  // 1维滚动数组
  public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    int n = obstacleGrid.length;
    if (n == 0) { // 空行
      return 0;
    }
    int m = obstacleGrid[0].length;
    if (m == 0) { // 空列
      return 0;
    }
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    int[] dp = new int[m + 1];
    for (int i = 1; i < m + 1; i++) {
      dp[i] = 0; // 初始为0
    }
    dp[1] = 1;

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (obstacleGrid[i - 1][j - 1] == 1) {
          dp[j] = 0;
        } else {
          dp[j] = dp[j] + dp[j - 1];// dp[j]为上一行结果
        }
      }
    }
    return dp[m];
  }

}
