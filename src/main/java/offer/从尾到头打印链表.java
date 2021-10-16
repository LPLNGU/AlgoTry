package lpl.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Algorithm
 * @description: 剑指 Offer 06. 从尾到头打印链表
 * @author: 李沛隆21081020
 * @create: 2021-10-03 15:08
 */
public class 从尾到头打印链表 {

    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        } else if (head.next == null) {
            return new int[]{head.val};
        }
        reverse(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void reverse(ListNode node) {
        if (node == null) {
            return;
        }
        reverse(node.next);
        list.add(node.val);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
