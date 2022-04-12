package testShit.instanceoftry;

/**
 * @program: suanfati
 * @description:
 * @author: 李沛隆21081020
 * @create: 2022-02-16 11:04
 */
public class Apple extends Fruit {

    String kind;

    public Apple(Float size, String kind) {
        super(size);
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "kind='" + kind + '\'' +
                '}';
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
