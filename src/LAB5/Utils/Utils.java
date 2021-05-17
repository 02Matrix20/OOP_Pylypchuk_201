package LAB5.Utils;

import LAB5.FishTypes.FishTypes;

public class Utils {
    public  static FishTypes getFishTypeById(int id){
        return switch (id) {
            case 1 -> FishTypes.Pike;
            case 2 -> FishTypes.Zander;
            default -> null;
        };
    }
}
