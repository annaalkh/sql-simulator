package ru.hse.sqlsimulator.service;

import ru.hse.sqlsimulator.model.StudentTask;

/**
 * Created by Anna on 11/4/2015.
 */
public interface TaskService {

    public StudentTask getActiveTaskForLecture();

    public void setActiveTaskForLecture(StudentTask studentTask);

    public void saveTask(StudentTask task);
}
