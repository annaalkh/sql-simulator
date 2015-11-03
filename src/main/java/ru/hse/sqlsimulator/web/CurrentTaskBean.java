package ru.hse.sqlsimulator.web;

import org.springframework.stereotype.Component;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;

import javax.annotation.PostConstruct;

/**
 * Created by Anna on 10/12/2015.
 */
@Component
public class CurrentTaskBean {

    private StudentTaskDTO currentTask;

    @PostConstruct
    public void init() {
        currentTask = new StudentTaskDTO();
        currentTask.setDescription("Initial task");
    }

    public StudentTaskDTO getCurrentTask() {
        return currentTask;
    }
}
