package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.saveUser("name_" + (byte) (Math.random() * 100), "lastName_" + (byte) (Math.random() * 100), (byte) 34);
        System.out.println(userService.getAllUsers());
    }
}
