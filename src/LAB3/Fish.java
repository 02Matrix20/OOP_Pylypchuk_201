package LAB3;
import LAB3.FishTypes.FishType;

import java.util.Date;

public class Fish {
    double weigth;
    FishType fishType;
    Date date;

    public Fish() {
        weigth = 0;
    }

    public Fish(double weigth, String name, FishType fishType) {
        this.weigth = weigth;
        this.fishType = fishType;
        date = new Date();
    }
}
