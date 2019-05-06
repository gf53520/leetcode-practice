package dp;

import java.util.Arrays;
import java.util.List;

// 139 单词拆分 https://leetcode-cn.com/problems/word-break/
/*
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
判定s是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
 */
// dp[i] 表示以i为结尾能否划分成单词
// dp[i] =  anyMatch(dp[j] && subString(j, i)), 其中0<j<i
public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0) {
      return false;
    }
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[s.length()];
  }

  public static void main(String[] args) {
    WordBreak wordBreak = new WordBreak();
    System.out.println(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
    System.out.println(wordBreak.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
  }
}
