package dp;

// 494 https://leetcode-cn.com/problems/target-sum/
/*
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释:
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
一共有5种方法让最终目标和为3。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// dfs/二进制策略，但是含有重复运算
// DP
// dp[i][j] 使用0到i元素得到的和值为j的所有方法数
// dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
// solution = dp[i-1][S]
public class FindTargetSumWays {

  public int findTargetSumWays(int[] nums, int S) {
    int sum = Arrays.stream(nums).sum();
    if (Math.abs(sum) < Math.abs(S)) {
      return 0;
    }
    return findTargetSumWays(nums, S, 0);
  }

  public int findTargetSumWays(int[] nums, int state, int depth) {
    if (depth >= nums.length) {
      if (state == 0) {
        return 1;
      }
      return 0;
    }
    return findTargetSumWays(nums, state - nums[depth], depth + 1) +
        findTargetSumWays(nums, state + nums[depth], depth + 1);
  }


  // 只需要
  //我们刚刚思路中用的dp的第二个下标是可以为负数的，范围为[-sum,sum]（排除掉S>sum和S<-sum这两种已知无解的情况）。
  // 然而我们程序中数组的下标是从0开始的，所以我们把这个下标的值都加上一个sum，让它的范围变成[0,2*sum]
  public int findTargetSumWaysDP(int[] nums, int S) {
    int sum = Arrays.stream(nums).sum();
    if (Math.abs(sum) < Math.abs(S)) {
      return 0;
    }

    int doubleSum = Math.abs(sum) << 1;
    int[][] dp = new int[nums.length][doubleSum + 1];

    if (nums[0] == 0) {
      dp[0][Math.abs(sum)] = 2;
    } else {
      dp[0][Math.abs(sum) - nums[0]] = 1;
      dp[0][Math.abs(sum) + nums[0]] = 1;
    }

    // 仅考虑符合条件的j[0, doubleSum]，其他情况下均为0
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j <= doubleSum; j++) {
        if (j - nums[i] >= 0) {
          dp[i][j] += dp[i - 1][j - nums[i]];
        }
        if (j + nums[i] <= doubleSum) {
          dp[i][j] += dp[i - 1][j + nums[i]];
        }
      }
    }
    return dp[nums.length - 1][Math.abs(sum) + S];
  }

  public static void main(String[] args) {
    FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
    System.out.println(findTargetSumWays.findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    }, 0));
    System.out.println(findTargetSumWays.findTargetSumWaysDP(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    }, 0));
//    System.out.println(findTargetSumWays.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//    System.out.println(findTargetSumWays.findTargetSumWaysDP(new int[]{1, 1, 1, 1, 1}, 3));
  }
}
