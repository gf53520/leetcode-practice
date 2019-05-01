package others;

import java.util.ArrayList;
import java.util.List;

// 46
// //给定一个没有重复数字的序列，返回其所有可能的全排列。
public class Permute {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> solutions = new ArrayList<>();
    if (nums.length == 0) {
      return solutions;
    }

    boolean[] visited = new boolean[nums.length];
    List<Integer> state = new ArrayList<>();
    permute(nums, solutions, visited, state);
    return solutions;
  }

  public void permute(int[] nums, List<List<Integer>> solutions,
                      boolean[] visited, List<Integer> state) {

    if (state.size() >= nums.length) {
      solutions.add(new ArrayList<>(state));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      state.add(nums[i]);
      permute(nums, solutions, visited, state);
      visited[i] = false;
      state.remove(state.size() - 1);
    }
  }

  public static void main(String[] args) {
    Permute permute = new Permute();
    permute.permute(new int[]{1, 2, 3});
    System.out.println("over");
  }

}
