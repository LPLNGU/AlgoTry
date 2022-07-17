package method.dp;

import java.util.Arrays;

/**
 * <p>leetcode 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-06-30 16:53
 */
public class 最长递增子序列 {
    /**
     * 动态规划解法，自底向上的dp。dp[i]含义为结尾为num[i]的递增子序列的长度
     * dp[i] = max(dp[i],dp[小于自己的数字中最大的长度])
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }
}
