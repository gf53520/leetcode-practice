package binarySearch;

/*
https://leetcode-cn.com/problems/search-a-2d-matrix
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

{1, 3, 5, 7},
{10, 11, 16, 20},
{23, 30, 34, 50}
=>
 1,3,5,7,10,11,16,20,23,30,34,50
 4
 */
public class SearchMatrix {

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }
    int rows = matrix.length;
    int cols = matrix[0].length;

    int low = 0;
    int high = rows * cols;
    while (low < high) {  // upper_bound
      int mid = low + (high - low) / 2;
      int ele = matrix[mid / cols][mid % cols];
      if (ele >= target) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    if ((low / cols) == rows || (low % cols) == cols) return false;
    return matrix[low / cols][low % cols] == target;
  }


  public static void main(String[] args) {
    int[][] matrix = new int[][]{
//        {1},
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };
    boolean exists = searchMatrix(matrix, 2);
    System.out.println("exists = " + exists);
  }

}
