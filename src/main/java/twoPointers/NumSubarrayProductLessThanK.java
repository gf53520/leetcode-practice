package twoPointers;

// 713 乘积小于K的子数组 https://leetcode-cn.com/problems/subarray-product-less-than-k/
/*
给定一个 正整数数组 nums。找出该数组内乘积小于 k 的连续的子数组的个数。
输入: nums = [10,5,2,6], k = 100
输出: 8
解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 */

// 双指针，均从0开始
public class NumSubarrayProductLessThanK {


  // [10,5,2,6] => right = 2, left = 1
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int solution = 0;

    int state = 1, left = 0;
    for (int right = 0; right < nums.length; right++) {
      state = state * nums[right];
      while (left <= right && state >= k) {
        state = state / nums[left++];
      }
      solution += right - left + 1;
    }
    return solution;
  }

  public static void main(String[] args) {
    NumSubarrayProductLessThanK obj = new NumSubarrayProductLessThanK();
    System.out.println(obj.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
  }

}
