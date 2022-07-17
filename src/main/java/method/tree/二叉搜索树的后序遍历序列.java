package method.tree;

import org.junit.Test;

/**
 * @program: suanfati
 * @description: 剑指offer33 判断是否为后续遍历
 * @author: 李沛隆21081020
 * @create: 2022-03-22 10:48
 */
public class 二叉搜索树的后序遍历序列 {
    @Test
    public void test() {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(verifyPostorder(nums));
    }

    public boolean verifyPostorder(int[] postorder) {
        return judge(postorder, 0, postorder.length - 1);
    }

    public boolean judge(int[] seq, int lo, int hi) {
        if (lo >= hi) {
            return true;
        }
        int begin = lo;
        while (seq[begin] < seq[hi]) {
            begin++;
        }
        int end = begin;
        while (seq[end] > seq[hi]) {
            end++;
        }
        if (end != hi) {
            return false;
        }
        return judge(seq, lo, begin - 1) && judge(seq, begin, hi - 1);
    }
}
