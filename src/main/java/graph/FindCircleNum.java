package graph;

// 547. 朋友圈 https://leetcode-cn.com/problems/friend-circles/
/*
班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。

给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，
表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
输入:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
输出: 2
说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
第2个学生自己在一个朋友圈。所以返回2。

输入:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
输出: 1
说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，
所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 */
// 类似于leetcode 200 num islands
public class FindCircleNum {

  public int findCircleNum(int[][] M) {
    if (M.length == 0 || M[0].length == 0) {
      return 0;
    }
    boolean[] visited = new boolean[M.length];
    int res = 0;
    for (int i = 0; i < M.length; i++) {
      if (visited[i]) continue;
      dfs(M, i, visited);
      res++;
    }
    return res;
  }

  private void dfs(int[][] M, int i, boolean[] visited) {
    if (visited[i]) {
      return;
    }
    visited[i] = true;
    for (int j = 0; j < M[i].length; j++) {
      if (M[i][j] != 1) continue;
      if (visited[j]) continue;
      dfs(M, j, visited);
    }
  }

}
