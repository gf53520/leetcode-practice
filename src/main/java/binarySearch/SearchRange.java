package binarySearch;

/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order,
find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

  public static int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return new int[]{-1, -1};
    }
    int lower_bound = BinarySearch.lower_bound(nums, target);
    if (lower_bound == -1) {
      return new int[]{-1, -1};
    }
    int upper_bound = BinarySearch.upper_bound(nums, target);
    return new int[]{lower_bound, upper_bound};
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 1, 1, 5, 5, 6};
    System.out.println("res = " + BinarySearch.lower_bound(arr, 1));
    System.out.println("res = " + BinarySearch.upper_bound(arr, 1));
    System.out.println("res = " + BinarySearch.lower_bound(arr, 5));
    System.out.println("res = " + BinarySearch.upper_bound(arr, 5));
    System.out.println("res = " + BinarySearch.upper_bound(arr, 100));
  }

}