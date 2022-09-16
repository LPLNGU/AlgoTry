package method.dp;

import java.util.Arrays;

/**
 * <p>leetcode 1143</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-07-28 20:06
 */
public class 最长公共子序列 {
    int[][] dpTable;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),
                n = text2.length();
        dpTable = new int[m + 1][n + 1];
        //dp[i][j]表示text1[0到i-1]和text2[0到j-1]的最长公共子序列
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
                } else {
                    dpTable[i][j] = Math.max(dpTable[i - 1][j], dpTable[i][j - 1]);
                }
            }
        }
        return dpTable[m][n];
    }
}
