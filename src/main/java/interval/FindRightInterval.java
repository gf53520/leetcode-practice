package interval;

import java.util.*;

// 436
//输入: [ [3,4], [2,3], [1,2] ]
//输出: [-1, 0, 1]
//
//解释:对于[3,4]，没有满足条件的“右侧”区间。
//对于[2,3]，区间[3,4]具有最小的“右”起点;
//对于[1,2]，区间[2,3]具有最小的“右”起点。
public class FindRightInterval {

  public int[] findRightInterval(int[][] intervals) {
    if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
      return new int[]{};
    }

    Map<Integer, Integer> mappings = new HashMap<>();
    ArrayList<Integer> lists = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      mappings.put(intervals[i][0], i);
      lists.add(intervals[i][0]);
    }
    Collections.sort(lists);

    ArrayList<Integer> solutions = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      // 寻找第一个大于等于end的start point
      int start = lower_bound(lists, intervals[i][1]);
      if (start < intervals[i][1]) {
        solutions.add(-1);
      } else {
        solutions.add(mappings.get(start));
      }
    }

    int[] res = new int[solutions.size()];
    for (int i = 0; i < solutions.size(); i++) {
      res[i] = solutions.get(i);
    }
    return res;
  }

  // 开区间[low, high)
  public int lower_bound(ArrayList<Integer> sorted, int element) {
    int low = 0;
    int high = sorted.size() - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      if (sorted.get(mid) >= element) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return sorted.get(low);
  }

  public static void main(String[] args) {
    FindRightInterval find = new FindRightInterval();
//    int[][] ints = {{1, 4}, {2, 3}, {3, 4}};
    int[][] ints = {{3, 4}, {2, 3}, {1, 2}};
    int[] res = find.findRightInterval(ints);
    System.out.println("res = " + res);

  }
}
