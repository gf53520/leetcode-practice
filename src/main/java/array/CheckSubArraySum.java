package array;

import java.util.HashSet;

// 523 连续子数组和 https://leetcode-cn.com/problems/continuous-subarray-sum/
/*
给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
其size至少为2，总和为 k 的倍数，即总和为 n*k，其中n为正数。
输入: [23,2,4,6,7], k = 6
输出: True
解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。

输入: [23,2,6,4,7], k = 6
输出: True
解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 */
// 方法1，暴利求解
// 方法2 ：若数字a和b分别除以数字c，若得到的余数相同，那么(a-b)必定能够整除c, 其中a>b
// a = k1*c + mod, b = k2*c + mod  => a-b = (k1-k2)*c
public class CheckSubArraySum {

  // 子数组至少需要两个数字, 因此不能马上放入当前prefixSum，需要隔一个
  // i=0, empyty, i=1, ps[0], i=2, ps[1]
  public boolean checkSubarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    HashSet<Integer> set = new HashSet<>();
    int prev = 0;
    int prefixSum = 0;
    for (int i = 0; i < nums.length; i++) {
      prefixSum = prefixSum + nums[i];
      int mod = (k == 0) ? prefixSum : (prefixSum % k);
      if (set.contains(mod)) {
        return true;
      }
      set.add(prev);
      prev = mod;
    }
    return false;
  }

  public boolean checkSubarraySum2(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    // 子数组至少需要两个数字, j从i+1开始
    for (int i = 0; i < nums.length; i++) {
      int prefixSum = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        prefixSum = prefixSum + nums[j];
        if (k == prefixSum) return true;
        if (k != 0 && prefixSum % k == 0) return true;
      }
    }
    return false;
  }


}
