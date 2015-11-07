package ru.hse.sqlsimulator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.service.TaskService;
import ru.hse.sqlsimulator.web.CurrentTaskBean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Anna on 11/4/2015.
 */
@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    CurrentTaskBean currentTaskBean;

    public StudentTask getActiveTaskForLecture() {
        //получиьт из бд
        return new StudentTask();
    }

    public StudentTask setActiveTaskForLecture(StudentTask studentTask) {
        //вся работа с базой данных
        currentTaskBean.setCurrentTask(studentTask);
        return studentTask;
    }

    @Override
    public StudentTask setActiveTaskForLecture(Integer taskId) {
        //get real task from db by id
        StudentTask task1 = StudentTask.get("First task", "Выберите всех студентов");
        currentTaskBean.setCurrentTask(task1);
        return task1;
    }

    public void saveTask(StudentTask task) {
        System.out.println("Service: task is saved, name: " + task.getName());
    }

    public List<StudentTask> getAllTasksForLesson() {
        StudentTask task1 = StudentTask.get("First task", "Выберите всех студентов");
        StudentTask task2 = StudentTask.get("Second task", "Main query");
        return Arrays.asList(task1, task2);
    }
}
