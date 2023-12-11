package method.string;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 牛客 NC52 有效括号序列
 * <p>给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列 括号必须以正确的顺序关闭，"()"和"()[]{}
 * "都是合法的括号序列，但"(]"和"([)]"不合法。</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2023-12-10 10:36
 */
public class NC52有效括号序列 {
    public static void main(String[] args) {
        String s = "[()]";
        System.out.println(isValid(s));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid(String s) {
        // write code here
        Deque<Character> characterArrayDeque = new ArrayDeque<>();
        characterArrayDeque.push(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            if (characterArrayDeque.size() != 0 && isLegal(characterArrayDeque.getFirst(),
                    s.charAt(i))) {
//                System.out.println(characterArrayDeque.getLast() + "s.charAt(i)=" + s.charAt(i) +
//                        "isLegal(characterArrayDeque.getFirst(), s.charAt(i))" + isLegal
//                        (characterArrayDeque.getLast(), s.charAt(i)));
//                System.out.println(Arrays.toString(characterArrayDeque.toArray()));
                characterArrayDeque.poll();
            } else {
                if (i == 0) {
                    continue;
                }
                characterArrayDeque.push(s.charAt(i));
            }
        }
        return characterArrayDeque.size() == 0;
    }

    public static boolean isLegal(char a, char b) {
        switch (a) {
            case '{':
                return b == '}';
            case '(':
                return b == ')';
            case '[':
                return b == ']';
            default:
                return false;
        }
    }
}
