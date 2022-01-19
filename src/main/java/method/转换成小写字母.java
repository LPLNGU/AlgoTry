package method;

/**
 * @program: suanfati
 * @description: 709. 转换成小写字母 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * @author: 李沛隆21081020
 * @create: 2021-12-12 11:05
 */
public class 转换成小写字母 {
    static int asciiMinusNum = 'a' - 'A';

    public String toLowerCase(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cTmp = s.charAt(i);
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                cTmp = (char) (s.charAt(i) + asciiMinusNum);
            }
            resStr.append(cTmp);
        }
        return resStr.toString();
    }

}
