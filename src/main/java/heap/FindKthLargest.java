package heap;

// 215: Kth Largest Element in an Array
// https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
// 最小heap或者快排

public class FindKthLargest {

  // 反过来划分, nums[start] >= nums[end]
  public int partition(int[] nums, int start, int end) {
    int hole = nums[start];
    while (start < end) {
      while (start < end && nums[end] <= hole) end--;
      nums[start] = nums[end];

      while (start < end && nums[start] >= hole) start++;
      nums[end] = nums[start];
    }
    nums[start] = hole;
    return start;
  }

  public int recursive(int[] nums, int k, int start, int end) {
    int pivot = partition(nums, start, end);
    if (pivot + 1 == k) {
      return nums[pivot];
    } else if (pivot + 1 > k) {
      return recursive(nums, k, start, pivot - 1);
    } else {
      return recursive(nums, k, pivot + 1, end);
    }
  }

  // 快排
  public int findKthLargest(int[] nums, int k) {
    if (nums == null || k > nums.length) {
      return -1;
    }
    return recursive(nums, k, 0, nums.length - 1);
  }

  // 基于最小堆
  public int findKthLargestHeap(int[] nums, int k) {
    int[] heap = new int[k + 1];

    for (int i = 0; i < k; i++) { // 处理前k个元素
      heap[i + 1] = nums[i];
    }

    for (int i = k / 2; i > 0; i--) { // build heap
      siftDown(heap, i); // 下浮除叶子节点的元素
    }

    for (int i = k; i < nums.length; i++) { // 处理剩余元素
      if (nums[i] > heap[1]) {
        heap[1] = nums[i];
        siftDown(heap, 1); // 下浮第一个元素；
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

  public static void main(String[] args) {
    FindKthLargest obj = new FindKthLargest();
    System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    System.out.println(obj.findKthLargest(
        new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }
}
