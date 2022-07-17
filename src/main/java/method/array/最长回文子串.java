package method.array;

/**
 * @program: suanfati
 * @description: 5
 * @author: 李沛隆21081020
 * @create: 2022-04-15 16:16
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        String resStr, res = "";
        for (int i = 0; i < s.length() - 2; i++) {
            String currentRes1 = palindrome(s, i, i);
            String currentRes2 = palindrome(s, i, i + 1);
            resStr = currentRes1.length() > currentRes2.length() ? currentRes1 : currentRes2;
            res = res.length() > resStr.length() ? res : resStr;
        }
        return res;
    }

    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            l--;
            r++;
        }
        //注意 左闭右开区间
        return s.substring(l + 1, r);
    }
}
