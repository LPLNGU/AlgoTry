package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description: 剑指offerⅡ
 * @author: 李沛隆21081020
 * @create: 2022-03-31 17:02
 */
public class 链表中环的入口点 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            //没有环
            return null;
        }

        slow = head;
        //节点不相等的时候 持续向后遍历，直到重合，头到圆起点的距离=重合点到圆起点的距离
        while (slow.val != fast.val && slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
