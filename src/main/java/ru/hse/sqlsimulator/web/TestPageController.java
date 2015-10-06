package ru.hse.sqlsimulator.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Anna on 10/4/2015.
 */
@Controller
public class TestPageController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/student")
    public String studentPage() {
        return "studentView";
    }

    @RequestMapping("/teacher")
    public String teacherPage() {
        return "teacherView";
    }

}
