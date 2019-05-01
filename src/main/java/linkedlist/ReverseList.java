package linkedlist;

// 206. Reverse Linked List
public class ReverseList {

  // 递归：r(1->2->3->4->5->NULL) = (r(2->3->4->5->NULL) = 5->4->3->2) +
  public static ListNode reverseListIII(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode newHead = reverseListIII(head.next);
    head.next.next = head;
    head.next = null; // 勿忘记

    return newHead;
  }

  // 非递归，1->2->3->4->5->NULL
  // Detail: 2->1, 3->2, 4->3, 5->4,
  // => 5->4->3->2->1->NULL
  public static ListNode reverseListI(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode prev = head;
    ListNode cut = head.next;
    ListNode after = null;
    while (cut != null) {
      after = cut.next;
      cut.next = prev;
      prev = cut;
      cut = after;
    }
    // 注意: 此处head的next需要设置为null，勿忘记，否则存在环
    head.next = null;
    return prev;
  }

  //dummy->1->2->3->4->5 //cut是1，after是2
  //dummy->2->1->3->4->5 //cut是1，after是3
  //dummy->3->2->1->4->5
  public static ListNode reverseListII(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode cut = head;
    while (cut.next != null) {
      ListNode after = cut.next;
      cut.next = after.next;
      after.next = dummy.next;
      dummy.next = after;
    }
    return dummy.next;
  }


  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = null;

    // 1->2->3->4->5->NULL => 5->4->3->2->1->NULL
//    ListNode res = reverseListI(listNode1);
    ListNode res = reverseListII(listNode1);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}
