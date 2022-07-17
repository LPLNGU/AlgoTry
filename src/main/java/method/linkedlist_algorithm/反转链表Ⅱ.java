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
            return reverseToN(head, right);
        }
        ListNode resHead = reverseBetween(head.next, left - 1, right - 1);
        //此处一定要注意，递归时连接链表
        head.next = resHead;
        return head;
    }

    ListNode endNode;

    public ListNode reverseToN(ListNode head, int n) {
        if (n == 1) {
            endNode = head.next;
            return head;
        }
        //思考：返回最后一个node，就是尾部元素，递归到最后一个节点
        ListNode last = reverseToN(head.next, n - 1);
        head.next.next = head;
        head.next = endNode;
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
