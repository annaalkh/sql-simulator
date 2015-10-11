package ru.hse.sqlsimulator.web;

import org.springframework.stereotype.Component;
import ru.hse.sqlsimulator.web.dto.StudentTaskDto;

import javax.annotation.PostConstruct;

/**
 * Created by Anna on 10/12/2015.
 */
@Component
public class CurrentTaskBean {

    private StudentTaskDto currentTask;

    @PostConstruct
    public void init() {
        currentTask = new StudentTaskDto();
        currentTask.setTaskText("Initial task");
    }

    public StudentTaskDto getCurrentTask() {
        return currentTask;
    }
}
