package binarySearch;

/*
704. Binary Search
https://leetcode.com/problems/binary-search/
 */
// lower_bound 第一个大于等于target的元素下标
// upper_bound 第一个大于target的元素下标
public class BinarySearch {

  // Input: nums = [-1,0,3,5,9,12], target = 9
  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) { // 边界条件
      int mid = left + (right - left) / 2; // mid更靠近左边
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static int lower_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= target) { // 寻找第一个大于等于target的元素
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  public static int upper_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > target) { // 寻找第一个大于target的元素
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }


  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 6, 6, 6}; // [0,9]

    System.out.println("search = " + search(arr, 5));

    System.out.println("lower_bound 5 = " + lower_bound(arr, 5));
    System.out.println("lower_bound 6 = " + lower_bound(arr, 6));
    System.out.println("lower_bound 7 = " + lower_bound(arr, 7));

    System.out.println("upper_bound 5 = " + upper_bound(arr, 5));
    System.out.println("upper_bound 6 = " + upper_bound(arr, 6));
    System.out.println("upper_bound 7 = " + upper_bound(arr, 7));
  }
}
