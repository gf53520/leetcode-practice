package linkedlist;

/*
23. Merge k Sorted Lists
https://leetcode.com/problems/merge-k-sorted-lists/
转换为2个链表merge的问题
 */
public class MergeKLists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return merge(lists, 0, lists.length - 1);
  }

  public ListNode merge(ListNode[] lists, int left, int right) {
    if (left >= right) {
      return lists[left];
    }
    int mid = left + (right - left) / 2;
    ListNode l = merge(lists, left, mid);
    ListNode r = merge(lists, mid + 1, right);
    return merge(l, r);
  }

  public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode cnt = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cnt.next = l1;
        l1 = l1.next;
      } else {
        cnt.next = l2;
        l2 = l2.next;
      }
      cnt = cnt.next;
    }
    if (l1 != null) {
      cnt.next = l1;
    }
    if (l2 != null) {
      cnt.next = l2;
    }
    return dummy.next;
  }

}
