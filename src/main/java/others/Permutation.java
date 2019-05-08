package others;

// 46. Permutations P(n, m)
public class Permutation {
  // 全排列，从不重复的数组中挑选m个数， 递归深度m
  public static void permutation(int[] arr, int[] out, int cutIdx, int m, int len) {
    if (m == 0) {
      for (int i = 0; i < out.length; i++) {
        System.out.print(out[i]);
      }
      System.out.println();
      return;
    }
    if (cutIdx + m > arr.length) {
      return;
    }
    permutation(arr, out, cutIdx + 1, m, len); // 不选
    out[len - m] = arr[cutIdx];
    permutation(arr, out, cutIdx + 1, m - 1, len); // 选
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1, 2, 3, 4, 5};
    int m = 3;
    int[] out = new int[3];
    permutation(arr, out, 0, m, m);
  }
}
