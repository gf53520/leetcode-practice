package linkedlist;


// 82 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
// 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
// 输入: 1->2->3->3->3->4->4->5
// 输出: 1->2->5
public class DeleteDuplicatesII {

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    ListNode cut = head;
    dummy.next = cut;
    ListNode prev = dummy;
    while (cut.next != null) {
      if (cut.val == cut.next.val) {
        cut = cut.next;
      } else {
        if (prev.next == cut) { //通过引用来判断，相等则需要保留当前节点
          prev = prev.next;
        }
        prev.next = cut.next; // 预先假设下一节点保留
        cut = cut.next;
      }
    }

    if (prev.next != cut) { // 引用判断不等，移除最后一个节点
      prev.next = null;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(4);
    ListNode listNode6 = new ListNode(4);
    ListNode listNode7 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    listNode7.next = null;

    ListNode res = deleteDuplicates(listNode1);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
}

