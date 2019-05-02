package array;

// 167 https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
//输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
// 一定有解，函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
public class SortedTwoSum {

  public int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
      if (numbers[left] + numbers[right] < target) {
        left++;
      } else if (numbers[left] + numbers[right] > target) {
        right--;
      } else {
        return new int[]{left + 1, right + 1};
      }
    }
    return null;
  }

}
