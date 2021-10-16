package lpl.offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Algorithm
 * @description: 剑指Offer03
 * @author: 李沛隆21081020
 * @create: 2021-10-03 09:39
 */
public class 数组中重复的数字 {

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int res = -1;
        for (int num : nums) {
            if (set.contains(num)) {
                res = num;
                break;
            }
            set.add(num);
        }
        if (res == -1) {
            return 0;
        }
        return res;
    }

    //solution2
    public int findRepeatNumber(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            tmp = nums[i];
            nums[i] = nums[nums[i]];
            nums[tmp] = tmp;
            //交换之后需要抵消i++;下一次仍遍历本位置，但是位置上的值是交换过来的值。
            i--;
        }
        return -1;
    }

    @Test
    public void main() {
        int input[] = {3, 4, 2, 0, 0, 1};
        findRepeatNumber(input);
    }
}
