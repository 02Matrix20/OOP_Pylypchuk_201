package LAB5.DB;

import LAB5.Fish;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static LAB5.DB.DBUtils.getFish;

public class FishJDBCDao implements IDao<Fish> {
    Connection connection;
    Statement statement;

    public FishJDBCDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public Optional<Fish> get(int id) {
        Optional<Fish> result = Optional.empty();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [Fish] WHERE id=" + id);

            if (rs.next()) {
                result = getFish(rs, statement);
                if (result.isEmpty()) {
                    return Optional.empty();
                }
            }
            DBUtils.close(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Fish> getAll() {
        List<Fish> fish = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Fish");

            while (rs.next()) {
                fish.add(getFish(rs, statement).get());
            }

            DBUtils.close(rs);
            DBUtils.close(statement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fish;
    }

    @Override
    public boolean insert(Fish fish) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result =
                statement.execute(
                    "INSERT INTO Fish " +
                        "(Weight,FishermanId ,FishTypeId, Date) " +
                        "VALUES (" +
                            fish.getWeight() + "," +
                            fish.getFishermanId() +  "," +
                            fish.getFish().getFishTypeId() + "," +
                            new Date().getTime() +
                        ")"
            );
            DBUtils.close(statement);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Fish fish) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "UPDATE Fish" +
                            "SET Weight = '" + fish.getWeight() + "'" +
                            "WHERE id = " + fish.getId() + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Fish fish) {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Fish WHERE id=" + fish.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Fish");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}