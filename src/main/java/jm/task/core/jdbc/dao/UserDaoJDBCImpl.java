package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String string = "CREATE TABLE users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    name VARCHAR(50) NOT NULL UNIQUE,\n" +
                "    lastName VARCHAR(50) NOT NULL UNIQUE, \n" +
                "    age INT\n" +
                ");";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(string);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String string = "DROP TABLE users;";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(string);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String string = "INSERT INTO users (\n" +
                "name, " +
                "lastName, " +
                "age) " +
                "VALUES (\'" +
                name + "\', \'" +
                lastName + "\', " +
                age + ")";
        System.out.println(string);
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()){
             statement.execute(string);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String string = "DELETE FROM users WHERE id = " + id;
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()){
            statement.execute(string);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String string = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()){
            statement.execute(string);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    public void cleanUsersTable() {
        String string = "DELETE FROM users";
        try (Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()){
            statement.execute(string);
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
