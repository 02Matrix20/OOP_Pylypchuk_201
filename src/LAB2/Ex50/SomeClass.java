package LAB2.Ex50;

public class SomeClass {
    static int someVar;
    static {
        someVar = 1;
        System.out.println(someVar);
    }
    {
        someVar = 2;
        System.out.println(someVar);
    }
    public SomeClass() {
        someVar = 3;
        System.out.println(someVar);
    }

}

