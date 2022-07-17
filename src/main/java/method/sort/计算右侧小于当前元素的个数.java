package method.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>归并排序类似  leetcode315</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-19 19:32
 */
public class 计算右侧小于当前元素的个数 {
    List<Integer> temp = new ArrayList<>();
    List<Integer> res = new ArrayList<>();

    /*public List<Integer> countSmaller(int[] nums) {
        if (nums.length <= 1) {
            return Collections.singletonList(0);
        }
        int high = nums.length - 1, low = 0, mid = low + (high - low) >> 1;
        for (int num : nums) {
            temp.add(num);
        }

    }*/

    public void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = hi - lo;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k < mid + 1; k++) {
            if (k == mid + 1) {
                nums[k] = temp.get(j++);
            } else if (k == hi + 1) {
                nums[k] = temp.get(i++);

            } else if (nums[i] < nums[j]) {
                nums[k] = temp.get(i++);
            } else {
                nums[k] = temp.get(j++);
            }
        }
    }
}
