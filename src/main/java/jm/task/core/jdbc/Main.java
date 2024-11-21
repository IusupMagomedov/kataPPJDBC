package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
        userService.saveUser("name1", "lastName1", (byte) 34);
        userService.cleanUsersTable();
        System.out.println(userService.getAllUsers());
    }
}
