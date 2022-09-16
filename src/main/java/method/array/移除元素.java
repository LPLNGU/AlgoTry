package method.array;

/**
 * @program: suanfati
 * @description: 27
 * @author: 李沛隆21081020
 * @create: 2022-04-13 15:23
 */
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (val != nums[fast]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
