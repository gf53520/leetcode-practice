package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 350 两个数组的交集II
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
// 输出: [2,2]
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
public class ArrayIntersectionII {

  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> solutions = new ArrayList<>();

    if (nums1.length < nums2.length) {
      for (int i = 0; i < nums1.length; i++) {
        map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
      }
      for (int i = 0; i < nums2.length; i++) {
        if (map.containsKey(nums2[i]) && map.getOrDefault(nums2[i], 0) >= 1) {
          solutions.add(nums2[i]);
          map.put(nums2[i], map.get(nums2[i]) - 1);
        }
      }
    } else {
      for (int i = 0; i < nums2.length; i++) {
        map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
      }
      for (int i = 0; i < nums1.length; i++) {
        if (map.containsKey(nums1[i]) && map.getOrDefault(nums1[i], 0) >= 1) {
          solutions.add(nums1[i]);
          map.put(nums1[i], map.get(nums1[i]) - 1);
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
    ArrayIntersectionII arrayIntersection = new ArrayIntersectionII();
    System.out.println(arrayIntersection.intersect(new int[]{1, 2, 2, 1},
        new int[]{2, 2}));
    System.out.println(arrayIntersection.intersect(new int[]{4, 9, 5},
        new int[]{9, 4, 9, 8, 4}));
  }
}
