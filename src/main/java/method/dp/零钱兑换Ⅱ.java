package method.dp;

/**
 * <p>518 leetcode</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-08-01 19:50
 */
public class 零钱兑换Ⅱ {
    int[][] dpTable;

    public int change(int amount, int[] coins) {
        int length = coins.length;
        dpTable = new int[length + 1][amount + 1];
        //默认情况下，没有使用硬币的情况下dp[0][i]都是0，而目标金额是0的时候表示多少硬币都有一种凑出法，因此dp[i][0]为1
        //注意，此处遍历所有的行元素
        for (int i = 0; i <= length; i++) {
            dpTable[i][0] = 1;
        }
        //dp转换如果目标金额小于新加入的这个硬币大小，
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - coins[i - 1]];
                } else {
                    dpTable[i][j] = dpTable[i - 1][j];
                }
            }
        }
        return dpTable[length][amount];
    }
}
