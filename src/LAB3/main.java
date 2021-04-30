package LAB3;
import java.util.Calendar;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        Date date = new Date();
        FishermansParty fishermansParty = new FishermansParty();
        fishermansParty.Competitions(date.getTime(), new Date().getTime());

    }
}
