package method.array;

/**
 * @program: suanfati
 * @description: 34 note:
 * 1、分析二分查找代码时，不要出现 else，全部展开成 else if 方便理解。
 * <p>
 * 2、注意「搜索区间」和 while 的终止条件，如果存在漏掉的元素，记得在最后检查。
 * <p>
 * 3、如需定义左闭右开的「搜索区间」搜索左右边界，只要在 nums[mid] == target 时做修改即可，搜索右侧时需要减一。
 * <p>
 * 4、如果将「搜索区间」全都统一成两端都闭，好记，只要稍改 nums[mid] == target 条件处的代码和返回的逻辑即可，推荐拿小本本记下，作为二分搜索模板。
 * @author: 李沛隆21081020
 * @create: 2022-04-15 11:24
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearchLeft(nums, target);
        res[1] = binarySearchRight(nums, target);
        return res;
    }

    public int binarySearchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        //对应target大于所有数字，target小于所有数字的情况下left不会变，因此可以直接判定，而匹配失败也无法相等
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int binarySearchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        //对应target小于所有数，其它情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
