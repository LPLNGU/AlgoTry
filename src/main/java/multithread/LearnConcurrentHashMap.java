package multithread;

import org.junit.Assert;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @className: Test
 * @Description: 学习ConcurrentHashMap
 * @author: lpl
 * @date: 2021/5/13 22:18
 */
public class LearnConcurrentHashMap {

    @org.junit.Test
    public void test() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap(); //初始化ConcurrentHashMap
        //新增个人信息
        map.put("id", "1");
        map.put("name", "andy");
        map.put("sex", "男");
        //获取姓名
        String name = map.get("name");
        Assert.assertEquals(name, "andy");
        //计算大小
        int size = map.size();
        Assert.assertEquals(size, 3);
    }
}
