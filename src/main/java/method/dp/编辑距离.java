package method.dp;

import java.util.Arrays;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;

/**
 * <p>leetcode 72</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-07-27 16:34
 */
public class 编辑距离 {
    int[][] dpTable;

    public int minDistance(String word1, String word2) {
        int i = word1.length(), j = word2.length();
        dpTable = new int[i][j];
        for (int[] ints : dpTable) {
            Arrays.fill(ints, -1);
        }
        return dpCalDistance(word1, i - 1, word2, j - 1);
    }


    //自顶向下递归构造dp数组
    public int dpCalDistance(String word1, int m, String word2, int n) {
        //base case
        if (m < 0)
            return n + 1;
        if (n < 0)
            return m + 1;
        //剪枝
        if (dpTable[m][n] != -1) {
            return dpTable[m][n];
        }
        //计算dp数组
        if (word1.charAt(m) == word2.charAt(n)) {
            dpTable[m][n] =
                    dpCalDistance(word1, m - 1, word2, n - 1);
        } else {
            //依次对应三种操作，删除，插入，替换
            dpTable[m][n] = Math.min(dpCalDistance(word1, m - 1, word2, n) + 1,
                    Math.min(dpCalDistance(word1, m, word2, n - 1) + 1,
                            dpCalDistance(word1, m - 1, word2, n - 1) + 1
                    )
            );
        }
        return dpTable[m][n];
    }
}
