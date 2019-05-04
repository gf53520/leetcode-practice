package array;

// 287 https://leetcode-cn.com/problems/find-the-duplicate-number/
/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
输入: [1,3,4,2,2]
输出: 2
输入: [3,1,3,4,2]
输出: 3
 */
// 1,3,4,2,2
// l  m  r

// 或者快慢指针找到环的起点
public class ArrayFindDuplicates {

  public int findDuplicates(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int cut = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) cut++;
      }
      if (cut > mid) { // 寻找第一个count(i) > mid where nums[i] <= mid 的元素的下标
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    ArrayFindDuplicates findDuplicate = new ArrayFindDuplicates();
    System.out.println(findDuplicate.findDuplicates(new int[]{1, 3, 4, 2, 2}));
    System.out.println(findDuplicate.findDuplicates(new int[]{3, 1, 3, 4, 2}));
  }

}
