package dp;

// 718 https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
/*
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释: 长度最长的公共子数组是 [3, 2, 1]。
 */
// dp[i][j] A以i结尾，B以j结尾公共子数组长度
// dp[i][j] = (A[i] == B[j])? dp[i-1][j-1] + 1: 0
public class MaxLenRepeatedSubarray {
  public int findLength(int[] A, int[] B) {

    return -1;
  }
}
