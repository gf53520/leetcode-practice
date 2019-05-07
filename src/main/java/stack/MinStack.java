package stack;

import java.util.Stack;

// 155. 最小栈 https://leetcode-cn.com/problems/min-stack/
/*
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
 */
public class MinStack {

  private Stack<Integer> data;
  private Stack<Integer> mins;

  public MinStack() {
    data = new Stack<>();
    mins = new Stack<>();
  }

  public void push(int x) {
    data.push(x);
    if (mins.isEmpty() || x <= mins.peek()) {
      mins.push(x);
    }
  }

  public void pop() {
    // 不能写成下面形式，对象比较
    // if (s2.peek() == s1.peek()) s2.pop();
    int pop = data.pop();
    if (pop == mins.peek()) {
      mins.pop();
    }
  }

  public int getMin() {
    return mins.peek();
  }

  public int top() {
    return data.peek();
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // --> 返回 -3.
    minStack.getMin();
    minStack.pop();
    System.out.println(minStack.top());     //  --> 返回 0.
    System.out.println(minStack.getMin()); //  --> 返回 -2.
  }

}
