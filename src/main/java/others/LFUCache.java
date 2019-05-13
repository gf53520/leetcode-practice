package others;

import java.util.HashMap;
import java.util.Map;

/*
设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put，O(1)复杂度内。
  get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
  put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。
  在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
  LFUCache cache = new LFUCache(2);
  cache.put(1, 1);
  cache.put(2, 2);
  cache.get(1);       // 返回 1
  cache.put(3, 3);    // 去除 key 2
  cache.get(2);       // 返回 -1 (未找到key 2)
  cache.get(3);       // 返回 3
  cache.put(4, 4);    // 去除 key 1
  cache.get(1);       // 返回 -1 (未找到 key 1)
  cache.get(3);       // 返回 3
  cache.get(4);       // 返回 4
*/
// https://leetcode-cn.com/problems/lfu-cache
public class LFUCache {

  private int capacity;
  private int minFreq = 0;
  private Map<Integer, LinkedList> freqList;
  private Map<Integer, Node> state;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.state = new HashMap<>();
    this.freqList = new HashMap<>();
  }


  public int get(int key) {
    Node node = getNode(key);
    return node == null ? -1 : node.value;
  }

  public Node getNode(int key) {
    Node node = state.get(key);
    if (node == null) {
      return null;
    }

    LinkedList oldList = freqList.get(node.freq);
    oldList.deleteNode(node);
    if (oldList.isEmpty() && minFreq == node.freq) { // update minFreq
      minFreq = node.freq + 1;
    }

    node.freq += 1;
    LinkedList newList = freqList.get(node.freq);
    if (newList == null) {
      newList = new LinkedList();
      freqList.put(node.freq, newList);
    }
    newList.moveToFront(node);
    return node;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }

    Node node = getNode(key);
    if (node != null) {  // 已存在
      node.value = value;
    } else { // 新节点
      if (state.size() >= capacity) { // remove by lfu
        LinkedList linkedList = freqList.get(minFreq);
        Node last = linkedList.removeLast();
        state.remove(last.key);
      }

      minFreq = 1;
      LinkedList linkedList = freqList.get(1);
      if (linkedList == null) {
        linkedList = new LinkedList();
        freqList.put(1, linkedList);
      }
      Node newNode = linkedList.add(key, value);
      state.put(key, newNode);
    }
  }

  class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
      this.head = new Node(-1, -1);
      this.tail = this.head;
      this.head.next = tail;
      this.tail.prev = head;
    }

    public void deleteNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

    public Node add(int key, int value) {
      Node node = new Node(key, value);
      moveToFront(node);
      return node;
    }

    public void moveToFront(Node newNode) {
      head.next.prev = newNode;
      newNode.next = head.next;
      newNode.prev = head;
      head.next = newNode;
    }

    public Node removeLast() {
      Node last = this.tail.prev;
      deleteNode(last);
      return last;
    }

    public boolean isEmpty() {
      return this.head.next == this.tail && this.tail.prev == this.head;
    }
  }

  class Node {
    public Node prev;
    public Node next;
    public int key;
    public int value;
    public int freq;

    public Node(int key, int value) {
      this.freq = 1;
      this.key = key;
      this.value = value;
    }
  }


  public static void main(String[] args) {
    LFUCache cache = new LFUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1)); // 返回 1
    cache.put(3, 3);    // 去除 key 2
    System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
    System.out.println(cache.get(3));       // 返回 3
    cache.put(4, 4);    // 去除 key 1
    System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
    System.out.println(cache.get(3));       // 返回 3
    System.out.println(cache.get(4));       // 返回 4
  }

}
