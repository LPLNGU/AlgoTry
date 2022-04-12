package method.array;

/**
 * @program: suanfati
 * @description: 303    小而美的算法技巧：前缀和数组
 * @author: 李沛隆21081020
 * @create: 2022-04-08 16:17
 */
public class 区域和检索数组不可变 {

    int[] preSum;

    public 区域和检索数组不可变(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
