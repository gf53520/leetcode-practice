package linkedlist;

/*
    83. Remove Duplicates from Sorted List
    https://leetcode.com/problems/remove-duplicates-from-sorted-list
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
 */
public class DeleteDuplicates {

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cut = head;
    while (cut.next != null) {
      if (cut.val == cut.next.val) {
        cut.next = cut.next.next; // 注意
      } else {
        cut = cut.next;
      }
    }
    return head;
  }

  // Given 1->1->2->3->3, return 1->2->3.
  public static ListNode deleteDuplicates2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p0 = head;
    ListNode p1 = p0.next;
    while (p1 != null) {
      if (p1.val != p0.val) {
        p0.next = p1;
        p0 = p1;
      }
      p1 = p1.next;
    }
    p0.next = null;   // 断开链接, 否则会导致结尾会仍然有重复数据情况
    return head;
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(1);
    ListNode listNode3 = new ListNode(2);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(3);
    ListNode listNode6 = new ListNode(3);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = null;

    ListNode res = deleteDuplicates2(listNode1);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}
