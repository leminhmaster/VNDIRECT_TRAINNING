package edu.hanoi.data.Impl;

import edu.hanoi.data.GroupDAO;
import edu.hanoi.message.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component("groupDAO")
public class GroupDAOImpl implements GroupDAO {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    @Qualifier("sessionFactory")
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    @Qualifier("sessionFactory_oracle")
    private LocalSessionFactoryBean sessionFactory_oracle;

    @Override
    public String add(Group group) {
        Session session = sessionFactory.getObject().openSession();
        Session session_oracle = sessionFactory_oracle.getObject().openSession();
        try {
            session.getTransaction().begin();
            Serializable o = session.save(group);
            session.flush();
            session.getTransaction().commit();

            session_oracle.getTransaction().begin();
            session_oracle.save(group);
            session_oracle.flush();
            session_oracle.getTransaction().commit();

            return o.toString();
        }finally {
            session.close();
            session_oracle.close();
        }

    }

    @Override
    public List<Group> list() {

        return null;
    }

}
