package LAB2.Ex47;

public class Flower extends Plant {
    public Flower(String name, String place, Integer age) {
        super(name, place, age);
    }

    @Override
    public void getType() {
        System.out.println("Flower");
    }
}
