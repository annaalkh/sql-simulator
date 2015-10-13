package ru.hse.sqlsimulator.web.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.hse.sqlsimulator.web.CurrentTaskBean;
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
        person.setName(person.getName() + "!!!");
        ModelAndView modelAndView = new ModelAndView("testPageJsp");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
