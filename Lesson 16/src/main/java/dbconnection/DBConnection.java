package dbconnection;

import model.User;

import java.sql.*;

public class DBConnection {

    public static void main(String[] args) {
    }

    public static User getDBUserCredentials() {
        String url = "jdbc:mysql://localhost:3306/pvt_automation?useSSL=false";
        String login = "root";
        String password = "!@Umwbar1";

        String query = "select * from pvt_automation.user";
        User user = new User();
        try (Connection connection = DriverManager.getConnection(url,
                login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                user.setId(Integer.parseInt((resultSet.getString("id"))));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }
}