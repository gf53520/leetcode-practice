package binarySearch;

/*
704. Binary Search
https://leetcode.com/problems/binary-search/
 */
// 开区间搜索 [l, r) => while(l<r)
// 闭区间搜索 [l, r] => while(l<=r), 查找区间不为空
public class BinarySearch {

  // Input: nums = [-1,0,3,5,9,12], target = 9

  // [闭区间]搜索
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

  // [闭区间]搜索
  public static int lower_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int solution = -1;

    while (left <= right) { // 边界条件
      int mid = left + (right - left) / 2; // mid更靠近左边
      if (nums[mid] >= target) {
        if (nums[mid] == target) {
          solution = mid;
        }
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return solution;
  }

  // [闭区间]搜索
  public static int upper_bound(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int solution = -1;

    while (left <= right) { // 边界条件
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        left = mid + 1;
        solution = mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return solution;
  }


  public static void main(String[] args) {
    int[] arr = {0, 1, 2, 3, 4, 5, 6, 6, 6, 6}; // [0,9]

    System.out.println("search = " + search(arr, 5));

    System.out.println("lower_bound 6 = " + lower_bound(arr, 6));
    System.out.println("lower_bound 7 = " + lower_bound(arr, 7));

    System.out.println("upper_bound 6 = " + upper_bound(arr, 6));
    System.out.println("upper_bound 7 = " + upper_bound(arr, 7));
  }
}
