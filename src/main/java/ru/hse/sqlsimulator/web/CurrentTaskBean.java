package ru.hse.sqlsimulator.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.web.converter.StudentTaskConverter;
import ru.hse.sqlsimulator.web.dto.StudentTaskDto;

import javax.annotation.PostConstruct;

/**
 * Created by Anna on 10/12/2015.
 */
@Component
public class CurrentTaskBean {

    @Autowired
    StudentTaskConverter taskConverter;

    private StudentTaskDto currentTask;

    @PostConstruct
    public void init() {
        currentTask = new StudentTaskDto();
        currentTask.setDescription("Initial task");
    }

    public StudentTaskDto getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(StudentTask studentTask) {
        StudentTaskDto taskDTO = taskConverter.toDto(studentTask);
        this.currentTask = taskDTO;
    }

    public void setCurrentTask(StudentTaskDto studentTaskDTO) {
        this.currentTask = studentTaskDTO;
    }
}
