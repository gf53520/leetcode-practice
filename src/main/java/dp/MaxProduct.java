package dp;

// 152. 乘积最大子序列 https://leetcode-cn.com/problems/maximum-product-subarray/
/*
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
// dp[i][max], 以i结尾的最大子数组
// dp[i][min], 以i结尾的最小子数组
// dp[i][max], max(max(dp[i-1][max] * nums[i], dp[i-1][min] * nums[i]), nums[i]);
// dp[i][min], min(min(dp[i-1][max] * nums[i], dp[i-1][min] * nums[i]), nums[i]);
// solution: dp[i] = max(dp[0..n-1][0], dp[0..n-1][1])
public class MaxProduct {

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int res = nums[0];
    int dpMax = nums[0];
    int dpMin = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int tmp = dpMax; // 注意dpMin中引用了更新后的dpMax，因此dpMax需要暂存下
      dpMax = Math.max(nums[i], Math.max(dpMax * nums[i], dpMin * nums[i]));
      dpMin = Math.min(nums[i], Math.min(tmp * nums[i], dpMin * nums[i]));
      res = Math.max(dpMax, res);
    }

    return res;
  }

  public static void main(String[] args) {
    MaxProduct maxProduct = new MaxProduct();
    System.out.println(maxProduct.maxProduct(new int[]{-4, -3, -2}));
  }
}
