package linkedlist;

public class AddTwoNumbers {

/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode d = dummy;

    boolean carryFlag = false;
    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      d.next = new ListNode((carryFlag ? ++sum : sum) % 10);
      d = d.next;
      carryFlag = (sum / 10) == 1 ? true : false;
    }
    if (carryFlag) {
      d.next = new ListNode(1);
    }
    return dummy.next;
  }
}
