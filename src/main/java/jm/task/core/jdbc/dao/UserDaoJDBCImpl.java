package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }
    @Override
    public void createUsersTable() {
        String string = "CREATE TABLE users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    name VARCHAR(50) NOT NULL UNIQUE,\n" +
                "    last_name VARCHAR(50) NOT NULL UNIQUE, \n" +
                "    age INT\n" +
                ");";
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(string)) {
            preparedStatement.execute();
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void dropUsersTable() {
        String string = "DROP TABLE users;";
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(string)) {
            preparedStatement.execute();
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        String string = "INSERT INTO users (\n" +
                "name, " +
                "last_name, " +
                "age) " +
                "VALUES (\'" +
                name + "\', \'" +
                lastName + "\', " +
                age + ")";
        System.out.println(string);
        try (Connection connection = Util.getConnection();
             PreparedStatement prepearedStatement = connection.prepareStatement(string)){
             prepearedStatement.execute();
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void removeUserById(long id) {
        String string = "DELETE FROM users WHERE id = " + id;
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(string)){
            preparedStatement.execute();
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<User> getAllUsers() {
        String string = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(string)){
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next())                            {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
    @Override
    public void cleanUsersTable() {
        String string = "DELETE FROM users";
        try (Connection connection = Util.getConnection();
             PreparedStatement prepearedStatement = connection.prepareStatement(string)){
            prepearedStatement.execute();
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}