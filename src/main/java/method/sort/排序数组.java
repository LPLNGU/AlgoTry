package method.sort;

/**
 * <p>leetcode 912</p>
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-05-31 17:41
 */
public class 排序数组 {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    /**
     * 找到第一个元素的位置，此元素左侧都小于它自己，右侧大于它自己
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    public int partition(int[] nums, int lo, int hi) {
        //分割数为第一个，后续为左侧的指针，右侧指针
        int pivot = nums[lo], i = lo + 1, j = hi;
        while (i <= j) {
            //左侧指针依次右移，判断指针值是否小于等于中间值，
            while (nums[i] <= pivot && i < hi) {
                i++;
            }
            while (nums[j] > pivot && j > lo) {
                j--;
            }
            //[lo,i) <= num , (j,hi] > num , 此时right就是目标位置
            if (j <= i) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
