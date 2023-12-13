package method.dp;

import java.util.Scanner;

/**
 * <p>
 * 牛客 [编程题]最长公共子串
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * https://www.nowcoder.com/questionTerminal/210741385d37490c97446aa50874e62d?
 * </p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-12-12 19:47
 */
public class 最长公共子串 {

    static int[][] dpTable;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String a = in.nextLine();
        String b = in.nextLine();
        int endIndex = 0, resLength = 0;
        //dp[i][j]数组表示0到i-1和j-1的最长公共子串长度(i,j分别为两个指针依次向后遍历)
        dpTable = new int[a.length() + 1][b.length() + 1];
        //行为0或者列为0情况下，都是0到0的长度，所以是0，因此遍历赋值从i、j = 1开始
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
                    if (resLength < dpTable[i][j]) {
                        resLength = dpTable[i][j];
                        endIndex = i - 1;
                    }
                } else {
                    dpTable[i][j] = 0;
                }
            }
        }
        StringBuilder str = new StringBuilder();
        //i起始为算出来的索引，end为dp得出的子串的结尾索引值
        for (int i = endIndex - resLength + 1; i <= endIndex; i++) {
            str.append(a.charAt(i));
        }
        System.out.println(str.length() == 0 ? -1 : str);
    }
}
