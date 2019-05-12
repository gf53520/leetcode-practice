package linkedlist;


// 19, https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthFromEnd {


  /*
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end,
   the linked list becomes 1->2->3->5.
   1->2->3->4->5
   l     h
         l     h
   */
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    ListNode prev = head;
    ListNode cut = head;
    while (n-- > 0) {
      cut = cut.next;
    }
    // 首先 cut 指针先向前走N步，如果最终 cut 指向空，说明N为链表的长度，
    // 则需要移除的为首元素，那么此时我们返回 prev.next 即可
    if (cut == null) { // 表示删除头部节点
      return prev.next;
    } else {
      while (cut.next != null) {
        prev = prev.next;
        cut = cut.next;
      }
      prev.next = prev.next.next;
      return head;
    }
  }

}
