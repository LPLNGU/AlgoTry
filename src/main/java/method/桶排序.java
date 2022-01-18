package method;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: suanfati
 * @description: 主要针对整数、数字大小在一定范围内（取决桶的size）
 * @author: 李沛隆21081020
 * @create: 2022-01-10 20:22
 */
public class 桶排序 {

    @Test
    public void test() {
        int[] inputs = new int[]{98, 22, 123, 343, 222, 123, 334, 54, 23, 42};
        System.out.println(bucketSort(inputs));
    }

    public List<Integer> bucketSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int[] res = new int[10000];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]] = nums[i];
        }
        for (int num : res) {
            if (num != 0)
                result.add(num);
        }
        return result;
    }
}
