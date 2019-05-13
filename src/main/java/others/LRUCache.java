package others;

import java.util.HashMap;
import java.util.Map;

// 146 https://leetcode-cn.com/problems/lru-cache/submissions/
public class LRUCache {

  private int capacity;
  private Map<Integer, Node> state;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.state = new HashMap<>();
    this.head = new Node(-1, -1);
    this.tail = this.head;
    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  public int get(int key) {
    if (!state.containsKey(key)) {
      return -1;
    }
    Node node = state.get(key);
    deleteNode(node);
    moveToFront(node);
    return node.value;
  }

  public void deleteNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public void put(int key, int value) {
    if (get(key) != -1) {
      state.get(key).value = value; // 已经移动位子
      return;
    }

    if (state.size() >= capacity) { // 删除尾巴
      Node cut = tail.prev;
      state.remove(cut.key); // 移除state中过期节点
      deleteNode(cut);
    }

    Node newNode = new Node(key, value);
    moveToFront(newNode);
    state.put(key, newNode);
  }

  // 头部插入 newNode 节点
  private void moveToFront(Node newNode) {
    head.next.prev = newNode;
    newNode.next = head.next;
    newNode.prev = head;
    head.next = newNode;
  }

  public boolean isEmpty() {
    return this.head.next == this.tail && this.tail.prev == this.head;
  }

  public class Node {
    Node prev;
    Node next;
    int key;
    int value;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2 /* capacity */);
    System.out.println(cache.isEmpty());
    cache.put(1, 1);
    System.out.println(cache.isEmpty());
    cache.put(2, 2);
    System.out.println(cache.get(1));// returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println(cache.get(2));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3
    System.out.println(cache.get(4));       // returns 4
    System.out.println(cache.isEmpty());
  }

}
