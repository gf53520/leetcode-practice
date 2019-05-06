package array;

import java.util.LinkedList;

// 239 https://leetcode.com/problems/sliding-window-maximum/
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
// 输出: [3,3,5,5,6,7]

// [1,3,-1,-3,5,3,6,7], len=8, k=3
// stack: 1
// stack: 3
// stack: 3 -1
// stack: 3 -1 -3 =>
// stack: 3 -1 -3 => -1 -3 => 5
public class MaxSlidingWindow {

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) {
      return new int[0];
    }
    int[] solutions = new int[nums.length - k + 1];
    LinkedList<Integer> indices = new LinkedList<>();

    for (int i = 0; i < nums.length; i++) {
      int cut = nums[i];

      if (!indices.isEmpty() && i - indices.getFirst() >= k) {
        indices.pollFirst();
      }

      // 添加到队列尾部
      while (!indices.isEmpty() && nums[indices.getLast()] <= cut) {
        indices.pollLast();
      }
      indices.add(i);
      if (i >= k - 1) {
        solutions[i - k + 1] = nums[indices.peek()];
      }
    }
    return solutions;
  }

  public static void main(String[] args) {
    MaxSlidingWindow slidingWindow = new MaxSlidingWindow();
    System.out.println(slidingWindow.maxSlidingWindow(
        new int[]{1, 3, 1, 2, 0, 5}, 3
    ));
//    System.out.println(slidingWindow.maxSlidingWindow(
//        new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3
//    ));
    System.out.println("over");
  }

}
