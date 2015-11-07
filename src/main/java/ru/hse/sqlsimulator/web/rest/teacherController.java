package ru.hse.sqlsimulator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.service.TaskService;
import ru.hse.sqlsimulator.web.CurrentTaskBean;
import ru.hse.sqlsimulator.web.converter.StudentTaskConverter;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Anna on 11/5/2015.
 */
@RestController
public class TeacherController {

    @Autowired
    private TaskService taskService;

    @Autowired
    StudentTaskConverter taskConverter;

    @Autowired
    private CurrentTaskBean currentTaskBean;

    @RequestMapping(value = "/teacher/get-tasks-for-lesson", method = RequestMethod.GET)
    public List<StudentTaskDTO> getAllTasksForLesson() {
        System.out.println("Get all tasks for lesson" );
        List<StudentTask> taskList = taskService.getAllTasksForLesson();
        List<StudentTaskDTO> taskDTOs = taskList.stream().map(taskConverter::toDto).collect(Collectors.toList());
        return taskDTOs;
    }

    @RequestMapping(value = "/teacher/publish-task", method = RequestMethod.POST)
    public void publishCurrentTask(@RequestBody Integer taskId) {
        System.out.println("Publish task with id : " + taskId);
        taskService.setActiveTaskForLecture(taskId);
//        StudentTaskDTO taskDTO = StudentTaskDTO.taskForPair(taskText);
//        currentTaskBean.setCurrentTask(taskDTO);
    }

    @RequestMapping(value = "/teacher/complete-task", method = RequestMethod.POST)
    public void completeCurrentTask(@RequestBody String correntAnswer) {
        System.out.println("Task completed. Correct answer: " + correntAnswer);
        StudentTaskDTO taskDTO = currentTaskBean.getCurrentTask();
        taskDTO.setCorrectAnswer(correntAnswer);
    }
}
