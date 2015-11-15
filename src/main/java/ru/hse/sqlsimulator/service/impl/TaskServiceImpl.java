package ru.hse.sqlsimulator.service.impl;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public StudentTask getActiveTaskForLecture() {        
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(StudentTask.class);
        cr.add(Restrictions.eq("is_active", true));
        StudentTask task = null;
        List tasks = cr.list();
        if(!tasks.isEmpty()) task = (StudentTask) tasks.get(0);
        return task;
    }

    @Transactional
    @Override
    public StudentTask setActiveTaskForLecture(StudentTask studentTask) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(StudentTask.class);
        cr.add(Restrictions.eq("id", studentTask.getId()));
        StudentTask task = null;
        List tasksList = cr.list();
        if(tasksList != null && !tasksList.isEmpty()) task = (StudentTask) tasksList.get(0);
        task.setActive(Boolean.TRUE);
        session.save(task);        
        currentTaskBean.setCurrentTask(studentTask);
        return studentTask;
    }

    @Override
    public StudentTask setActiveTaskForLecture(Integer taskId) {
        return setActiveTaskForLecture(getTaskByID(taskId));
    }

    @Transactional
    @Override
    public void saveTask(StudentTask task) {
        Session session = sessionFactory.getCurrentSession();
        session.save(task);
    }

    @Transactional
    @Override
    public List<StudentTask> getAllTasksForLesson(Date date) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(StudentTask.class);
        cr.add(Restrictions.eq("act_date", date));
        List<StudentTask> tasks =  cr.list();
        return tasks;
    }
    
    @Transactional
    @Override
    public List<StudentTask> getAllTasks() {
        Session session = sessionFactory.getCurrentSession();
        List<StudentTask> tasks = null;
        Criteria cr = session.createCriteria(StudentTask.class);
        tasks = cr.list();
        return tasks;
    }

    @Override
    @Transactional
    public StudentTask getTaskByID(int id){
        Session session = sessionFactory.getCurrentSession();
        StudentTask task = (StudentTask) session.get(StudentTask.class, id);
        return task;
    }
}
