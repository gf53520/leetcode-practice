package binarySearch;

/*
278. First Bad Version
https://leetcode.com/problems/first-bad-version/
Given n = 5, and version = 4 is the first bad version.
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
 */
public class FirstBadVersion {
  public boolean isBadVersion(int version) {
    return false;
  }

  public int firstBadVersion(int n) {
    int left = 0;
    int right = n;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
