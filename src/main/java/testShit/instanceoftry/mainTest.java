package testShit.instanceoftry;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-02-16 11:07
 */
public class mainTest {
    public static void main(String[] args) {
        Fruit fruit = new Fruit((float) 11.1);
        Apple apple = new Apple((float) 1.1, "apple");
        System.out.println(fruit instanceof Fruit);
        //输出true，可见对父类使用instanceof，也可以判断是此类
        System.out.println(apple instanceof Fruit);
    }
}
