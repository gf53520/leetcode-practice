package binarySearch;

/*
69. Sqrt(x)
Compute and return the square root of x,
where x is guaranteed to be a non-negative integer.
Since the return type is an integer, the decimal digits are truncated
and only the integer part of the result is returned.
https://leetcode.com/problems/sqrtx/
 */
public class MySqrt {
  // 相当于在[0, x]找到一个最小的整数的平方大于x, 注意数据溢出问题
  public static int mySqrt(int x) {
    if (x < 1) {
      return 0;
    }
    int left = 0;
    int right = x;

    while (left < right) {
      int mid = left + (right - left) / 2;
//      System.out.println("before: " + left + " " + mid + " " + right);
      if (mid > x / mid) {
        right = mid;
      } else {
        left = mid + 1;
      }
//      System.out.println("after: " + left + " " + mid + " " + right);
    }
    return left - 1;
  }

  public static void main(String[] args) {
    System.out.println(" = " + mySqrt(3));
    System.out.println(" = " + mySqrt(4));
    System.out.println(" = " + mySqrt(7));
    System.out.println(" = " + mySqrt(8));
    System.out.println(" = " + mySqrt(2147395599));
  }
}
