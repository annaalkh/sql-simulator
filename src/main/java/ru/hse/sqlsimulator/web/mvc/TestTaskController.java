    package ru.hse.sqlsimulator.web.mvc;

import java.util.Locale;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.sqlsimulator.web.CurrentTaskBean;
import ru.hse.sqlsimulator.web.dto.UserDTO;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;
import ru.hse.sqlsimulator.web.dto.TestPersonDTO;

/**
 * Created by Anna on 10/13/2015.
 */
@Controller
@RequestMapping(value = "/test-task")
public class TestTaskController {
    

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView testTask() {
        ModelAndView modelAndView = new ModelAndView("testTaskJsp");
        StudentTaskDTO taskDTO = new StudentTaskDTO();
        taskDTO.setName("Test task 1");
        taskDTO.setDescription("Task Description");
        taskDTO.setIs_active(true);
        modelAndView.addObject("task", taskDTO);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submitTestTask(@ModelAttribute StudentTaskDTO task) {
        Locale.setDefault(Locale.US);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        String res = "Failed";
        try{
            tx = session.beginTransaction();
            StudentTaskDTO studentTask = new StudentTaskDTO(task.getName(), task.getDescription(), task.isIs_active());
            session.save(studentTask);
            tx.commit();
            res = "New task was created successfully!";
        }catch(HibernateException e){
            res = "Failed with exception";
            if(tx!=null)    tx.rollback();
            throw new RuntimeException(e);
        }finally{
            session.close();
            sessionFactory.close();
        }
        
        task.setName(res);
        ModelAndView modelAndView = new ModelAndView("testTaskJsp");
        modelAndView.addObject("task", task);
        return modelAndView;
    }
}
