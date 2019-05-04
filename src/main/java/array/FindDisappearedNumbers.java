package array;

import java.util.ArrayList;
import java.util.List;

// 448. 找到所有数组中消失的数字
// https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
/*
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
找到所有在 [1, n] 范围之间没有出现在数组中的数字。
您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
输入:
[4,3,2,7,8,2,3,1] =>
输出:
[5,6]
 */
public class FindDisappearedNumbers {
  public List<Integer> findDisappearedNumbers(int[] nums) {
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
        solutions.add(i + 1);
      }
    }
    return solutions;
  }

  public static void main(String[] args) {
    FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
    System.out.println(findDisappearedNumbers.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
  }
}
