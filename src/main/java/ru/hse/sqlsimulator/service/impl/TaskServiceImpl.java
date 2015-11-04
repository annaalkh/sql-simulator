package ru.hse.sqlsimulator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.hse.sqlsimulator.model.StudentTask;
import ru.hse.sqlsimulator.service.TaskService;
import ru.hse.sqlsimulator.web.CurrentTaskBean;

/**
 * Created by Anna on 11/4/2015.
 */
public class TaskServiceImpl implements TaskService {

    @Autowired
    CurrentTaskBean currentTaskBean;

    public StudentTask getActiveTaskForLecture() {
        //получиьт из бд
        return new StudentTask();
    }

    public void setActiveTaskForLecture(StudentTask studentTask) {
        //вся работа с базой данных
        currentTaskBean.setCurrentTask(studentTask);
    }
}
