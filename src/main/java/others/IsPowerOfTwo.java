package others;

// 231 https://leetcode-cn.com/problems/power-of-two/
// 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
// 1->true, 32->true, 218->false
// 34/2 , 34/4, 34/8, 34/16 34/32
public class IsPowerOfTwo {

  public boolean isPowerOfThree(int n) {
    if (n == 0) {
      return false;
    }
    while (n % 3 == 0) {  // 48 -> 16
      n = n / 3;
    }
    return n == 1;
  }

  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }


  public boolean isPowerOfTwo2(int n) {
    if (n == 1) {
      return true;
    }

    if (n % 2 == 1 || n == 0) return false;
    return isPowerOfTwo(n / 2);
  }

  public static void main(String[] args) {
    IsPowerOfTwo powerOfTwo = new IsPowerOfTwo();
//    System.out.println(powerOfTwo.isPowerOfTwo(3));
//    System.out.println(powerOfTwo.isPowerOfTwo(218));
    System.out.println(powerOfTwo.isPowerOfTwo(64));
  }

}
