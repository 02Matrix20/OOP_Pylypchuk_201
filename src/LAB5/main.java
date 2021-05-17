package LAB5;


import LAB5.DB.ConnectionFactory;
import LAB5.DB.DBUtils;
import LAB5.DB.FishJDBCDao;
import LAB5.DB.FishermenJDBCDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class main {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();;
        initBD(connection);

        FishermenParty fishermenParty = new FishermenParty();

        FishermenJDBCDao fishermenJDBCDao =new FishermenJDBCDao();

        for (var item : fishermenParty.getFishermen()) {

            fishermenJDBCDao.insert(item);

        }
        FishJDBCDao fishJDBCDao = new FishJDBCDao();
        for (var item : fishermenParty.getFishermen()) {
            for (var fish : item.getFish()) {
                fishJDBCDao.insert(fish);
            }
        }
var items = fishermenJDBCDao.getAll();
            for (var fish : items) {
                System.out.println(fish);
            }
    }
    public static void initBD(Connection connection) throws SQLException {
        Statement stmt  = connection.createStatement();
        executeQuery(stmt,
                "drop table if exists Fishermen;drop table if exists Fish;drop table if exists FishTypes; ");
        executeQuery(stmt,
                "CREATE TABLE FishTypes (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT)");
        executeQuery(stmt,
                "INSERT INTO FishTypes(id) " +
                        "VALUES " +
                        "(1)," +
                        "(2)");
        executeQuery(stmt,
                "CREATE TABLE Fishermen (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "NAME TEXT NOT NULL)");
        executeQuery(stmt,
                "CREATE TABLE Fish (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "Weight INT         NOT NULL," +
                        "FishermanId INT    NOT NULL," +
                        "FishTypeId INT     NOT NULL," +
                        "Date INT           NOT NULL," +
                        "FOREIGN KEY(FishermanId) REFERENCES Fishermen(id)" +
                        "FOREIGN KEY(FishTypeId) REFERENCES FishTypes(id))");
        stmt.close();
    }
    public static void executeQuery(Statement stmt, String query) throws SQLException {
        stmt.executeUpdate(query);
    }
}
