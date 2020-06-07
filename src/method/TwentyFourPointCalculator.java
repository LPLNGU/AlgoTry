package method;import java.util.ArrayList;import java.util.List;import java.util.Scanner;/** * <p>24点是一种老少咸宜的游戏，它的具体玩法如下：给玩家4张牌，每张牌的面值在1~13之间，允许其中有数值相同的牌。</p> * <p>采用加、减、乘、除四则运算，允许中间运算存在小数，并且可以使用括号，但每张牌只能使用一次，尝试构造一个表达式，使其运算结果为24。</p> * <p>请你根据上述游戏游戏规则构造一个24点游戏的算法，要求如下：</p> * <p>输入：n1,n2,n3,n4</p> * <p>输出：若能得到运算结果为24，则输出一个对应的运算表达式，否则输出null。</p> * * @author hongming * @date 2020-03-31 22:21 */public class TwentyFourPointCalculator {    /**     * 主函数入口     *     * @param args 输入为长度为4，且范围为1~13的数字组成的字符串数组     */    public static void main(String[] args) {        System.out.println("inputs:" + String.join(",", args) + ", expression:" + cal(args));    }    /**     * 游戏算法实现     *     * @param digits 输入为长度为4，且范围为1~13的数字组成的字符串数组     * @return 运算结果为24的运算表达式，如得不到运算结果为24，返回null     */    private static String cal(String[] digits) {        // TODO：code here        return null;    }}