package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// 295. 数据流的中位数 https://leetcode-cn.com/problems/find-median-from-data-stream/
/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
 */
public class MedianFinder {

  private PriorityQueue<Integer> small; // 最小堆
  private PriorityQueue<Integer> larger;  // 最大堆

  public MedianFinder() {
    this.small = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });
    this.larger = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });
  }

  // 维持 larger.size() - small.size() > 1， 优先插入larger
  public void addNum(int num) {
    if (larger.isEmpty() || num <= larger.peek()) {
      larger.add(num);
    } else {
      small.add(num);
    }
    balance();
  }

  public void balance() {
    if (larger.size() < small.size()) {
      larger.add(small.poll());
    } else if (larger.size() - small.size() == 2) {
      small.add(larger.poll());
    }
    return;
  }

  public double findMedian() {
    if (larger.size() > small.size()) {
      return larger.peek();
    }
    return (small.peek() + larger.peek()) * 1.0 / 2;
  }

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    System.out.println(medianFinder.findMedian()); //-> 1.5
    medianFinder.addNum(3);
    System.out.println(medianFinder.findMedian()); //-> 2
  }
}
