package others;

// 60 https://leetcode-cn.com/problems/permutation-sequence/
//  第k个排列
/*
输入: n = 3, k = 3
输出: "213"
  "123"
  "132"
  "213"
  "231"
  "312"
  "321"

算出来, 对于n=4, k=15 找到k=15排列的过程:
  1 + 对2,3,4的全排列 (3!个)
  2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
  3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
  4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)
*/
// 可转换为 nextPermutation 问题
public class GetKthPermutation {


  public String getPermutation(int n, int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      sb.append(i);
    }
    if (k == 1) {
      return sb.toString();
    }

    int[] fibo = new int[n + 1];
    fibo[0] = 1;
    for (int i = 1; i <= n; i++) {
      fibo[i] = i * fibo[i - 1];
    }

    k--;
    StringBuilder res = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      int index = k / fibo[n - i];
      k = k % fibo[n - i];
      res.append(sb.charAt(index));
      sb.deleteCharAt(index);
    }
    return res.toString();
  }

  public static void main(String[] args) {
    GetKthPermutation obj = new GetKthPermutation();
    String permutation = obj.getPermutation(4, 14);
    System.out.println("permutation = " + permutation);
  }

}
