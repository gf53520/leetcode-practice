package others;

import java.util.Arrays;

// 31
// 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
// 必须原地修改，只允许使用额外常数空间。
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class NextPermutation {

  public static void nextPermutation(int[] nums) {
    if (nums.length <= 1) {
      return;
    }

    // 1, 3, 2
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i + 1] > nums[i]) {
        int j;
        for (j = nums.length - 1; j > i; --j) {
          if (nums[j] > nums[i])
            break;
        }
        swap(nums, i, j);
        reverse(nums, i + 1);
        return;
      }
    }
    reverse(nums, 0);
  }

  public static void reverse(int[] nums, int start) {
    for (int end = nums.length - 1; start < end; start++, end--) {
      swap(nums, start, end);
    }
  }

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    NextPermutation obj = new NextPermutation();
//    int[] nums = new int[]{1, 2, 7, 4, 3, 1};
//    int[] nums = new int[]{4, 3, 2, 1};
    int[] nums = new int[]{1, 3, 2};
    obj.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

}
