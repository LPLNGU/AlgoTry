package method.linkedlist_algorithm;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-03-31 17:42
 */
public class 相交链表 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        //巧妙，如果两个链表相同长度，那么可以直接判定是否可以，不会进入拼接链表的另一半，依次对比两个链表的对应位置，如果不相同直接双指针==null出循环。
        //如果两个链表长度不同，只有拼接链表最后才会双null走出循环，并且结果就是null
        while (p1 != p2) {
            if (p1 != null) {
                p1 = p1.next;
            } else {
                p1 = headB;
            }
            if (p2 != null) {
                p2 = p2.next;
            } else {
                p2 = headA;
            }
        }
        return p1;
    }

    //length解法，由相交节点后面相等推出
    public ListNode getIntersectionNode01(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int lengthA = 0, lengthB = 0;
        while (p1 != null) {
            p1 = p1.next;
            lengthA++;
        }
        while (p2 != null) {
            p2 = p2.next;
            lengthB++;
        }
        //使两个长度相等
        if (lengthA > lengthB) {
            while (lengthA > lengthB) {
                headA = headA.next;
                lengthA--;
            }
        } else {
            while (lengthB > lengthA) {
                headB = headB.next;
                lengthB--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
