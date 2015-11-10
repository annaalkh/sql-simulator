package ru.hse.sqlsimulator.service.impl;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.service.TaskService;
import ru.hse.sqlsimulator.web.CurrentTaskBean;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import ru.hse.sqlsimulator.model.User;

/**
 * Created by Anna on 11/4/2015.
 */
@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    CurrentTaskBean currentTaskBean;

    @Override
    public StudentTask getActiveTaskForLecture() {        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        StudentTask task = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(StudentTask.class);
            cr.add(Restrictions.eq("is_active", true));
            List tasks = cr.list();
            if(!tasks.isEmpty()) task = (StudentTask) tasks.get(0);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            sessionFactory.close();
            session.close();
        }
        return task;
    }

    public StudentTask setActiveTaskForLecture(StudentTask studentTask) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        StudentTask task = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(StudentTask.class);
            cr.add(Restrictions.eq("id", studentTask.getId()));
            List tasksList = cr.list();
            if(tasksList != null && !tasksList.isEmpty()) task = (StudentTask) tasksList.get(0);
            task.setActive(Boolean.TRUE);
            session.save(task);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
        
        currentTaskBean.setCurrentTask(studentTask);
        return studentTask;
    }

    @Override
    public StudentTask setActiveTaskForLecture(Integer taskId) {
        return setActiveTaskForLecture(getTaskByID(taskId));
    }

    public void saveTask(StudentTask task) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            session.save(task);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
    }

    public List<StudentTask> getAllTasksForLesson(Date date) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<StudentTask> tasks = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(StudentTask.class);
            cr.add(Restrictions.eq("act_date", date));
            tasks = cr.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
        return tasks;
    }
    
    public List<StudentTask> getAllTasks() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<StudentTask> tasks = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(StudentTask.class);
            tasks = cr.list();
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
        return tasks;
    }

    @Override
    public StudentTask getTaskByID(int id){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Transaction tx = null;
        StudentTask task = null;
        try{
            tx = session.beginTransaction();
            Criteria cr = session.createCriteria(StudentTask.class);
            cr.add(Restrictions.eq("id", id));
            List tasks = cr.list();
            if(tasks != null && !tasks.isEmpty()) task = (StudentTask) tasks.get(0);
            tx.commit();
        }catch(HibernateException e){
            if(tx!=null)    tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
            sessionFactory.close();
        }
        return task;
    }

    
}
