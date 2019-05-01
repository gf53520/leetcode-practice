package array;

import java.util.HashMap;
import java.util.Map;

// 219 https://leetcode-cn.com/problems/contains-duplicate-ii/
// 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
// 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
public class ContainsNearbyDuplicate {

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        Integer prevIndex = map.get(nums[i]);
        if (i - prevIndex <= k) {
          return true;
        }
      }
      map.put(nums[i], i);
    }
    return false;
  }

}
