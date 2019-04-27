package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// 347
public class TopKFrequent {

  public List<Integer> topKFrequent(int[] nums, int k) {
    ArrayList<Integer> solutions = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return solutions;
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for (Integer ele : nums) {
      if (!map.containsKey(ele)) {
        map.put(ele, 1);
      } else {
        map.put(ele, map.get(ele) + 1);
      }
    }

    List<Integer>[] buckets = new ArrayList[nums.length + 1];//定义足够数量的桶
    map.forEach((key, cut) -> {
      if (buckets[cut] == null) {
        buckets[cut] = new ArrayList<>();
      }
      buckets[cut].add(key);
    });

    out:
    for (int i = buckets.length - 1; i >= 0; i--) {
      if (buckets[i] == null) {
        continue;
      }
      for (int j = 0; j < buckets[i].size(); j++) {
        if (solutions.size() >= k) {
          break out;
        }
        solutions.add(buckets[i].get(j));
      }
    }
    return solutions;
  }

  public static void main(String[] args) {
    TopKFrequent topKFrequent = new TopKFrequent();
    int[] ints = {1, 1, 1, 2, 2, 3};
    List<Integer> solutions = topKFrequent.topKFrequent(ints, 2);
    System.out.println("solutions = " + solutions);
  }
}
