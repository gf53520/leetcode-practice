package dp;

// 518. 零钱兑换 II https://leetcode-cn.com/problems/coin-change-2/
/*
给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
输入: amount = 5, coins = [1, 2, 5]
输出: 4
解释: 有四种方式可以凑成总金额:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
输入: amount = 3, coins = [2]
输出: 0
解释: 只用面额2的硬币不能凑成总金额3。
输入: amount = 10, coins = [10]
输出: 1
 */
// dp[i][j] 使用前i的硬币兑换j的种类
// dp[i][j] =  dp[i-1][j] + (j-coins[k]>=0) ? dp[i-1][j-coins[k]]: 0
public class CoinChange2 {

  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    // 先使用前i个硬币，求出cut;
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j - coins[i] >= 0) {
          dp[j] += dp[j - coins[i]];
        }
      }
    }
    return dp[amount];
  }

  public int change2(int amount, int[] coins) {
    int[][] dp = new int[coins.length + 1][amount + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= coins.length; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= amount; j++) {
        dp[i][j] += dp[i - 1][j];
        if (j - coins[i - 1] >= 0) {
          dp[i][j] += dp[i][j - coins[i - 1]];
        }
      }
    }
    return dp[coins.length][amount];
  }

  public static void main(String[] args) {
    CoinChange2 obj = new CoinChange2();
    System.out.println(obj.change(5, new int[]{1, 2, 5}));
    System.out.println(obj.change(3, new int[]{2}));
  }

}
