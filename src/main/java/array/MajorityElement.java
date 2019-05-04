package array;

// 169 求众数 https://leetcode-cn.com/problems/majority-element/
// 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素
// 输入: [3,2,3]
// 输出: 3
// 输入: [2,2,1,1,1,2,2]
// 输出: 2
// 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
public class MajorityElement {
  public int majorityElement(int[] nums) {
    int last = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == last) {
        count++;
      } else {
        if (--count == 0) {
          last = nums[i];
          count = 1;
        }
      }
    }
    return last;
  }

  public static void main(String[] args) {
    MajorityElement majorityElement = new MajorityElement();
    System.out.println(majorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    System.out.println(majorityElement.majorityElement(new int[]{3, 2, 3}));
  }
}
