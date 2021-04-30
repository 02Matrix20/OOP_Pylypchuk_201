package LAB3;
import java.util.Date;

public class Fish {
    double weight;
    FishType fishType;
    long date;

    public Fish() {
        weight = 0;
    }

    public Fish(double weight, FishType fishType) {
        this.weight = weight;
        this.fishType = fishType;
        date = new Date().getTime();
    }
}
