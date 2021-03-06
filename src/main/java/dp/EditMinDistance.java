package dp;

// 72 编辑距离 https://leetcode-cn.com/problems/edit-distance/
/*
给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符
示例 1:

输入: word1 = "horse", word2 = "ros"
输出: 3
解释:
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
 */
// dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
// i为word1单词index+1，j为word2单词index+1,
public class EditMinDistance {

  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= word2.length(); j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }

  public static void main(String[] args) {
    EditMinDistance editMinDistance = new EditMinDistance();
    System.out.println(editMinDistance.minDistance("horse", "ros"));
    System.out.println(editMinDistance.minDistance("intention", "execution"));
  }
}
