package dp;

// 322. 零钱兑换 https://leetcode-cn.com/problems/coin-change/
/*
给定不同面额的硬币 coins 和一个总金额 amount。 你可以认为每种硬币的数量是无限的。
编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
输入: coins = [2], amount = 3
输出: -1
 */
import java.util.*;
import java.util.stream.Collectors;

// 动态规划解答背包问题, 怎样防止溢出问题？
public class CoinChange {

  // dp[i] = min(dp[i-coins[j]]) + 1
  public int coinChange2(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    int max = amount + 1;
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j <= amount; j++) {
        if (j - coins[i] >= 0) {
          dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
      }
    }
    return (dp[amount] > amount) ? -1 : dp[amount];
  }

  private int min = Integer.MAX_VALUE;

  public int coinChange3(int[] coins, int amount) {
    List<Integer> reversedCoins = Arrays.stream(coins).boxed()
        .sorted(Collections.reverseOrder())
        .collect(Collectors.toList());
    coinChange3Dfs(reversedCoins, amount, 0, 0);
    return (min == Integer.MAX_VALUE) ? -1 : min;
  }

  public void coinChange3Dfs(List<Integer> reversedCoins, int target, int cut, int start) {
    if (start == reversedCoins.size() - 1) {
      if (target % reversedCoins.get(start) == 0) {
        min = Math.min(min, cut + target / reversedCoins.get(start));
      }
      return;
    }
    for (int k = target / reversedCoins.get(start); k >= 0 && (cut + k) < min; k--) {
      coinChange3Dfs(reversedCoins, target - k * reversedCoins.get(start), k + cut, start + 1);
    }
  }


  public int coinChange(int[] coins, int amount) {
    int[][] dp = new int[coins.length][amount + 1];

    for (int i = 0; i < coins.length; ++i) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
      dp[i][0] = 0;
    }

    for (int j = 1; j <= amount; ++j) {
      if (j - coins[0] >= 0 && j - coins[0] != Integer.MAX_VALUE) {
        dp[0][j] = Math.min(dp[0][j - coins[0]] + 1, dp[0][j]);
      }
    }

    for (int i = 1; i < coins.length; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= amount; j++) {
        if (j - coins[i] >= 0 && dp[i][j - coins[i]] != Integer.MAX_VALUE) {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return (dp[coins.length - 1][amount] == Integer.MAX_VALUE) ? -1 : dp[coins.length - 1][amount];
  }

  public static void main(String[] args) {
    CoinChange obj = new CoinChange();
    System.out.println(obj.coinChange2(new int[]{1, 2, 5}, 100));
    System.out.println(obj.coinChange2(new int[]{2}, 3));
  }

}
