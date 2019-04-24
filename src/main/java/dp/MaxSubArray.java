package dp;

// 53 https://leetcode-cn.com/problems/maximum-subarray/
// 连续子数组最大值
public class MaxSubArray {

  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int prev = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] + prev > nums[i]) {
        prev = nums[i] + prev;
      } else {
        prev = nums[i];
      }
      max = Math.max(prev, max);
    }
    return max;
  }

  public static void main(String[] args) {
    MaxSubArray maxSubArray = new MaxSubArray();
    int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int res = maxSubArray.maxSubArray(ints);
    System.out.println("res = " + res);
  }
}
