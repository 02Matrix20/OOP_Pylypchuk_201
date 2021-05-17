package LAB5.DB;

import LAB5.Fish;
import LAB5.Fisherman;
import LAB5.FishTypes.FishTypes;
import LAB5.Utils.Utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class DBUtils {
    public static void close(Connection connection){
        if(connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(Statement statement){
        if(statement == null) return;
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet){
        if(resultSet == null) return;
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Optional<ArrayList<Fisherman>> getFishermen(int partyId, Statement statement) throws SQLException {

        ResultSet rs = statement.executeQuery("SELECT * FROM [Fishermen] WHERE partyId=" + partyId);
        ArrayList<Fisherman> result = new ArrayList<>();

        while (rs.next()) {
            result.add(getFisherman(rs, statement).get());
        }

            return Optional.of(result);
    }

    public static Optional<Fisherman>getFisherman(ResultSet rs, Statement statement) throws SQLException {

        Fisherman fisherman = new Fisherman();
        fisherman.setId(rs.getInt("id"));


        fisherman.setName(rs.getString("Name"));
        var fishermanFish = getFishermanFish(fisherman.getId(), statement);
        fisherman.setFish(fishermanFish);

        return Optional.of(fisherman);
    }

    public static ArrayList<Fish> getFishermanFish(int fishermanId, Statement statement) throws SQLException {

        ResultSet rs = statement.executeQuery("SELECT * FROM Fish WHERE fishermanId=" + fishermanId);
        ArrayList<Fish> result = new ArrayList<>();

        while (rs.next()) {
            result.add(getFish(rs, statement).get());
        }

        return result;
    }

    public static Optional<Fish> getFish(ResultSet rs, Statement statement) throws SQLException {

        Fish fish = new Fish();

        fish.setId(rs.getInt("id"));
        fish.setFishermanId(rs.getInt("fishermanId"));
        fish.setWeight(rs.getDouble("Weight"));
        fish.setDate(rs.getLong("Date"));
        var fishTypeOptional =
                getFishType(rs.getInt("FishTypeId"),
                ConnectionFactory.instance.createConnection().createStatement()
                );
        if(fishTypeOptional.isEmpty()){
            return Optional.empty();
        }
        fish.setFish(fishTypeOptional.get());

        return Optional.of(fish);
    }

    public static Optional<FishTypes> getFishType(int id, Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM [FishTypes] WHERE id=" + id);

        FishTypes fistType = Utils.getFishTypeById( rs.getInt("id"));

        return Optional.of(fistType);
    }


}
