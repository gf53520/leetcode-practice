package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/subsets-ii/
//输入: [1,2,2]
//输出:
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
public class SubsetsII {

  public void dfs(int len, int start, List<Integer> state, List<List<Integer>> result, int[] nums) {
    if (state.size() >= len) {
      result.add(new ArrayList<>(state));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      if (i != start && nums[i - 1] == nums[i]) { // skip same value
        continue;
      }
      state.add(nums[i]);
      dfs(len, i + 1, state, result, nums);
      state.remove(state.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    if (nums.length == 0) {
      return new ArrayList<>();
    }

    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> state = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      dfs(i, 0, state, result, nums);        // len: 0,1,2,...,n
    }
    return result;
  }
}
