package LAB5;

import LAB5.FishTypes.FishTypes;

import java.time.Instant;
import java.util.Date;

public class Fish {
    int id;
    int fishermanId;
    double weight;
    FishTypes fishType;
    Date date;

    public Fish() {
        weight = 0;
    }

    public Fish(double weigth, String name, FishTypes fishType,int fishermanId) {
        this.weight = weigth;
        this.fishType = fishType;
        this.fishermanId = fishermanId;
        date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFishermanId() {
        return fishermanId;
    }

    public void setFishermanId(int fishermanId) {
        this.fishermanId = fishermanId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public FishTypes getFish() {
        return fishType;
    }

    public void setFish(FishTypes fish) {
        this.fishType = fish;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = Date.from(Instant.ofEpochSecond(date));
    }

    @Override
    public String toString() {
        return "\n\t\tFish{\n" +
                "\t\t\tid=" + id + '\n' +
                "\t\t\tweight=" + weight + '\n'+
                "\t\t\tfishType=" + fishType +'\n'+
                "\t\t}\n";
    }
}
