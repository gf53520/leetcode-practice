package dp;

// 209,
// 滑动窗口概念
public class MinSubArrayLen {

  public int minSubArrayLen(int s, int[] nums) {
    int minLen = Integer.MAX_VALUE;
    int sum = 0;
    int l = 0;
    int r = 0;
    // 2, 3, 1, 2, 4, 3 , r = 2, l=
    // 1, 4, 4

    while (l < nums.length) {
      if (sum < s && r < nums.length) { // 不满足条件
        sum += nums[r++];
      } else if (sum >= s) { // 满足条件
        minLen = Math.min(minLen, r - l);
        sum -= nums[l++];
      } else { // 让l自增结束
        l++;
      }
    }

//      System.out.println("l = " + l + "r = " + r +"minLexxxn = " + minLen);

//    // 移动右边指针
//    for (int r = 0; r < nums.length; r++) {
//      sum += nums[r];
//      while (sum >= s && l < nums.length) { // 移动左边指针，直到 sum < s
//        if (r - l + 1 < minLen) {
//          minLen = r - l + 1;
//        }
//        sum -= nums[l++];
//      }
//    }

    return minLen == Integer.MAX_VALUE ? 0 : minLen;
  }

  public static void main(String[] args) {
    MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
//    int res = minSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    int res = minSubArrayLen.minSubArrayLen(4, new int[]{1, 4, 4});
    System.out.println("res = " + res);
  }
}
