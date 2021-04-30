package LAB3;

import java.text.SimpleDateFormat;
import java.util.*;

public class FishermansParty {
    public static Set<FishType> fishTypes = new HashSet<>();
    public static List<Fisherman> fishermen = new ArrayList<>();

    public FishermansParty() {
        fishTypes.addAll(Arrays.stream(FishType.values()).toList());

        fishermen.add(new Fisherman("Anton"));
        fishermen.add(new Fisherman("Lesha"));
        fishermen.add(new Fisherman("Sasha"));
        fishermen.add(new Fisherman("Sergey"));
        fishermen.add(new Fisherman("Artem"));
    }
    public void Competitions(long begin, long end){
        for (var fishType: fishTypes){
            Fish theBiggestFish = new Fish();
            Fisherman theBestFisherman = null;
            for (var fisher: fishermen) {
                for (var fish : fisher.fish){
                    if(fish.fishType.equals(fishType) && theBiggestFish.weight < fish.weight &&  fish.date > begin && fish.date < end ){
                        theBiggestFish = fish;
                        theBestFisherman = fisher;
                    }
                }
            }
            if(theBestFisherman != null)
                System.out.println(theBestFisherman.name + " catch the " + fishType + " " + theBiggestFish.weight );

            String beginDateString = new SimpleDateFormat("MM/dd/yyyy").format(new Date(begin));
            System.out.println(" Fishing start time: " + beginDateString);

            String endDateString = new SimpleDateFormat("MM/dd/yyyy").format(new Date(end));
            System.out.println(" Fishing end time: " + endDateString);
        }
    }
}
