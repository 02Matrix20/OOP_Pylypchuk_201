package LAB2.Ex47;

abstract class Plant {
    String name = null;
    String place = null;
    Integer age = null;

    public Plant(String name, String place ){
        this.name = name;
        this.place = place;
    }
    public Plant(String name, String place, Integer age) {
        this.name = name;
        this.place = place;
        this.age = age;
    }
    public void getType(){
        System.out.println("Plant");
    }

}
