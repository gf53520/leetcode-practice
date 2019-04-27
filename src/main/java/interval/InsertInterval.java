package interval;

import java.util.ArrayList;

// 57 https://leetcode.com/problems/insert-interval/
// 已排序且无overlap的intervals，插入新interval，并视情况merge
public class InsertInterval {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
      return new int[][]{newInterval};
    }
    if (newInterval == null || newInterval.length == 0) {
      return intervals;
    }

    ArrayList<Interval> solutions = new ArrayList<>();
    int start = newInterval[0];
    int end = newInterval[1];
    int breakerPoint = 0;
    for (; breakerPoint < intervals.length; breakerPoint++) {
      int[] cut = intervals[breakerPoint];
      if (cut[1] < start) {
        solutions.add(new Interval(cut[0], cut[1]));
      } else if (cut[0] > end) {
        solutions.add(new Interval(start, end));
        break;
      } else {
        start = Math.min(start, cut[0]);
        end = Math.max(end, cut[1]);
      }
    }

    if (breakerPoint == intervals.length) { // 自动结束，需要补充最后一个interval
      solutions.add(new Interval(start, end));
    } else {
      for (; breakerPoint < intervals.length; breakerPoint++) {// 提前结束，继续添加后续interval
        solutions.add(new Interval(intervals[breakerPoint][0], intervals[breakerPoint][1]));
      }
    }


    int[][] res = new int[solutions.size()][];
    for (int i = 0; i < solutions.size(); i++) {
      res[i] = new int[]{solutions.get(i).getStart(), solutions.get(i).getEnd()};
    }
    return res;
  }

  public static void main(String[] args) {
    InsertInterval insert = new InsertInterval();
//    int[][] ints = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//    int[][] inserts = insert.insert(ints, new int[]{4, 8});
    int[][] ints = {{1, 3}, {6, 9}};
    int[][] inserts = insert.insert(ints, new int[]{2, 5});
    System.out.println("inserts = " + inserts);
  }

}
