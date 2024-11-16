package jm.task.core.jdbc.dao;

import com.mysql.cj.Query;
import com.mysql.cj.Session;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import jm.task.core.jdbc.util.HibernateUtil;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Query query
    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.getSessionFactory().openSession()) {    //пытаемся получить сессию, подключиться к базе
            transaction = session.beginTransaction();
            и потом коммитим соответственно либо сессию, либо транзакцию
            В эксепшине проверяем на null, если что-то есть, делаем rollback
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
