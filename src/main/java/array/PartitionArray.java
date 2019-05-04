package array;

// 小于k移到左边，大于等于k移到右边
// 返回划分位置: 数组第一个i，nums[i]>=k
// 快排子问题
public class PartitionArray {
  public int partition(int[] nums, int k) {
    if (nums.length == 0) {
      return 0;
    }
    int hole = nums[0];
    int left = 0;
    int right = nums.length - 1;
    while (left < right) {
      while (left < right && nums[right] >= k) {
        right--;
      }
      nums[left] = nums[right];

      while (left < right && nums[left] < k) {
        left++;
      }
      nums[right] = nums[left];
    }
    nums[left] = hole;
    return left;
  }

  public static void main(String[] args) {
    PartitionArray partitionArray = new PartitionArray();
    System.out.println("res = " + partitionArray.partition(new int[]{3, 2, 2, 1}, 2));
  }

}
