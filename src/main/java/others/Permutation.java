package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 46 给定一个没有重复数字的序列，返回其所有可能的全排列。
public class Permutation {

  public List<List<Integer>> permutation(int[] nums) {
    List<List<Integer>> solutions = new ArrayList<>();
    if (nums.length == 0) {
      return solutions;
    }

    boolean[] visited = new boolean[nums.length];
    permute(nums, solutions, visited, new ArrayList<>());
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


  public List<List<Integer>> permutation2(int[] nums) {
    List<List<Integer>> solutions = new ArrayList<>();
    if (nums.length == 0) {
      return solutions;
    }
    permute2(0, nums, solutions, new ArrayList<>());
    return solutions;
  }

  public void permute2(int depth, int[] nums, List<List<Integer>> solutions, List<Integer> state) {
    if (state.size() >= nums.length) {
      solutions.add(new ArrayList<>(state));
      return;
    }

    for (int i = depth; i < nums.length; i++) {
      swap(depth, i, nums);
      state.add(nums[depth]);
      permute2(depth + 1, nums, solutions, state);
      state.remove(state.size() - 1);
      swap(depth, i, nums);
    }
  }

  public void swap(int index1, int index2, int[] nums) {
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }


  public static void main(String[] args) {
    Permutation permutation = new Permutation();
//    List<List<Integer>> results = permutation.permutation(new int[]{1, 2, 3, 4});
    List<List<Integer>> results = permutation.permutation2(new int[]{1, 2, 3, 4});
    for (List<Integer> list : results) {
      System.out.println(Arrays.toString(list.toArray(new Integer[0])));
    }
    System.out.println("size = " + results.size());
  }
}
