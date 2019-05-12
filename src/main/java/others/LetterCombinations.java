package others;

import java.util.ArrayList;
import java.util.List;

// 17. 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
/*
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {

  public List<String> letterCombinations(String digits) {
    List<String> solutions = new ArrayList<>();
    if (digits.length() == 0) {
      return solutions;
    }
    letterCombinations(digits, solutions, 0, new StringBuilder());
    return solutions;
  }

  public void letterCombinations(String digits, List<String> solutions, int i, StringBuilder builder) {
    if (i >= digits.length()) {
      solutions.add(builder.toString());
      return;
    }

    char[] arr = null;
    switch (digits.charAt(i)) {
      case '2':
        arr = new char[]{'a', 'b', 'c'};
        break;
      case '3':
        arr = new char[]{'d', 'e', 'f'};
        break;
      case '4':
        arr = new char[]{'g', 'h', 'i'};
        break;
      case '5':
        arr = new char[]{'j', 'k', 'l'};
        break;
      case '6':
        arr = new char[]{'m', 'n', 'o'};
        break;
      case '7':
        arr = new char[]{'p', 'q', 'r', 's'};
        break;
      case '8':
        arr = new char[]{'t', 'u', 'v'};
        break;
      case '9':
        arr = new char[]{'w', 'x', 'y', 'z'};
        break;
    }

    for (int j = 0; j < arr.length; j++) {
      builder.append(arr[j]);
      letterCombinations(digits, solutions, i + 1, builder);
      builder.deleteCharAt(builder.length() - 1);
    }
  }

}
