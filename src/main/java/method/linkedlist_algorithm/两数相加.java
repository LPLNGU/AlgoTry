package method.linkedlist_algorithm;

import org.junit.Test;

/**
 * <p>leetcode 2</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-06-07 09:45
 */
public class 两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), node = dummy;
        int carry = 0;
        //carry > 0是为了进入更高位
        while (l1 != null || l2 != null || carry > 0) {
            int currentSum = carry;
            if (l1 != null) {
                currentSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentSum += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(currentSum % 10);
            carry = currentSum / 10;
            node = node.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
