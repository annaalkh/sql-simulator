package ru.hse.sqlsimulator.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.sqlsimulator.web.CurrentTaskBean;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;

/**
 * Created by Anna on 11/5/2015.
 */
@RestController
public class TeacherController {

    @Autowired
    private CurrentTaskBean currentTaskBean;

    @RequestMapping(value = "/teacher/publish-task", method = RequestMethod.POST)
    public void publishCurrentTask(@RequestBody String taskText) {
        System.out.println("Task published: " + taskText);
        StudentTaskDTO taskDTO = StudentTaskDTO.taskForPair(taskText);
        currentTaskBean.setCurrentTask(taskDTO);
    }

    @RequestMapping(value = "/teacher/complete-task", method = RequestMethod.POST)
    public void completeCurrentTask(@RequestBody String correntAnswer) {
        System.out.println("Task completed. Correct answer: " + correntAnswer);
        StudentTaskDTO taskDTO = currentTaskBean.getCurrentTask();
        taskDTO.setCorrectAnswer(correntAnswer);
    }
}
