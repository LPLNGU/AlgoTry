package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description: 92
 * @author: 李沛隆21081020
 * @create: 2022-04-01 17:52
 */
public class 反转链表Ⅱ {



    //递归解法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            //反转前n个
            return reverseN(head, right);
        }
        //走到第left个节点
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
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
