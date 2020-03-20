package core.dbconnection;

import core.model.Search;

import java.sql.*;

public class DBConnection {

    public static void main(String[] args) {
    }

    public static Search getDBUserCredentials() {
        String url = "jdbc:mysql://localhost:3306/pvt_automation?useSSL=false";
        String login = "root";
        String password = "!@Umwbar1";

        String queryValidCredentials = "select * from pvt_automation.user where id = 1";
        Search SearchQuery = new Search();
        try (Connection connection = DriverManager.getConnection(url,
                login, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(queryValidCredentials)) {
            while (resultSet.next()) {
                SearchQuery.setId(Integer.parseInt((resultSet.getString("id"))));
                SearchQuery.setLogin(resultSet.getString("login"));
                SearchQuery.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return SearchQuery;
    }
}