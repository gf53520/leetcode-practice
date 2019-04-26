package heap;

// 215: 最小heap解法或者快排
public class FindKthLargest {

  public int findKthLargest(int[] nums, int k) {
    int[] heap = new int[k + 1];

    for (int i = 0; i < k; i++) { // 处理前k个元素
      heap[i + 1] = nums[i];
    }

    for (int i = k / 2; i > 0; i--) { // build heap
      siftDown(heap, i);
    }

    for (int i = k; i < nums.length; i++) { // 处理剩余元素
      if (nums[i] > heap[1]) {
        heap[1] = nums[i];
        siftDown(heap, 1);
      }
    }
    return heap[1];
  }

  public void siftDown(int[] heap, int index) {
    int hole = heap[index];
    for (; 2 * index < heap.length; ) {
      int child = 2 * index;
      if (child + 1 < heap.length && heap[child + 1] < heap[child]) {
        child = child + 1;
      }
      if (heap[child] < hole) {
        heap[index] = heap[child];
      } else {
        break;
      }
      index = child;
    }
    heap[index] = hole;
  }
}
