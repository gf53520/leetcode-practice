package others;

import java.util.Stack;

// 20 有效的括号
/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：左括号必须用相同类型的右括号闭合, 且左括号必须以正确的顺序闭合。
输入: "()"
输出: true
输入: "()[]{}"
输出: true
输入: "(]"
输出: false
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    if (s.length() == 0) {
      return true;
    }
    Stack<Character> stack = new Stack();
    for (int i = 0; i < s.length(); i++) {
      if (s.isEmpty()) {
        stack.push(s.charAt(i));
        continue;
      }
      switch (s.charAt(i)) {
        case ')':
          if (stack.peek() == '(') {
            stack.pop();
          } else {
            stack.push(s.charAt(i));
          }
          break;
        case '}':
          if (stack.peek() == '{') {
            stack.pop();
          } else {
            stack.push(s.charAt(i));
          }
          break;
        case ']':
          if (stack.peek() == '[') {
            stack.pop();
          } else {
            stack.push(s.charAt(i));
          }
          break;
        default:
          stack.push(s.charAt(i));
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    ValidParentheses validParentheses = new ValidParentheses();
    System.out.println(validParentheses.isValid("()[]{}"));
    System.out.println(validParentheses.isValid("(]"));
  }
}
