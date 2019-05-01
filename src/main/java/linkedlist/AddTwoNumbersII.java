package linkedlist;

// 445 https://leetcode-cn.com/problems/add-two-numbers-ii/
// 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// 输出: 7 -> 8 -> 0 -> 7

// 反转链表后问题转换为问题1
public class AddTwoNumbersII {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return ReverseList.reverseListII(
        AddTwoNumbers.addTwoNumbers(
            ReverseList.reverseListII(l1),
            ReverseList.reverseListII(l2)
        )
    );
  }

}
