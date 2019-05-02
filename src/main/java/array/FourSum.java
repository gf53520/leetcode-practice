package array;

//18 https://leetcode-cn.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> solutions = new ArrayList<>();

    if (nums.length <= 3)
      return solutions;
    if (nums.length == 4) {
      if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
        solutions.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
      }
      return solutions;
    }
    Arrays.sort(nums); // -2, -1, 0, 0, 1, 2
    for (int first = 0; first < nums.length - 3; first++) {
      if (first > 0 && nums[first] == nums[first - 1]) continue; // 去重

      for (int second = first + 1; second < nums.length - 2; second++) {
        if (second > first + 1 && nums[second] == nums[second - 1]) continue; // 去重

        int cutTarget = target;
        cutTarget = cutTarget - nums[first] - nums[second];

        int left = second + 1; // 只考虑后续中挑选余下2个数，去重
        int right = nums.length - 1;
        while (left < right) {
          if (nums[left] + nums[right] < cutTarget) {
            left++;
          } else if (nums[left] + nums[right] > cutTarget) {
            right--;
          } else {
            solutions.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));
            while (left < right && nums[left] == nums[++left]) ;  // 去重
            while (left < right && nums[right] == nums[--right]) ; // 去重
          }
        }
      }
    }
    return solutions;
  }

  public static void main(String[] args) {
    FourSum fourSum = new FourSum();
    int[] nums = new int[]{1, 0, -1, 0, -2, 2};
    List<List<Integer>> lists = fourSum.fourSum(nums, 0);
    System.out.println("lists = " + lists);
  }
}
