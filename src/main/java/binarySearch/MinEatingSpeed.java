package binarySearch;

import java.util.Arrays;

/*
875. Koko Eating Bananas
https://leetcode.com/problems/koko-eating-bananas/
Return the minimum integer K such that she can eat all the bananas within H hours.
 */
public class MinEatingSpeed {
  public static int minEatingSpeed(int[] piles, int H) {
    int left = 1;
    int right = (int) Math.pow(10, 9);
    while (left < right) {
      int speed = left + (right - left) / 2;
      int h = 0;
      for (int value : piles) {
        h += (value - 1) / speed + 1;
      }
      System.out.println(h + " " + left + " " + speed + " " + right);
      if (h <= H) { // 速度过快
        right = speed;
      } else {
        left = speed + 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] arr = {30, 11, 23, 4, 20};
    System.out.println(" = " + minEatingSpeed(arr, 5));
  }
}
