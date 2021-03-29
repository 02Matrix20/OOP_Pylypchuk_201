package LAB3;
import LAB3.FishTypes.FishType;
import LAB3.FishTypes.Pike;
import LAB3.FishTypes.Zander;

import java.util.ArrayList;
import java.util.List;

public class FishermansParty {
    static List<FishType> fishTypes = new ArrayList<FishType>();
    List<Fisherman> fishermen = new ArrayList<>();

    public FishermansParty() {
        fishTypes.add(new Pike());
        fishTypes.add(new Zander());

        fishermen.add(new Fisherman("Anton"));
        fishermen.add(new Fisherman("Lesha"));
        fishermen.add(new Fisherman("Sasha"));
        fishermen.add(new Fisherman("Sergey"));
        fishermen.add(new Fisherman("Artem"));
    }
    public void Competitions(){
        Fisherman theBestFisherman;
        Fish theBiggestFish;
        for (var fishType: fishTypes){
            theBiggestFish = new Fish();
            theBiggestFish.fishType = fishType;
            theBestFisherman = null;
            for (var fisher: fishermen) {
                for (var fish : fisher.fish){
                    if(fish.fishType.getClass().getName().equals(fishType.getClass().getName()) && theBiggestFish.weigth < fish.weigth){
                        theBiggestFish = fish;
                        theBestFisherman = fisher;
                    }
                }
            }
            if(theBestFisherman != null)
                System.out.println(theBestFisherman.name + " catch the " + fishType.getClass().getName() + " " + theBiggestFish.weigth );

        }
    }
}
