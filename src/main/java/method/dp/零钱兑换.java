package method.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * <p>leetcode 322</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-06-21 16:29
 */
public class 零钱兑换 {
    @Test
    public void test() {
        int[] arr = new int[]{1, 2, 5};
        System.out.println(coinChange01(arr, 100));
    }


    int[] table;

    public int coinChange01(int[] coins, int amount) {
        table = new int[amount + 1];
        Arrays.fill(table, -10086);
        return dp(amount, coins);
    }

    //自顶向下递归解法
    private int dp(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (table[amount] != -10086) {
            return table[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(amount - coin, coins);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        //更新备忘录表
        table[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return table[amount];
    }
}
