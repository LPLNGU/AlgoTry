package method.array;

/**
 * <p>leetcode 209</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-09-14 11:33
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, size = 0, res = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                size = right - left + 1;
                res = Math.min(res, size);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
