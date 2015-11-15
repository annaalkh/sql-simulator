package ru.hse.sqlsimulator.web.rest;

import java.sql.Date;
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
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import ru.hse.sqlsimulator.model.User;
import ru.hse.sqlsimulator.service.UserService;

/**
 * Created by Anna on 11/5/2015.
 */
@RestController
public class TeacherController {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private UserService userService;

    @Autowired
    StudentTaskConverter taskConverter;

    @Autowired
    private CurrentTaskBean currentTaskBean;

    @RequestMapping(value = "/teacher/get-tasks", method = RequestMethod.GET)
    public List<StudentTaskDTO> getAllTasksForLesson() {
        System.out.println("Get all tasks for lesson" );
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 9, 20, 0, 0, 0);
        List<StudentTask> taskList = taskService.getAllTasks();
        List<StudentTaskDTO> taskDTOs = null;
        if(taskList != null && !taskList.isEmpty()){
            taskDTOs = taskList.stream().map(taskConverter::toDto).collect(Collectors.toList());
        }
        taskService.setActiveTaskForLecture(8);
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
    
    @RequestMapping(value = "/teacher/all-students", method = RequestMethod.GET)
    public List<User> getAllStudents() {
        List<User> userList = userService.getAllUsersWithRole(2);
        return userList;
    }
    
    @RequestMapping(value = "/teacher/get-with-2", method = RequestMethod.GET)
    public User getStudentWithID2() {
        User user = userService.getUserByID(2);
        return user;
    }
}
