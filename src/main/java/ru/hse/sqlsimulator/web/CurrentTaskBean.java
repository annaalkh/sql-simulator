package ru.hse.sqlsimulator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.web.converter.StudentTaskConverter;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;

import javax.annotation.PostConstruct;

/**
 * Created by Anna on 10/12/2015.
 */
@Component
public class CurrentTaskBean {

    @Autowired
    StudentTaskConverter taskConverter;

    private StudentTaskDTO currentTask;

    @PostConstruct
    public void init() {
        currentTask = new StudentTaskDTO();
        currentTask.setDescription("Initial task");
    }

    public StudentTaskDTO getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(StudentTask studentTask) {
        StudentTaskDTO taskDTO = taskConverter.toDto(studentTask);
        this.currentTask = taskDTO;
    }

    public void setCurrentTask(StudentTaskDTO studentTaskDTO) {
        this.currentTask = studentTaskDTO;
    }
}
