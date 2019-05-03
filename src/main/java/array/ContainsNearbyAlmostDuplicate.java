package array;

import java.util.TreeSet;

// 220 https://leetcode-cn.com/problems/contains-duplicate-iii/
// 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i]
// 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为k。

public class ContainsNearbyAlmostDuplicate {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> set = new TreeSet<>();
    for (int i = 0; i < nums.length; i++) {
      long ele = nums[i];
      // 离当前ele最近的元素
      if (set.floor(ele) != null && ele - set.floor(ele) <= t ||
          set.ceiling(ele) != null && set.ceiling(ele) - ele <= t) {
        return true;
      }
      set.add(ele);
      if (i - k >= 0) { // 维持一个k区间的数组
        set.remove((long) nums[i - k]);
      }
    }
    return false;
  }

}
