package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15: https://leetcode-cn.com/problems/3sum/
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
// 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> solutions = new ArrayList<>();

    if (nums.length <= 2)
      return solutions;
    if (nums.length == 3) {
      if (nums[0] + nums[1] + nums[2] == 0) {
        solutions.add(Arrays.asList(nums[0], nums[1], nums[2]));
      }
      return solutions;
    }

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
      int target = 0;
      target = target - nums[i];
      int left = i + 1; // 只考虑后续中挑选余下2个数，去重
      int right = nums.length - 1;
      while (left < right) {
        if (nums[left] + nums[right] < target) {
          left++;
        } else if (nums[left] + nums[right] > target) {
          right--;
        } else {
          solutions.add(Arrays.asList(nums[i], nums[left], nums[right]));
          while (left < right && nums[left] == nums[++left]) ;  // 去重
          while (left < right && nums[right] == nums[--right]) ; // 去重
        }
      }
    }
    return solutions;
  }

  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> lists = threeSum.threeSum(nums);
    System.out.println("lists = " + lists);
  }
}
