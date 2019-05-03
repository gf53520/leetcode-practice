package others;

import java.util.ArrayList;
import java.util.List;

// 51  https://leetcode-cn.com/problems/n-queens/
/*
  输入: 4
  输出: [
   [".Q..",  // 解法 1
    "...Q",
    "Q...",
    "..Q."],

   ["..Q.",  // 解法 2
    "Q...",
    "...Q",
    ".Q.."]
  ]
 */
public class NQueens {

  public List<List<String>> solveNQueens(int n) {
    List<List<Integer>> solutions = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    solveNQueens(n, cols, 0, solutions);

    List<List<String>> finalRes = new ArrayList<>();
    for (List<Integer> solution : solutions) {
      ArrayList<String> strings = new ArrayList<String>();
      for (Integer col : solution) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
          if (i == col) {
            builder.append('Q');
          } else {
            builder.append('.');
          }
        }
        strings.add(builder.toString());
      }
      finalRes.add(strings);
    }
    return finalRes;
  }

  public void solveNQueens(int n, List<Integer> cols, int row,
                           List<List<Integer>> solutions) {
    if (row == n) { // 注意不是n-1
      solutions.add(new ArrayList<>(cols));
      return;
    }
    for (int i = 0; i < n; i++) { // 可选的列值
      if (isValid(cols, row, i)) {
        cols.add(i);
        solveNQueens(n, cols, row + 1, solutions);
        cols.remove(cols.size() - 1);
      }
    }
  }

  // 是否有相同列，以及对角线位置
  public boolean isValid(List<Integer> cols, int cutRow, int cutCol) {
    for (int i = 0; i < cols.size(); i++) {
      int row = i;
      int col = cols.get(i);
      if (col == cutCol) {
        return false;
      }
      if (Math.abs(col - cutCol) == (cutRow - row)) { // 对角线：列差等于行差
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    NQueens nQueens = new NQueens();
    List<List<String>> lists = nQueens.solveNQueens(4);
    System.out.println("size = " + lists.size());
    System.out.println("lists = " + lists);
  }

}
