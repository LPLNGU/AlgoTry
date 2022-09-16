package method.array;

/**
 * <p>leetcode 704</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-09-13 15:41
 */
public class 二分搜索 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1, current = -1;
        while (left <= right) {
            current = (left + right) >> 1;
            if (target < nums[current]) {
                right = current - 1;
            } else if (target > nums[current]) {
                left = current + 1;
            } else {
                return current;
            }
        }
        return -1;
    }
}
