package LAB5;

import LAB5.FishTypes.FishTypes;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;
import java.util.Random;

public class FishermenParty {
    int id;
    List<FishTypes> fishTypes = new ArrayList<FishTypes>();
    List<Fisherman> fishermen = new ArrayList<>();

    public FishermenParty() {
        fishTypes.add(FishTypes.Pike);
        fishTypes.add(FishTypes.Zander);

        fishermen.add(new Fisherman("Anton",1));
        fishermen.add(new Fisherman("Lesha",2));
        fishermen.add(new Fisherman("Sasha",3));
        fishermen.add(new Fisherman("Sergey",4));
        fishermen.add(new Fisherman("Artem",5));
        for(int i = 0; i < 10; i++)
            throwWorm();
    }

    public void throwWorm() {
        for (var fisherman : fishermen) {
            Random random = new Random();
            if (!random.nextBoolean()) {
                System.out.println("Nothing!");
                continue;
            }
            int fishNum = random.nextInt(fishTypes.size());

            Fish newFish = new Fish(
                    random.nextInt(40),
                    fishTypes.get(fishNum).getClass().getName(),
                    fishTypes.get(fishNum),
                    fisherman.getId());

            fisherman.fish.add(newFish);
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FishTypes> getFishTypes() {
        return fishTypes;
    }

    public void setFishTypes(List<FishTypes> fishTypes) {
        this.fishTypes = fishTypes;
    }

    public List<Fisherman> getFishermen() {
        return fishermen;
    }

    public void setFishermen(List<Fisherman> fishermen) {
        this.fishermen = fishermen;
    }
}
