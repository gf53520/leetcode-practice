package dp;

// 5. Longest Palindromic Substring
public class LongestPalindromeSubStr {

  // dp[i][j], 表示从i到j是否为回文串
  // dp[i][j] = ch[i] == ch[j] && (j -i <= 2 || dp[i+1][j-1])
  // 从i侧来看，因为i需要使用i+1；从j侧看只使用了j-1，因此将j放到外层循环来执行dp
  public static String dp_LongestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    String solution = "";
    int max = Integer.MIN_VALUE;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
        if (dp[i][j]) {
          if (j - i + 1 > max) {
            max = j - i + 1;
            solution = s.substring(i, j + 1);
          }
        }
      }
    }
    return solution;
  }

  // babade
  // edabab
  // 最长回文子串，中心扩散方法, 需要注意回文数字的特征
  public static String longestPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    int maxLen = -1;
    String res = null;
    for (int i = 0; i < s.length(); i++) {
      String tmp1 = getlongest(s, i, i);
      if (tmp1.length() > maxLen) {
        maxLen = tmp1.length();
        res = tmp1;
      }
      String tmp2 = getlongest(s, i, i + 1);
      if (tmp2.length() > maxLen) {
        maxLen = tmp2.length();
        res = tmp2;
      }
    }
    return res;
  }

  public static String getlongest(String s, int left, int right) {
    while (left >= 0 && right <= s.length() - 1 && s.charAt(right) == s.charAt(left)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }

  public static void main(String[] args) {
    System.out.println(" = " + longestPalindrome("babad"));
    System.out.println(" = " + longestPalindrome("cbbd"));

    // dp
    System.out.println(" = " + dp_LongestPalindrome("babad"));
    System.out.println(" = " + dp_LongestPalindrome("cbbd"));
  }
}
