package method.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>leetcode 3</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-06-14 19:39
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        //[left,right) window
        int maxLength = 0, left = 0, right = 0;
        //<value,index>
        HashMap<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            //如果窗口不包含当前右侧元素，右边界扩大；若包含右边界元素，左侧边界走到包含元素的位置，同时依次把元素移除窗口
            if (!window.containsKey(rightChar)) {
                window.put(rightChar, right);
                right++;
                maxLength = Math.max(window.size(), maxLength);
            } else {
                Integer leftBorder = window.get(rightChar);
                while (left <= leftBorder && left < right) {
                    window.remove(s.charAt(left));
                    left++;
                }
                window.put(rightChar, right);
                right++;
            }
        }
        return maxLength;
    }
}
