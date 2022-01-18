package method;

import java.util.ArrayDeque;

/**
 * @program: suanfati
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @author: 李沛隆21081020
 * @create: 2022-01-06 20:32
 */
//public class 包含min函数的栈 {
//
//    ArrayDeque<Integer> mainStack = new ArrayDeque<>();
//    ArrayDeque<Integer> helpStack = new ArrayDeque<>();
//
//    /**
//     * initialize your data structure here.
//     */
//    public void MinStack() {
//        mainStack = new ArrayDeque<>();
//        helpStack = new ArrayDeque<>();
//    }
//
//    public void push(int x) {
//        if (mainStack == null || helpStack == null) {
//            return;
//        }
//        mainStack.push(x);
//        if (helpStack.isEmpty() ||
//                helpStack.getFirst() > mainStack.getFirst()) {
//            helpStack.push(x);
//        }
//
//    }
//
//    public void pop() {
//
//    }
//
//    public int top() {
//
//    }
//
//    public int min() {
//
//    }
//}
