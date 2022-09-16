package method.dp;

/**
 * <p>leetcode 583
 * 给定两个单词 word1和word2,返回使得word1和word2相同所需的最小步数。
 * 每步可以删除任意一个字符串中的一个字符。</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-07-29 10:55
 */
public class 两个字符串的删除操作 {
    int[][] dpTable;

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dpTable = new int[m + 1][n + 1];
        //别忘了dp的定义，从dp[1]开始才代表第0个字符串中的元素，因此dp[0][0]=0
        for (int i = 1; i <= m; i++) {
            dpTable[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dpTable[0][j] = j;
        }
        //迭代，使用递推公式
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1];
                } else {
                    dpTable[i][j] = Math.min(dpTable[i - 1][j] + 1, dpTable[i][j - 1] + 1);
                }
            }
        }
        return dpTable[m][n];
    }
}
