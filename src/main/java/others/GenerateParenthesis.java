package others;

import java.util.ArrayList;
import java.util.List;

// 22 括号生成
// 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
/*
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
// 先生成左括号，再生成右括号，且右括号剩余个数需要大于左
public class GenerateParenthesis {

  public List<String> generateParenthesis(int n) {
    List<String> solutions = new ArrayList<>();
    if (n == 0) {
      return solutions;
    }
    dfs(new StringBuilder(), solutions, n, n);
    return solutions;
  }

  public void dfs(StringBuilder builder, List<String> solutions, int l, int r) {
    if (l == 0 && r == 0) {
      solutions.add(builder.toString());
      return;
    }

    if (l > 0) {
      builder.append("(");
      dfs(builder, solutions, l - 1, r);
      builder.deleteCharAt(builder.length() - 1);
    }

    if (r > 0 && r > l) {
      builder.append(")");
      dfs(builder, solutions, l, r - 1);
      builder.deleteCharAt(builder.length() - 1);
    }
  }

  public static void main(String[] args) {
    GenerateParenthesis obj = new GenerateParenthesis();
    System.out.println(obj.generateParenthesis(3));
  }
}
