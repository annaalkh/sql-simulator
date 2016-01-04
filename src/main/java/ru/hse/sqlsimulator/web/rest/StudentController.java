package ru.hse.sqlsimulator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hse.sqlsimulator.web.CurrentTaskBean;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;

/**
 * Created by Anna on 10/12/2015.
 */
@RestController
public class StudentController {

    @Autowired
    private CurrentTaskBean currentTaskBean;

    @RequestMapping("/student/current-task")
    public StudentTaskDTO getCurrentTask() {
        StudentTaskDTO task = currentTaskBean.getCurrentTask();
        return task;
    }

    @RequestMapping(value = "/student/run-query", method = RequestMethod.POST)
    public Object runQuery(@RequestBody String query) {
        System.out.println("Query: " + query);
        return query;
    }

    @RequestMapping(value = "/student/check-task", method = RequestMethod.POST)
    public Object checkTask(@RequestBody String query) {
        System.out.println("Query: " + query);
        return query;
    }
}
