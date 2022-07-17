package method.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>解法： 堆、排序算法</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-26 16:13
 */
public class 数组中的第K个最大元素 {
    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        //默认a-b是小根堆
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            queue.offer(num);
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = queue.remove();
        }
        return res;
    }


    //快速排序
    public int findKthLargest01(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        pre(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public void pre(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        pre(nums, left, partition - 1);
        pre(nums, partition + 1, right);
    }

    /**
     * 找到第一个元素的位置，此元素左侧都小于它自己，右侧大于它自己
     *
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    public int partition(int[] nums, int begin, int end) {
        int partitionNum = nums[begin], left = begin + 1, right = end;
        while (right >= left) {
            while (nums[left] <= partitionNum && left < end) {
                left++;
            }
            while (nums[right] > partitionNum && right > begin) {
                right--;
            }
            //[begin,left) <= num , (right,end] > num , 此时right就是目标位置
            if (right <= left) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, begin, right);
        return right;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
