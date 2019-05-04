package array;

import java.util.ArrayList;
import java.util.List;

// 442 https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
/*
给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
找到所有出现两次的元素
你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
输入:
[4,3,2,7,8,2,3,1]
输出:
[2,3]
 */
// 目标数组第i位存i+1， nums[i] = i+1; nums[nums[i]-1] = nums[i]
public class ArrayFindAllDuplicates {

  public List<Integer> findDuplicates(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[nums[i] - 1] != nums[i]) {
        int tmp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = tmp;
      }
    }

    ArrayList<Integer> solutions = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        solutions.add(nums[i]);
      }
    }
    return solutions;
  }

  public static void main(String[] args) {
    ArrayFindAllDuplicates allDuplicates = new ArrayFindAllDuplicates();
    System.out.println(allDuplicates.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
  }
}
