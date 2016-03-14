package ru.hse.sqlsimulator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.service.TaskService;
import ru.hse.sqlsimulator.web.converter.StudentTaskConverter;
import ru.hse.sqlsimulator.web.dto.StudentTaskDto;

/**
 * Created by Anna on 11/7/2015.
 */
@RestController
@RequestMapping(value = "/task-management")
public class TaskManagementController {

    @Autowired
    TaskService taskService;

    @Autowired
    StudentTaskConverter taskConverter;

    @RequestMapping(value = "/save-task", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveTaskForPair(@RequestBody StudentTaskDto taskDTO) {
        System.out.println("Task to save: " + taskDTO.getName());
        StudentTask task = taskConverter.toTaskForPair(taskDTO);
        taskService.saveTask(task);
    }
}
