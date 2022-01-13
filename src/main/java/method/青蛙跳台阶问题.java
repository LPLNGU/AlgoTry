package method;

/**
 * @program: suanfati
 * @description: 剑指 Offer 10- II. 青蛙跳台阶问题
 * @author: 李沛隆21081020
 * @create: 2021-12-12 14:28
 */
public class 青蛙跳台阶问题 {
    int[] dp;

    public int numWays(int n) {
        dp = new int[n + 1];
        return cal(n, dp);
    }

    public int cal(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        //使用最大质数取余，防止大于int最大值
        int res = (cal(n - 1, dp) + cal(n - 2, dp)) % 1000000007;
        dp[n] = res;
        return res;
    }
}
