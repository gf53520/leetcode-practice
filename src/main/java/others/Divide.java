package others;

// 29 https://leetcode-cn.com/problems/divide-two-integers/, 除数不为 0。
//输入: dividend = 7, divisor = -3
//输出: -2
//不得使用符号 *、/、%
/*  33 = divide(100, 3) = multiply + divide(100-96,3)
  100 - 3
  100 - 6
  100 - 12
  100 - 24
  100 - 48
  100 - 96
*/
public class Divide {
  public int divide(long dividend, long divisor) {
    if (dividend == 0) {
      return 0;
    }
    int negative;
    if ((dividend > 0 && divisor > 0) ||
        (dividend < 0 && divisor < 0)) {
      negative = 1;
    } else {
      negative = -1;
    }
    long Ldividend = Math.abs(dividend);
    long Ldivisor = Math.abs(divisor);
    return (negative == 1) ? Ldivide(Ldividend, Ldivisor) : -Ldivide(Ldividend, Ldivisor);
  }

  public int Ldivide(long Ldividend, long Ldivisor) {
    if (Ldividend < Ldivisor) {
      return 0;
    }
    long sum = Ldivisor;
    int multiply = 1;
    while (sum + sum <= Ldividend) {
      sum = sum + sum;
      multiply += multiply;
    }
    return multiply + divide(Ldividend - sum, Ldivisor);
  }

  public static void main(String[] args) {
    Divide divide = new Divide();
    int res = divide.divide(10, 3);
    System.out.println("res = " + res);
  }
}
