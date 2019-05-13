package others;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

  public void dfs(int len, int start, List<Integer> state, List<List<Integer>> result, int[] nums) {
    if (state.size() >= len) {
      result.add(new ArrayList<>(state));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      state.add(nums[i]);
      dfs(len, i + 1, state, result, nums);
      state.remove(state.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    if (nums.length == 0) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> state = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      dfs(i, 0, state, result, nums);        // len: 0,1,2,...,n
    }
    return result;
  }

}
