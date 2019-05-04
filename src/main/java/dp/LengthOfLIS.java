package dp;

// 300 最长上升子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
// 并非一定为子数组
// dp[i]，以i为结尾的LIS长度
// dp[i] = max(dp[0..i-1] + 1, 1) (a[i]>=a[j])
// solution = max(dp(0..i));
public class LengthOfLIS {

  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] dp = new int[nums.length];
    dp[0] = 1;
    int solution = 1;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = 1; // 默认值
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      solution = Math.max(solution, dp[i]);
    }
    return solution;
  }

  public static void main(String[] args) {
    LengthOfLIS lengthOfLIS = new LengthOfLIS();
    System.out.println(lengthOfLIS.lengthOfLIS(new int[]{2, 2}));
    System.out.println(lengthOfLIS.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
    System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 4}));
    System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
  }
}
