package method;

import java.util.Scanner;

/**
 * <p>牛客 DP2 跳台阶</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-12-04 19:56
 */
public class 跳台阶 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        if (in.hasNextInt()) {
            int n = in.nextInt();
            jump(n);
        }
        System.out.println(res);
    }


    public static int res = 0;

    public static void jump(int n) {
        if (n - 2 == 0) {
            res++;
        }
        if (n - 1 == 0) {
            res++;
            return;
        }
        if (n - 1 > 0) {
            jump(n - 1);
        }
        if (n - 2 > 0) {
            jump(n - 2);
        }
    }


}
