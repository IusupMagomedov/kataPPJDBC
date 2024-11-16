package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    // private UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
    private final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        // userDao.createUsersTable();
        userDaoHibernate.createUsersTable();
    }
    @Override
    public void dropUsersTable() {
        // userDao.dropUsersTable();
        userDaoHibernate.dropUsersTable();
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        // userDao.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name, lastName, age);
    }
    @Override
    public void removeUserById(long id) {
        // userDao.removeUserById(id);
        userDaoHibernate.removeUserById(id);
    }
    @Override
    public List<User> getAllUsers() {
        // return userDao.getAllUsers();
        return userDaoHibernate.getAllUsers();
    }
    @Override
    public void cleanUsersTable() {
        // userDao.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();
    }
}
