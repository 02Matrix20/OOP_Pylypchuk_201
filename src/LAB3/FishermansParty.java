package LAB3;

import java.text.SimpleDateFormat;
import java.util.*;

public class FishermansParty {
    private  Set<FishType> fishTypes = new HashSet<>();
    private  List<Fisherman> fishermen = new ArrayList<>();

    public  boolean addNewFisherman(Fisherman fisherman){
        return fishermen.add(fisherman);
    }
    public Set<FishType> getFishTypes() {
        return fishTypes;
    }

    public void setFishTypes(Set<FishType> fishTypes) {
        this.fishTypes = fishTypes;
    }

    public List<Fisherman> getFishermen() {
        return fishermen;
    }

    public void setFishermen(List<Fisherman> fishermen) {
        this.fishermen = fishermen;
    }

    public FishermansParty() {
        fishTypes.addAll(Arrays.stream(FishType.values()).toList());
    }

    public boolean Competitions(long begin, long end){
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
        return true;
    }
}
