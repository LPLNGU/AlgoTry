package method.array;

/**
 * @program: suanfati
 * @description: leetcode 875
 * @author: 李沛隆21081020
 * @create: 2022-04-27 16:38
 */
public class 爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MAX_VALUE,
                mid, currentTime;
        while (left < right) {
            mid = left + (right - left) / 2;
            currentTime = f(piles, mid);
            //缩小左侧边界，因为当前不符合
            if (currentTime > h) {
                left = mid + 1;
                //右侧边界符合即可缩小区域
            } else if (currentTime <= h) {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 返回piles 在K的速度下，使用的时间
     *
     * @param piles
     * @param k
     * @return
     */
    public int f(int[] piles, int k) {
        int h = 0;
        for (int pile : piles) {
            h += pile / k;
            if (pile % k > 0) {
                h++;
            }
        }
        return h;
    }
}
