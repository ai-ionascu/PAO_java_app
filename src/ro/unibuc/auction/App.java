package ro.unibuc.auction;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ro.unibuc.auction.db.dbCon;

public class App {
    public static void main(String[] args) {
        dbCon con_object = dbCon.getInstance();
        Connection con = con_object.getConnection();

        // READ
        try {
            String selectQuery = "SELECT * FROM test";
            Statement selectStatement = con.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            while (resultSet.next()) {
                String col1 = resultSet.getString("col1");
                String col2 = resultSet.getString("col2");
                String col3 = resultSet.getString("col3");
                String col4 = resultSet.getString("col4");
                System.out.println("col1: " + col1 + ", col2 " + col2 + ", col3: " + col3 + ", col4: " + col4);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        con_object.closeConnection();
    }
}
