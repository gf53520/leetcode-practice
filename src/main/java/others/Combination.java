package others;

import java.util.ArrayList;
import java.util.List;

// 77. Combinations
// https://leetcode.com/problems/combinations/
public class Combination {

  // C(n,k)
  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    ArrayList<Integer> state = new ArrayList<Integer>();
    combine(n, k, 1, state, result);
    return result;
  }

  public static void combine(int n, int k, int start, List<Integer> state,
                             List<List<Integer>> result) {
    if (state.size() == k) {
      result.add(new ArrayList<Integer>(state));
      return;
    }
    for (int i = start; i < n + 1; i++) {
      state.add(i);
      combine(n, k, i + 1, state, result);
      state.remove(state.size() - 1);
    }
  }

  public static void main(String[] args) {
    int m = 4;
    int k = 2;
    List<List<Integer>> combine = combine(m, k);
    System.out.println(" over ");
  }
}
