package LAB5.DB;


import LAB5.Fisherman;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FishermenJDBCDao implements IDao<Fisherman>{
    Connection connection ;
    Statement stmt ;

    public FishermenJDBCDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        stmt = connection.createStatement();
    }

    @Override
    public Optional<Fisherman> get(int id) {
        Fisherman result = new Fisherman();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Fishermen WHERE id=" + id);

            if (rs.next()) {
               result = DBUtils.getFisherman(rs, stmt).get();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.of(result);
    }

    @Override
    public List<Fisherman> getAll() {
        List<Fisherman> fishermen = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Fishermen order by id; ");
            while (rs.next())
            {
                Fisherman fisherman = DBUtils.getFisherman(rs, connection.createStatement()).get();

                fishermen.add(fisherman);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fishermen;
    }

    @Override
    public boolean insert(Fisherman fisherman) {
        boolean result = false;
        try {

            result = stmt.execute(
                    "INSERT INTO Fishermen(name) VALUES('"+ fisherman.getName()+"');");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Fisherman fisherman) {
        boolean result = false;
        try {
            Statement stmt = connection.createStatement();
            result = stmt.execute(
                    "UPDATE Fishermen" +
                            "SET Name = '"+ fisherman.getName()+ "'" +
                            "WHERE id = "+fisherman.getId()+";");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Fisherman fisherman) {
        boolean result = false;
        try {
            result = stmt.execute(
                    "DELETE FROM Fishermen WHERE id="+fisherman.getId());
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = stmt.execute(
                    "DELETE FROM Fishermen");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
