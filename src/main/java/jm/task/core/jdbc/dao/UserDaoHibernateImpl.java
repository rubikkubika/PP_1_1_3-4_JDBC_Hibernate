package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static Session session;
    List<User> userList = new ArrayList<>();


    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users(ID int NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID), " +
        "name varchar(255), lastname varchar(255), age tinyint);").executeUpdate();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF  EXISTS  users;").executeUpdate();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session = Util.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);

        session.save(user);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
        session.getTransaction().commit();
        session.close();
        }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        session = Util.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        userList = query.getResultList();
        userList.forEach(x -> System.out.println(x.toString()));
        session.close();
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        session = Util.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
        Root<User> root = criteriaDelete.from(User.class);
        criteriaDelete.from(root.getModel());

        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaDelete).executeUpdate();
        transaction.commit();
        session.close();
    }
}
