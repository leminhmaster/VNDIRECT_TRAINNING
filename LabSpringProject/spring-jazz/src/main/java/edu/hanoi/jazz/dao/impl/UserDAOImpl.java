package edu.hanoi.jazz.dao.impl;

import edu.hanoi.jazz.dao.UserDAO;
import edu.hanoi.jazz.dao.model.Group;
import edu.hanoi.jazz.dao.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
    private final static int SIZE_OF_PAGE = 2;
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    @Override
    public void insert(User user) {
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            session.getTransaction().begin();
            session.save(user);
            session.flush();
            session.getTransaction().commit();
            LOGGER.info("Save user "+user.getUsername()+" done!");
        }finally {
            //session.close();
        }

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String username) {
        Session session = sessionFactoryBean.getObject().openSession();
        Query query = session.createQuery("delete from User where username like :name");
        session.getTransaction().begin();
        query.setParameter("name", username);
        Integer result = query.executeUpdate();
        session.getTransaction().commit();
        LOGGER.info("Rows affected : "+result+"\n\n");
        session.close();
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public List<User> getUsersByGroup(Integer group) {
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            if (group == null || group < 0 ){
                Query query = session.createQuery("from User order by age desc");
                return (List<User>) query.list();
            }
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("groupId",group));
            return new ArrayList<User>(criteria.list());
        }finally {
            session.close();
        }
    }

    @Override
    public User get(String username) {
        Session session = sessionFactoryBean.getObject().openSession();
        User user = session.get(User.class,username);
        return user;
    }

    @Override
    public List<User> listOlder() {
        Session session = sessionFactoryBean.getObject().openSession();
//        Criteria cr = session.createCriteria(User.class);
//        cr.add(Restrictions.gt("age",50));
//        return (List<User>) cr.list();
        try {
            String sql = "SELECT * FROM HN_USER WHERE age < :value";
            NativeQuery query = session.createSQLQuery(sql);
            query.addEntity(User.class);
            query.setParameter("value",50);
            System.out.println("========> " + query.list().size());
            return (List<User>) query.list();

        }finally {
            session.close();
        }

    }

    @Override
    public List<User> page(int page) {
        Session session = sessionFactoryBean.getObject().openSession();
        Criteria cr = session.createCriteria(User.class);
        int start = (page-1)*SIZE_OF_PAGE;
        cr.setFirstResult(start);
        cr.setMaxResults(SIZE_OF_PAGE);
        return (List<User>) cr.list();
    }

    @Override
    public List<User> listUserByNativeSql() {
        Session session = sessionFactoryBean.getObject().openSession();
        try {
            NativeQuery query = session.createSQLQuery("SELECT * FROM HN_USER");
            query.addEntity(User.class);
            return query.list();
        }finally {
            session.close();
        }


    }

    @Override
    public void addBatch() {
        Session session = sessionFactoryBean.getObject().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for (int i = 0; i < 50; i++) {
                session.save(UserFactory.generate(i+1));
            }
            session.flush();
            tx.commit();
        }catch (Exception e) {
            if (tx != null) tx.rollback();
            LOGGER.error(e,e);
        }finally {
            session.close();
        }
    }

    public int averageAge(){
        Session session = sessionFactoryBean.getObject().openSession();
        Criteria cr = session.createCriteria(User.class);
        cr.setProjection(Projections.avg("age"));
        List avgAge = cr.list();
        return ((Double) avgAge.get(0)).intValue();
    }
}
