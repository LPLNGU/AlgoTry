package method;

/**
 * @program: suanfati
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * @author: 李沛隆21081020
 * @create: 2021-12-12 11:49
 */
public class 斐波那契数列 {
    public static int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int pre = 0, cur = 1, sum = 1;
        for (int i = 2; i <= n; i++) {
            //防止此处超出最大质数，
            sum = (pre + cur) % 1000000007;
            pre = cur;
            cur = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib(44));
    }
}
