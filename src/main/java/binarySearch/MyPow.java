package binarySearch;
/*
50. Pow(x, n)
https://leetcode.com/problems/powx-n/
Implement pow(x, n), which calculates x raised to the power n (xn).
 */
// 50, 减少乘法次数, logn
public class MyPow {

  // myPow(x, n) =>
  //  myPow(x, n/2) * myPow(x, n/2) 偶数
  //  myPow(x, n/2) * myPow(x, n/2) (* x) 奇数
  public double myPow(double x, long n) {
    if (n == 0)
      return 1;

    if (n < 0) {
      n = -n;
      x = 1 / x;
    }

    double val = myPow(x, n / 2);
    if (n % 2 == 1) {
      return val * val * x;
    }
    return val * val;
  }
}
