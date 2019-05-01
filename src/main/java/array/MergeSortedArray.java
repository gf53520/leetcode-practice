package array;

// 88
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

public class MergeSortedArray {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int newLastIndex = m + n - 1;
    int nums1Last = m - 1;
    int nums2Last = n - 1;
    while (nums1Last >= 0 && nums2Last >= 0) {
      nums1[newLastIndex--] =
          (nums1[nums1Last] > nums2[nums2Last]) ? nums1[nums1Last--] : nums2[nums2Last--];
    }

    while (nums1Last >= 0) {
      nums1[newLastIndex--] = nums1[nums1Last--];
    }

    while (nums2Last >= 0) {
      nums1[newLastIndex--] = nums2[nums2Last--];
    }
  }

}
