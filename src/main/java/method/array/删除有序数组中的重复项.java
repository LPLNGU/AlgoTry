package method.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: suanfati
 * @description: 26
 * @author: 李沛隆21081020
 * @create: 2022-04-13 14:58
 */
public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int fast = 0, slow = 0;
        //将不等的元素直接往左移
        while (fast < len) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
