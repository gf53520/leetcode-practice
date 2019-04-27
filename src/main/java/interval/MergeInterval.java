package interval;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// 56
//给出一个区间的集合，请合并所有重叠的区间。
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class MergeInterval {

  public int[][] merge(int[][] intervals) {
    if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
      return new int[][]{};
    }

    ArrayList<Interval> lists = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      lists.add(new Interval(intervals[i][0], intervals[i][1]));
    }
    Collections.sort(lists, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.getStart() - o2.getStart();
      }
    });


    ArrayList<Interval> solutions = new ArrayList<>();
//    int start = lists.get(0).getStart();
//    int end = lists.get(0).getEnd();
    for (int i = 1; i < lists.size(); i++) {
      Interval cut = lists.get(i);
      if (solutions.isEmpty() ||
          cut.getStart() > solutions.get(solutions.size() - 1).getEnd()) {
        solutions.add(cut);
      } else {
        solutions.get(solutions.size() - 1).setEnd(Math.max(cut.getEnd(),
            solutions.get(solutions.size() - 1).getEnd()));
      }
//      if (cut.getStart() > end) {
//        solutions.add(new Interval(start, end));
//        start = cut.getStart();
//        end = cut.getEnd();
//      } else {
//        end = Math.max(end, cut.getEnd());
//      }
    }
//    solutions.add(new Interval(start, end));

    int[][] res = new int[solutions.size()][];
    for (int i = 0; i < solutions.size(); i++) {
      res[i] = new int[]{solutions.get(i).getStart(), solutions.get(i).getEnd()};
    }
    return res;
  }

  public static void main(String[] args) {
    MergeInterval interval = new MergeInterval();
//    int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    int[][] ints = {{1, 4}, {4, 5}};
    int[][] merges = interval.merge(ints);
    System.out.println("merges = " + merges);
  }

}
