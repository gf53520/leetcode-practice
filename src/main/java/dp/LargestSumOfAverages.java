package dp;

// 813 https://leetcode-cn.com/problems/largest-sum-of-averages/
/*
我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。
计算我们所能得到的最大分数是多少。
注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。
1 <= A[i] <= 10000.
输入:
A = [9,1,2,3,9]
K = 3
输出: 20
解释:
A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
我们也可以把 A 分成[9, 1], [2], [3, 9].
这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 */
// dp[k][i] 表示以i为结尾分成k份, 其中i>=k
// dp[k][i] = max(dp[k-1][j] + avg(j, i)), 其中j<i
public class LargestSumOfAverages {

  public double largestSumOfAverages(int[] A, int K) {
    if (A == null || A.length == 0 || K <= 0) {
      return 0;
    }

    double[][] dp = new double[K + 1][A.length + 1];

    // 初始化前缀和
    double[] prefixSum = new double[A.length + 1];
    prefixSum[0] = 0;
    for (int i = 1; i <= A.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + A[i - 1];
      dp[1][i] = prefixSum[i] / i;
    }

    for (int k = 2; k <= K; k++) {
      for (int i = k; i <= A.length; i++) {
        for (int j = k - 1; j < i; j++) {
          dp[k][i] = Math.max(dp[k][i],
              dp[k - 1][j] + (prefixSum[i] - prefixSum[j]) / (i - j));
        }
      }
    }
    return dp[K][A.length];
  }

  public static void main(String[] args) {
    LargestSumOfAverages largestSumOfAverages = new LargestSumOfAverages();
    System.out.println(largestSumOfAverages.largestSumOfAverages(
        new int[]{9, 1, 2, 3, 9}, 3
    ));
  }
}
