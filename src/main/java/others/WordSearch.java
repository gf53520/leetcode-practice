package others;

// 79 https://leetcode-cn.com/problems/word-search/
// 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
// 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
public class WordSearch {

  // 注意需要考虑不同起始点
  public boolean exist(char[][] board, String word) {
    if (word == null || word.length() == 0) {
      return false;
    }
    if (board.length == 0 || board[0].length == 0) {
      return false;
    }
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (exist(board, word, 0, i, j, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean exist(char[][] board, String word, int index,
                       int row, int column, boolean[][] visited) {

    if (row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1) {
      return false;
    }
    if (visited[row][column]) {
      return false;
    }

    // success
    if (board[row][column] == word.charAt(index) && index == word.length() - 1) {
      return true;
    }

    if (board[row][column] != word.charAt(index)) {
      return false;
    }

    visited[row][column] = true;
    boolean exists = exist(board, word, index + 1, row - 1, column, visited) ||
        exist(board, word, index + 1, row + 1, column, visited) ||
        exist(board, word, index + 1, row, column - 1, visited) ||
        exist(board, word, index + 1, row, column + 1, visited);
    visited[row][column] = false;
    return exists;
  }

}
