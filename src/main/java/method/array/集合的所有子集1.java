package method.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>NC27 集合的所有子集(一)</p>
 * 现在有一个没有重复元素的整数集合S，求S的所有子集
 * 注意：
 * 你给出的子集中的元素必须按升序排列
 * 给出的解集中不能出现重复的元素
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-12-10 11:49
 */
public class 集合的所有子集1 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    LinkedList<Integer> tmp = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // write code here
        backtrack(S, 0);
        return res;
    }

    public void backtrack(int[] S, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < S.length; i++) {
            tmp.add(S[i]);
            //错误点：把下面i+1写成index+1，在回溯的for循环中针对i操作而不是外层的变量
            backtrack(S, i + 1);
            tmp.removeLast();
        }
    }


}
