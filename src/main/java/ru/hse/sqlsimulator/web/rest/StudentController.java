package ru.hse.sqlsimulator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hse.sqlsimulator.web.CurrentTaskBean;
import ru.hse.sqlsimulator.web.dto.StudentTaskDto;

/**
 * Created by Anna on 10/12/2015.
 */
@RestController
public class StudentController {

    @Autowired
    private CurrentTaskBean currentTaskBean;

    @RequestMapping("/student/current-task")
    public StudentTaskDto getCurrentTask() {
        StudentTaskDto task = currentTaskBean.getCurrentTask();
        return task;
    }

    @RequestMapping(value = "/student/run-query", method = RequestMethod.POST)
    public Object runQuery(@RequestBody String query) {
        System.out.println("Query: " + query);
        return query;
    }
}
