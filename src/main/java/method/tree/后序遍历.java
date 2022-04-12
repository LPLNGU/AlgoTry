package method.tree;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-03-22 10:48
 */
public class 后序遍历 {
    public boolean verifyPostorder(int[] postorder) {
        return recursion(postorder, 0, postorder.length - 1);
    }

    boolean recursion(int[] postorder, int left, int right) {
        if (left > right) {
            return true;
        }
        int start = left;
        //找出左子树，验证每一个元素
        while (postorder[start] < postorder[right]) {
            start++;
        }
        int index = start;
        //找出右子树，验证每一个元素
        while (postorder[index] > postorder[right]) {
            index++;
        }
        return index == right && recursion(postorder, left, start - 1) && recursion(postorder, start, right - 1);
    }
}
