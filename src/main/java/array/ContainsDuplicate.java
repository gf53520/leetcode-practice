package array;

import java.util.Set;
import java.util.HashSet;

// 217
public class ContainsDuplicate {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int ele : nums) {
      if (set.contains(ele)) {
        return true;
      }
      set.add(ele);
    }
    return false;
  }

}
