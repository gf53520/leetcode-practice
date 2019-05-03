package array;

import java.util.HashMap;

// 560 https://leetcode-cn.com/problems/subarray-sum-equals-k/
/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
//  array         1 1 1
//  prefix sum: 0 1 2 3
//  [0] => p[1]-p[0], [0,1] => p[2]-p[0], [0,n-1] => p[n] - p[0]
//  [n-1] => p[n] - p[n-1], [n-2, n-1] => p[n] - p[n-2]
public class SubarraySum {
  public int subarraySum(int[] nums, int k) {
    if (nums.length == 0) {
      return 0;
    }
    int[] prefixSum = new int[nums.length + 1];
    prefixSum[0] = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }

    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (prefixSum[j + 1] - prefixSum[i] == k) {  // i->j和为k
          count++;
        }
      }
    }
    return count;
  }

  public int subarraySum2(int[] nums, int k) {
    if (nums.length == 0) {
      return 0;
    }
    int[] prefixSum = new int[nums.length + 1];
    prefixSum[0] = 0;
    for (int i = 1; i <= nums.length; i++) {
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }

    int count = 0;
    HashMap<Integer, Integer> mapping = new HashMap<>();
    mapping.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      int subtract = prefixSum[i + 1] - k; // p[j] - p[i] = k, 求多少个 p[i] = p[j] - k
      count += mapping.getOrDefault(subtract, 0);
      mapping.put(prefixSum[i + 1], mapping.getOrDefault(prefixSum[i + 1], 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    SubarraySum subarraySum = new SubarraySum();
    System.out.println(subarraySum.subarraySum2(new int[]{1, 2, 1, 2, 1}, 3));
  }
}
