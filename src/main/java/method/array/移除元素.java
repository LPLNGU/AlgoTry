package method.array;

/**
 * @program: suanfati
 * @description: 27
 * @author: 李沛隆21081020
 * @create: 2022-04-13 15:23
 */
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
