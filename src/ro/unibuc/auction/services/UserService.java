package ro.unibuc.auction.services;

import java.util.List;
import java.util.ArrayList;

import ro.unibuc.auction.db.dbCon;
import ro.unibuc.auction.models.User;
import java.sql.*;

public class UserService implements CRUDService <User> {
    private List<User> userList;
    dbCon con_object;
    Connection connection;
    public UserService() {
        this.userList = new ArrayList<>();
        this.con_object = dbCon.getInstance();
        this.connection = con_object.getConnection();
    }

    @Override
    public void create(User user) {

        try {
            String selectQuery = "SELECT COUNT(*) FROM user WHERE username = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, user.getUsername());
            ResultSet resultSet = selectStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count > 0) {
                    System.out.println("Username already exists.");
                } else {
                    try {
                        String insertQuery = "INSERT INTO user (username, email) VALUES (?, ?)";
                        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                        insertStatement.setString(1, user.getUsername());
                        insertStatement.setString(2, user.getEmail());
                        int rowsInserted = insertStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("User successfully registered.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        con_object.closeConnection();
    }

    @Override
    public List<User> read() {
        try {
            String selectQuery = "SELECT * FROM user";
            Statement selectStatement = connection.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String name = resultSet.getString("username");
                String email = resultSet.getString("email");

                User user = new User(name, email);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        con_object.closeConnection();
        return userList;
    }

    @Override
    public void update(User oldUser, User newUser) {
        try {
            String updateQuery = "UPDATE user SET username = ?, email = ? WHERE username = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, newUser.getUsername());
            updateStatement.setString(2, newUser.getEmail());
            updateStatement.setString(3, oldUser.getUsername());

            int rowsUpdated = updateStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        con_object.closeConnection();
    }

    @Override
    public void delete(User user) {
        try {
            String deleteQuery = "DELETE FROM user WHERE username = ?";
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, user.getUsername());

            int rowsDeleted = deleteStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("User delete failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        con_object.closeConnection();
    }
}
