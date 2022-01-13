package method;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: suanfati
 * @description: 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * @author: 李沛隆21081020
 * @create: 2021-12-30 21:38
 */
public class 用两个栈实现队列 {
    public Deque<Integer> stack1 = new LinkedList<>();
    public Deque<Integer> stack2 = new LinkedList<>();


    public Object CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
        return null;
    }

    public Object appendTail(int value) {
        if (stack1 == null && stack2 == null) {
            return null;
        }
        stack1.push(value);
        return null;
    }

    public int deleteHead() {
        if (stack1 == null && stack2 == null || (stack1.isEmpty() && stack2.isEmpty())) {
            return -1;
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    @Test
    public void test() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(CQueue());
        list.add(appendTail(5));
        list.add(appendTail(2));
        list.add(deleteHead());
        list.add(deleteHead());
        System.out.println(list);
    }
}

