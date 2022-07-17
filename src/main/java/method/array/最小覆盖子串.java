package method.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: suanfati
 * @description: 76 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @author: 李沛隆21081020
 * @create: 2022-04-20 09:48
 */
public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int slow = 0, fast = -1, left = -1, right = -1;
        Integer length = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> chars = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            chars.put(t.charAt(i), chars.getOrDefault(t.charAt(i), 0) + 1);
        }
        while (fast < s.length()) {
            ++fast;
            //检查是否右侧指针所含的元素
            if (fast < s.length() && chars.containsKey(s.charAt(fast))) {
                window.put(s.charAt(fast), window.getOrDefault(s.charAt(fast), 0) + 1);
            }
            //左侧指针进行移动
            while (containsString(window, chars) && slow <= fast) {
                //不断收缩左侧指针以达到最短长度,并且不断与之前最短的长度比较，以确定是否是出现过的最小的字串
                if (fast - slow + 1 < length) {
                    left = slow;
                    length = fast - slow + 1;
                    right = slow + length;
                }
                char slowChar = s.charAt(slow);
                if (chars.containsKey(slowChar)) {
                    window.put(slowChar, window.get(slowChar) - 1);
                }
                ++slow;
            }
        }
        if (left == -1) {
            return "";
        }
        return s.substring(left, right);
    }

    //判定window中是否包含chars
    public boolean containsString(Map<Character, Integer> window, Map<Character, Integer> chars) {
        // 0不包含，1多余包含，2刚好包含
        boolean res = true;
        for (Character character : chars.keySet()) {
            boolean currentRes = window.containsKey(character) &&
                    (window.get(character) - chars.get(character) >= 0);
            res = currentRes && res;
        }
        return res;
    }

    @Test
    public void test() {
        String s = "ASQWERHL";
        String t = "SL";
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> word = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            word.put(t.charAt(i), 1);
        }
        System.out.println(containsString(window, word));
    }

    @Test
    public void test1() {
        String str1 = "ADOBECODEBANC";
        String str2 = "ABC";
        System.out.println(minWindow(str1, str2));
    }

}
