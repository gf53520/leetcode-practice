package binarySearch;

/*
153. Find Minimum in Rotated Sorted Array
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */

// [->Max,Min->]
public class RotatedFindMin {

  // [4,5,6,7,0,1,2]
  public static int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < nums[right]) { // 后半段递增, 最小值在左边
        right = mid;
      } else if (nums[mid] > nums[right]) { // 前半段递增，最小值在右边
        left = mid + 1;
      } else { // 当mid与right值相等
        right--;
      }
    }
    return nums[left];
  }

  public static void main(String[] args) {
//    int[] arr = {3,4,5,1,2};
//    int[] arr = {1, 2, 3};
    int[] arr = {1, 2};
//    int[] arr = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("res = " + findMin(arr));
  }
}
