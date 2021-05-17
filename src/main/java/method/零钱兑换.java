package method;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: 零钱兑换
 * @Description: 322零钱兑换 todo
 * @author: lpl
 * @date: 2021/5/17 22:25
 */
public class 零钱兑换 {
    @Test
    public void run() {
        int[] coins = {186, 419, 83, 408};
        System.out.println(coinChange(coins, 6249));
    }

    //解法1 自顶向下 （超时）
//    public int coinChange(int[] coins, int amount) {
//
//        return dp(coins, amount);
//
//    }
//
//    public int dp(int[] coins, int amount) {
//        //base case
//        if (amount == 0) {
//            return 0;
//        }
//        if (amount < 0) {
//            return -1;
//        }
//        //求最小值，所以初始化为正无穷
//        int res = Integer.MAX_VALUE;
//        for (int num : coins) {
//            int subProblem = dp(coins, amount - num);
//            //子问题无解，跳过
//            if (subProblem == -1) {
//                continue;
//            }
//            //最优子问题
//            res = Math.min(res, subProblem + 1);
//        }
//        return (res != Integer.MAX_VALUE )? res : -1;
//    }


    //对方法1进行优化，使用备忘录
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int dp(int[] coins, int amount) {
        //查验备忘录是否存在
        if (map.get(amount) != null) {
            return map.get(amount);
        }
        //base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        //求最小值，所以初始化为正无穷
        int res = Integer.MAX_VALUE;
        for (int num : coins) {
            int subProblem = dp(coins, amount - num);
            //子问题无解，跳过
            if (subProblem != -1) {
                //最优子问题
                res = Math.min(res, subProblem + 1);
            }
        }
        //放入备忘录
        if (res != Integer.MAX_VALUE) {
            map.put(amount, res);
        } else {
            map.put(amount, -1);
        }
        return (res != Integer.MAX_VALUE) ? res : -1;
    }

}
