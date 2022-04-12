package testShit.cglibTest;

import org.junit.Test;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-02-25 11:16
 */
    public class TestProxy {
        @Test
        public void testGclib() {
            UserDao target = new UserDao();
            System.out.println(target.getClass());
            //制作target的动态代理类
            UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
            System.out.println(proxy.getClass());
            proxy.save();
        }
    }
