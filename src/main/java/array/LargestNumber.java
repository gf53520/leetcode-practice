package array;

import java.util.Arrays;
import java.util.stream.Collectors;

// 179 最大数
/*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
输入: [10,2]
输出: 210
输入: [3,30,34,5,9]
输出: 9534330
 */
// 3放在了34和30中间, 比较34-3和3-34，30-3和3-30
public class LargestNumber {

  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return "";
    }
    String[] strings = new String[nums.length];
    int i = 0;
    for (int num : nums) {
      strings[i++] = String.valueOf(num);
    }

    Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
    if ("0".equals(strings[0])) {
      return "0";
    }
    return Arrays.stream(strings).collect(Collectors.joining(""));
  }

  public static void main(String[] args) {
    LargestNumber largestNumber = new LargestNumber();
    System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
  }
}
