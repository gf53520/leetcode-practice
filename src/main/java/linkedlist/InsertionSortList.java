package linkedlist;

// 147 https://leetcode-cn.com/problems/insertion-sort-list/
// 链表的插入排序
public class InsertionSortList {

  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode lastSmall = insertionSortList(head.next);
    if (head.val <= lastSmall.val) {
      head.next = lastSmall;
      return head;
    }

    ListNode cut = lastSmall;
    while (cut.next != null && cut.next.val < head.val) {
      cut = cut.next;
    }
    head.next = cut.next;
    cut.next = head;
    return lastSmall;
  }

}
