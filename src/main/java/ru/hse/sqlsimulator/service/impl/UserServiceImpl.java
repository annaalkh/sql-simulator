package ru.hse.sqlsimulator.service.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.hse.sqlsimulator.model.User;
import ru.hse.sqlsimulator.service.UserService;

/**
 * Created by Anna on 11/4/2015.
 */
@Component
public class UserServiceImpl implements UserService {
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public User getUserByID(int id){
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("id", id));
        User user = null;
        List users = cr.list();
        if(!users.isEmpty()) user = (User) users.get(0);
        return user;
    }

    @Override
    @Transactional
    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(User.class);
        List<User> users = cr.list();
        return users;
    }

    @Override
    @Transactional
    public List<User> getAllUsersWithRole(int role){
        Session session = sessionFactory.openSession();        
        Criteria cr = session.createCriteria(User.class);
        cr.add(Restrictions.eq("role", role));
        List<User> users = cr.list();
        return users;
    }
   
}
