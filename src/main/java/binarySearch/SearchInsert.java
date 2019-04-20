package binarySearch;

/*
35. Search Insert Position
Given a sorted array and a target value,
return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.
https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsert {
  // 二分查找本身返回元素应该插入的位置， 返回第一个index的值大于或者等于target
  public static int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
//      System.out.println("before: " + left + " " + mid + " " + right);
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
//      System.out.println("after: " + left + " " + mid + " " + right);
    }
    return left;
  }

  // [1,3,5,6],5 => 2
  // [1,3,5,6],2 => 1
  // [1,3,5,6],7 => 4
  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 6};
    System.out.println("res = " + searchInsert(arr, 4));
    System.out.println("res = " + searchInsert(arr, 2));
    System.out.println("res = " + searchInsert(arr, 7));
  }
}
