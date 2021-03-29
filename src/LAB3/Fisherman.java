package LAB3;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fisherman {
    List<Fish> fish = new ArrayList<>();
    String name;

    public Fisherman(){
    }

    public Fisherman(String name) {
        this.name = name;
        for (int i = 0; i < 1000; i ++){
            fishing();
        }
    }

    public void fishing(){
        Random random = new Random();
        if(!random.nextBoolean()){
            System.out.println("Nothing :(");
            return;
        }
        int fishNum = random.nextInt(FishermansParty.fishTypes.size());

        Fish newFish = new Fish(
                random.nextInt(100),
                FishermansParty.fishTypes.get(fishNum).getClass().getName(),
                FishermansParty.fishTypes.get(fishNum));

        fish.add(newFish);
    }
}