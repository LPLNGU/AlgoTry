package method.array;

import java.util.*;

/**
 * @program: suanfati
 * @description: 380. O(1) 时间插入、删除和获取随机元素 实现RandomizedSet 类：  RandomizedSet() 初始化 RandomizedSet 对象 bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。 bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。 int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 * @author: 李沛隆21081020
 * @create: 2022-04-23 17:22
 */
public class RandomizedSet {
    Map<Integer, Integer> map;

    List<Integer> arrayList;

    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        arrayList = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, arrayList.size());
        arrayList.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index == null || index >= arrayList.size() || index < 0) {
            return false;
        }
        Integer lastValue = arrayList.get(arrayList.size() - 1);
        arrayList.set(index, lastValue);
        arrayList.remove(arrayList.size() - 1);
        map.put(lastValue, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return arrayList.get(random.nextInt(arrayList.size()));
    }
}
