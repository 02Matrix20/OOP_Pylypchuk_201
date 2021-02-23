package LAB2.Ex47;

public class Tree extends Plant {
    public Tree(String name, String place, Integer age) {
        super(name, place, age);
    }

    @Override
    public void getType() {
        System.out.println("Tree");
    }
}
