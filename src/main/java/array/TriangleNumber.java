package array;

// 611 https://leetcode-cn.com/problems/valid-triangle-number/
// 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数
// a+b>=c, a <=b<= c

import java.util.Arrays;

public class TriangleNumber {


  // [2,2,3,4] => 3
  public int triangleNumber(int[] nums) {
    if (nums.length <= 2) {
      return 0;
    }

    Arrays.sort(nums);
    int count = 0;
    for (int i = 2; i < nums.length; i++) {
      int min = nums[i];
      int left = 0;
      int right = i - 1;

      while (left < right) {
        int value = nums[left] + nums[right];
        if (value <= min) {
          left++;
        } else {
          if (nums[right] != 0) {
            count += right - left;
          }
          right--;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{2, 2, 3, 4};
    TriangleNumber triangleNumber = new TriangleNumber();
    System.out.println("res = " + triangleNumber.triangleNumber(nums));
  }
}
