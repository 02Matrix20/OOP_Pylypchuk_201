package LAB5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fisherman {
    int id;
    List<Fish> fish = new ArrayList<>();
    String name;
    public Fisherman(){
    }

    public Fisherman(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Fish> getFish() {
        return fish;
    }

    public void setFish(List<Fish> fish) {
        this.fish = fish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Fisherman{\n" +
                "\tname='" + name + "'\n" +
                "\tfish=" + fish +'\n' +
                "}\n";
    }
}