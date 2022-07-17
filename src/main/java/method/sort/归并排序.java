package method.sort;

import java.util.*;

/**
 * <p>两路合并排序</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-06 11:01
 */
public class 归并排序 {
    int[] tmp;

    /*public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }*/

    public int[] MySort(int[] arr) {
        tmp = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public void sort(int[] nums, int begin, int end) {
        if (begin == end) {
            return;
        }
        int mid = (begin + end) / 2;
        sort(nums, begin, mid);
        sort(nums, mid + 1, end);
        merge(nums, begin, mid, end);
    }

    public void merge(int[] nums, int begin, int mid, int end) {
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        int i = begin, j = mid + 1;
        for (int k = begin; k <= end; k++) {
            //这种情况为判定左侧走完最后一位，此时只需要继续计算右侧的数据
            if (i == mid + 1) {
                nums[k] = tmp[j++];
                //此时右侧走完最后一位，只需要把左侧赋值进去即可
            } else if (j == end + 1) {
                nums[k] = tmp[i++];
                //两个都没有走到结尾时，直接把较小的进行赋值
            } else if (tmp[i] < tmp[j]) {
                nums[k] = tmp[i++];
            } else if (tmp[i] > tmp[j]) {
                nums[k] = tmp[j++];
            }
        }
    }
}
