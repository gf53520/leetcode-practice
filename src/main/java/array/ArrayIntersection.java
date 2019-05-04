package array;

import java.util.HashSet;

// 349 两个数组的交集
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
// 输出: [2]
public class ArrayIntersection {
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<Integer>();
    HashSet<Integer> solutions = new HashSet<>();

    if (nums1.length < nums2.length) {
      for (int i = 0; i < nums1.length; i++) {
        set.add(nums1[i]);
      }
      for (int i = 0; i < nums2.length; i++) {
        if (set.contains(nums2[i])) {
          solutions.add(nums2[i]);
        }
      }
    } else {
      for (int i = 0; i < nums2.length; i++) {
        set.add(nums2[i]);
      }
      for (int i = 0; i < nums1.length; i++) {
        if (set.contains(nums1[i])) {
          solutions.add(nums1[i]);
        }
      }
    }


    int[] ints = new int[solutions.size()];
    int i = 0;
    for (Integer n : solutions) {
      ints[i++] = n;
    }
    return ints;
  }

  public static void main(String[] args) {
    ArrayIntersection arrayIntersection = new ArrayIntersection();
    System.out.println(arrayIntersection.intersection(new int[]{1, 2, 2, 1},
        new int[]{2, 2}));
  }
}
