package testShit.instanceoftry;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-02-16 11:03
 */
public class Fruit {

    private Float size;

    public Fruit(Float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "size=" + size +
                '}';
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }
}
