package ru.hse.sqlsimulator.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import ru.hse.sqlsimulator.model.User;
import ru.hse.sqlsimulator.service.UserService;

/**
 * Created by Anna on 11/4/2015.
 */
@Component
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByID(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = null;
        User user = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("id", id));
            List users = cr.list();
            if(!users.isEmpty()) user = (User) users.get(0);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = null;
        List<User> users = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(User.class);
            users = cr.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
        return users;
    }

    @Override
    public List<User> getAllUsersWithRole(int role){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = null;
        List<User> users = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("role", role));
            users = cr.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
        return users;
    }
   
}
