package stack;

import java.util.Stack;

// 232 用栈实现队列
// https://leetcode-cn.com/problems/implement-queue-using-stacks/
/*
使用栈实现队列的下列操作：
push(x) -- 将一个元素放入队列的尾部。
pop() -- 从队列首部移除元素。
peek() -- 返回队列首部的元素。
empty() -- 返回队列是否为空。

MyQueue queue = new MyQueue();
queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false
 */
public class MyQueue {

  private Stack<Integer> s1;
  private Stack<Integer> s2;

  /**
   * Initialize your data structure here.
   */
  public MyQueue() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }

  /**
   * Push element x to the back of queue.
   */
  public void push(int x) {
    s1.push(x);
  }

  /**
   * Removes the element from in front of queue and returns that element.
   */
  public int pop() {
    if (!s2.isEmpty()) {
      return s2.pop();
    }
    moveToStack();
    return s2.pop();
  }

  /**
   * Get the front element.
   */
  public int peek() {
    if (!s2.isEmpty()) {
      return s2.peek();
    }
    moveToStack();
    return s2.peek();
  }

  public void moveToStack() {
    while (!s1.isEmpty()) {
      s2.add(s1.pop());
    }
  }

  /**
   * Returns whether the queue is empty.
   */
  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    System.out.println(queue.peek());   // 返回 1
    System.out.println(queue.pop());   // 返回 1
    System.out.println(queue.empty());   // 返回 false
  }
}
