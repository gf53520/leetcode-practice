package sort;

import java.util.Arrays;

public class MergeSort {

  // 小 => 大， 稳定算法
  private static void mergeSort(int[] arr, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, start, mid, end);
    }
  }

  private static void merge(int[] arr, int start, int mid, int end) {
    int[] result = new int[arr.length];
    int resultArrayIndex = start;
    int array1Index = start;
    int array2Index = mid + 1;

    while (array1Index <= mid && array2Index <= end) {
      if (arr[array1Index] <= arr[array2Index]) {
        result[resultArrayIndex++] = arr[array1Index++];
      } else {
        result[resultArrayIndex++] = arr[array2Index++];
      }
    }

    while (array1Index <= mid) { // array1还有剩余元素
      result[resultArrayIndex++] = arr[array1Index++];
    }

    while (array2Index <= end) { // array2还有剩余元素
      result[resultArrayIndex++] = arr[array2Index++];
    }
    for (int i = start; i <= end; i++) {
      arr[i] = result[i];
    }
    return;
  }

  public static void main(String[] args) {
    int[] arr = {8, 2, 1, 1, 4, 6, 7, 3, 5, 9, 6, 11, 19, 13, 55, 67, 32, 22};
    mergeSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
