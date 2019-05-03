package array;

// 16 https://leetcode.com/problems/3sum-closest/
// Return the sum of the three integers
// Given array nums = [-4, -1, 1, 2], and target = 1.
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

import java.util.Arrays;

public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    if (nums.length <= 2)
      return -1;

    Arrays.sort(nums);
    int solution = nums[0] + nums[1] + nums[2]; // 提前给出一个解
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int value = nums[i] + nums[left] + nums[right];
        if (Math.abs(value - target) < Math.abs(solution - target)) {// 判断是否更新
          solution = value;
        }
        if (value < target) {
          left++;
        } else if (value > target) {
          right--;
        } else { // 没有再更接近的了
          return value;
        }
      }
    }
    return solution;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, -1, -1, 2};
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    System.out.println("res = " + threeSumClosest.threeSumClosest(nums, -1));
  }
}
