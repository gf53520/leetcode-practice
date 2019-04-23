package others;

// 980: https://leetcode-cn.com/problems/unique-paths-iii/
//在二维网格 grid 上，有 4 种类型的方格：
//  1 表示起始方格。且只有一个起始方格。
//  2 表示结束方格，且只有一个结束方格。
//  0 表示我们可以走过的空方格。
//  -1 表示我们无法跨越的障碍。
//返回在四个方向（上、下、左、右）上行走时，
// 从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。

public class UniquePathsIII {

  public int uniquePathsIII(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    if (grid[0].length == 0) {
      return 0;
    }

    int n = 0;
    int start_row_index = 0;
    int start_column_index = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          n++;
        } else if (grid[i][j] == 1) {
          start_row_index = i;
          start_column_index = j;
        }
      }
    }
    return uniquePathsIII(grid, n, start_row_index, start_column_index);
  }

  public int uniquePathsIII(int[][] grid, int n, int row, int column) {
    // out of index
    if (row < 0 || row > grid.length - 1 || column < 0 || column > grid[0].length - 1) {
      return 0;
    }

    // blocked
    if (grid[row][column] == -1) {
      return 0;
    }

    if (grid[row][column] == 2) {
      return n == 0 ? 1 : 0;
    }

    grid[row][column] = -1;
    int solutions = uniquePathsIII(grid, n - 1, row - 1, column) +
        uniquePathsIII(grid, n - 1, row + 1, column) +
        uniquePathsIII(grid, n - 1, row, column - 1) +
        uniquePathsIII(grid, n - 1, row, column + 1);
    grid[row][column] = 0;

    return solutions;
  }
}
