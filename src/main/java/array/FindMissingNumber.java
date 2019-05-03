package array;

// 268 https://leetcode-cn.com/problems/missing-number/
// 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
/*
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
输入: [3,0,1]
输出: 2
输入: [9,6,4,2,3,5,7,0,1]
输出: 8
 */
// 4^4 = 0;
// 0^4 = 4;
public class FindMissingNumber {

  public int missingNumber(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      res ^= (nums[i] ^ i + 1); //先与1到n异或，再与nums数组异或，最终结果为缺失数字
    }
    return res;
  }

}

