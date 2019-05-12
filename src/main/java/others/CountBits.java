package others;

//338. 比特位计数 https://leetcode-cn.com/problems/counting-bits/
/*
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
计算其二进制数中的 1 的数目并将它们作为数组返回。
输入: 2
输出: [0,1,1]
输入: 5
输出: [0,1,1,2,1,2]
 */
public class CountBits {

  // n & (n - 1) 表示将n的二进制低位最后一位变为0
  public int[] countBits(int num) {
    int[] res = new int[num + 1];
    res[0] = 0;
    for (int i = 1; i <= num; i++) {
      res[i] = res[i & (i - 1)] + 1;
    }
    return res;
  }

}
