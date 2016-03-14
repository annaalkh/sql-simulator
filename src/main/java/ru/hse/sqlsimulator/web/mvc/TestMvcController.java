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
import ru.hse.sqlsimulator.model.User;
import ru.hse.sqlsimulator.web.CurrentTaskBean;
import ru.hse.sqlsimulator.web.dto.TestPersonDto;
import ru.hse.sqlsimulator.web.dto.UserDto;
import ru.hse.sqlsimulator.web.dto.StudentTaskDto;
import ru.hse.sqlsimulator.web.dto.TestPersonDto;

/**
 * Created by Anna on 10/13/2015.
 */
@Controller
public class TestMvcController {
    

    @RequestMapping(value = "/test-mvc", method = RequestMethod.GET)
    public ModelAndView testPage() {
        ModelAndView modelAndView = new ModelAndView("testPageJsp");
        TestPersonDto testPersonDto = new TestPersonDto();
        testPersonDto.setName("Test name");
        testPersonDto.setSurname("Test surname");
        modelAndView.addObject("person", testPersonDto);
        return modelAndView;
    }

    @RequestMapping(value = "/test-mvc", method = RequestMethod.POST)
    public ModelAndView submitTestPage(@ModelAttribute TestPersonDto person) {
        Locale.setDefault(Locale.US);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        String res = "Failed";
        try{
            tx = session.beginTransaction();
            User user = new User(person.getName(), person.getName(), person.getSurname(), 2);
            session.save(user);
            tx.commit();
            res = "New user created successfully!";
        }catch(HibernateException e){
            res = "Failed with exception";
            if(tx!=null)    tx.rollback();
            throw new RuntimeException(e);
        }finally{
            session.close();
            sessionFactory.close();
        }
        
        person.setName(res);
        ModelAndView modelAndView = new ModelAndView("testPageJsp");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
