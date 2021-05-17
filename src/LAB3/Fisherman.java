package LAB3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Fisherman {
    List<Fish> fish = new ArrayList<>();
    String name;

    public Fisherman(String name) {
        this.name = name;
        for (int i = 0; i < 50; i ++){
            throwWorm();

        }
    }

    public void throwWorm(){
        Random random = new Random();
        if(!random.nextBoolean()){
            return;
        }
        int fishNum = random.nextInt(FishType.values().length);

        Fish newFish = new Fish(
                random.nextInt(40),
                Arrays.stream(FishType.values()).toList().get(fishNum));
        fish.add(newFish);
    }

}