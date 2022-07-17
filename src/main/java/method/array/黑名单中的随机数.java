package method.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * leetcode 710
 *
 * @program: suanfati
 * @author: 李沛隆21081020
 * @create: 2022-04-25 11:52
 */
public class 黑名单中的随机数 {
    Map<Integer, Integer> indexMap = new HashMap<>();

    Random random = new Random();

    int n;

    int[] blacklist;

    public 黑名单中的随机数(int n, int[] blacklist) {
        this.n = n;
        this.blacklist = blacklist;
        for (int j : blacklist) {
            indexMap.put(j, -1);
        }
        int index = n - 1;
        int realListSize = n - blacklist.length;

        for (int blackNum : blacklist) {
            //如果数字大于了遍历的长度，直接跳过，不要建立映射即可
            if (blackNum >= realListSize) {
                continue;
            }
            //寻找可用的index（不包含在黑名单）
            while (indexMap.containsKey(index)) {
                index--;
            }
            indexMap.put(blackNum, index);
            index--;
        }
    }

    public int pick() {
        int num = random.nextInt(n - blacklist.length);
        if (indexMap.containsKey(num)){
            return indexMap.get(num);
        }
        return num;
    }
}
