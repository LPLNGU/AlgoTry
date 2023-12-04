package method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>牛客 NC42 有重复项数字的全排列</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-12-04 20:09
 */
public class 有重复数字的全排列 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList <>>
     */
    boolean[] mark;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // write code here
        Arrays.sort(num);
        mark = new boolean[num.length];
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        LinkedList<Integer> currentList = new LinkedList<>();
        backtrack(resList, currentList, num);
        return resList;
    }

    public void backtrack(ArrayList<ArrayList<Integer>> result, LinkedList<Integer> currentList,
                          int[] num) {
        if (currentList.size() == num.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            //情况1：当前未访问过
            //情况2：当前数值和前一位置数值相等并且前一个数值没有访问过（为了避免重复，因为前面肯定走过这个）
            if (mark[i] || i > 0 && num[i] == num[i - 1] && !mark[i - 1]) {
                continue;
            }
            currentList.add(num[i]);
            mark[i] = true;
            backtrack(result, currentList, num);
            currentList.removeLast();
            mark[i] = false;
        }
    }
}
