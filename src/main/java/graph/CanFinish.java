package graph;

import java.util.LinkedList;

//现在你总共有 n 门课需要选，记为 0 到 n-1。
//在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
//给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？ 1 -> 0
//示例 1:
//输入: 2, [[1,0]]
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。


//示例 2:
//输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
//
//链接：https://leetcode-cn.com/problems/course-schedule
public class CanFinish {

  // 1. bfs
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 0 || prerequisites.length == 0) {
      return true;
    }
    int[] indegrees = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      indegrees[prerequisites[i][0]] += 1;
    }

    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < indegrees.length; i++) {
      if (indegrees[i] == 0) {
        queue.addLast(i);
      }
    }
    while (!queue.isEmpty()) {
      Integer element = queue.removeFirst();
      numCourses--;
      for (int i = 0; i < prerequisites.length; i++) {
        if (prerequisites[i][1] == element) {
          indegrees[prerequisites[i][0]] -= 1;
          if (indegrees[prerequisites[i][0]] == 0) {
            queue.addLast(prerequisites[i][0]);
          }
        }
      }
    }
    return numCourses == 0;
  }

  // 2. dfs
  public boolean canFinish2(int numCourses, int[][] prerequisites) {
    int[][] adjacency = new int[numCourses][numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      adjacency[prerequisites[i][1]][prerequisites[i][0]] = 1;
    }

    int[] state = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(i, adjacency, state)) {
        return false;
      }
    }
    return true;
  }


  public boolean dfs(int nodeIndex, int[][] adjacency, int[] state) {
    if (state[nodeIndex] == -1) {
      return true;
    }
    if (state[nodeIndex] == 1) { // already is eq 1, graph has circle
      return false;
    }
    state[nodeIndex] = 1;
    for (int j = 0; j < adjacency[nodeIndex].length; j++) {
      if (adjacency[nodeIndex][j] == 1) {
        if (!dfs(j, adjacency, state)) {
          return false;
        }
      }
    }
    state[nodeIndex] = -1;
    return true;
  }
}