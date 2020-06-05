package method;

import java.security.Key;
import java.util.*;

/*
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 * */
public class MoreThanHalfNum_Solution {

 /*   public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 1, 1, 1, 1};
        System.out.println(MoreThanHalfNum_Solution(array));
    }*/

    public int MoreThanHalfNum_Solution(int[] array) {
        int result = fine(array);
        return result;
    }

    public int fine(int[] array) {
        int result = 0;
        if (array.length < 1) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > array.length / 2) {
                result = m.getKey();
            }
        }
        return result;
    }
}
