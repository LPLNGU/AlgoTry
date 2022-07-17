package method.array;

/**
 * @program: suanfati
 * @description: 1109
 * @author: 李沛隆21081020
 * @create: 2022-04-13 11:17
 */
public class 航班预定统计 {

    private int[] diff;

    public int[] corpFlightBookings(int[][] bookings, int n) {
        buildDiff(new int[n]);
        for (int i = 0; i < bookings.length; i++) {
            changeDiff(bookings[i][0], bookings[i][1], bookings[i][2]);
        }
        return cal();
    }

    public void buildDiff(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void changeDiff(int left, int right, int num) {
        //注意此处修改diff
        left--;
        right--;
        diff[left] += num;
        //注意边界值
        if (right + 1 < diff.length) {
            diff[right + 1] -= num;
        }
    }

    public int[] cal() {
        if (diff == null) {
            return null;
        }
        int[] arr = new int[diff.length];
        arr[0] = diff[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + diff[i];
        }
        return arr;
    }

}
