package array;

import java.util.Arrays;

// 41. 缺失的第一个正数 https://leetcode-cn.com/problems/first-missing-positive/
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
/*
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
输入: [1,2,0]
输出: 3
Input: [3,4,-1,1]
Output: 2
 */
// 目标数组第i位存i+1， nums[i] = i+1; nums[nums[i]-1] = nums[i]
public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    if (nums == null) {
      return 1;
    }

    for (int i = 0; i < nums.length; i++) {
      while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
        int tmp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = tmp;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

}
