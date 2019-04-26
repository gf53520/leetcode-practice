package heap;

// 23
public class MergeKLists {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    return mergeKLists(lists, 0, lists.length - 1);
  }

  public ListNode mergeKLists(ListNode[] lists, int low, int high) {
    if (low >= high) {
      return lists[low];
    }
    int mid = low + (high - low) / 2;
    ListNode l1 = mergeKLists(lists, low, mid);
    ListNode l2 = mergeKLists(lists, mid + 1, high);
    return mergeLists(l1, l2);
  }

  public ListNode mergeLists(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return (l1 == null) ? l2 : l1;
    }

    ListNode dummy = new ListNode(-1);
    ListNode cut = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val > l2.val) {
        cut.next = l2;
        l2 = l2.next;
      } else {
        cut.next = l1;
        l1 = l1.next;
      }
      cut = cut.next;
    }

    if (l1 != null) {
      cut.next = l1;
    }
    if (l2 != null) {
      cut.next = l2;
    }
    return dummy.next;
  }
}
