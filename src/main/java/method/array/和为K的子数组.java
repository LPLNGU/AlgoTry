package method.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: suanfati
 * @description: 560
 * @author: 李沛隆21081020
 * @create: 2022-04-11 17:03
 */
public class 和为K的子数组 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int sumCurrent = 0;
        int res = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sumCurrent += nums[i];
            if (preSum.containsKey(sumCurrent - k)) {
                res += preSum.get(sumCurrent - k);
            }
            if (preSum.get(sumCurrent) == null) {
                preSum.put(sumCurrent, 1);
            } else {
                preSum.put(sumCurrent, preSum.get(sumCurrent) + 1);
            }
        }
        return res;
    }
}
