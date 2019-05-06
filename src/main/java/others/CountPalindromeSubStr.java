package others;

// 647 https://leetcode-cn.com/problems/palindromic-substrings/
// 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

public class CountPalindromeSubStr {

  public int countSubstrings(String s) {
    int count = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    // 无需初始化
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
        if (dp[i][j]) {
          count++;
        }
      }
    }
    return count;
  }

}
