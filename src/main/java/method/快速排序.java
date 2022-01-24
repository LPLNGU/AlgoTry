package method;

import org.junit.Test;

/**
 * @program: suanfati
 * @description: 快排
 * @author: 李沛隆21081020
 * @create: 2022-01-20 19:58
 */
public class 快速排序 {

    public void quickSort(int[] nums, int begin, int end) {
        if (nums == null || end <= begin) {
            return;
        }
        int i = begin, j = end;
        while (i < j) {
            while (nums[j] >= nums[begin] && i < j) {
                j--;
            }
            while (nums[begin] >= nums[i] && i < j) {
                i++;
            }
            if (j > i) {
                swap(nums, i, j);
            }
        }
        swap(nums, begin, i);
        quickSort(nums, begin, i - 1);
        quickSort(nums, i + 1, end);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
