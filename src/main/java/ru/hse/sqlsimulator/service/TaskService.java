package ru.hse.sqlsimulator.service;

import ru.hse.sqlsimulator.model.StudentTask;

import java.util.List;

/**
 * Created by Anna on 11/4/2015.
 */
public interface TaskService {

    public StudentTask getActiveTaskForLecture();

    public StudentTask setActiveTaskForLecture(StudentTask studentTask);
    public StudentTask setActiveTaskForLecture(Integer taskId);

    public void saveTask(StudentTask task);

    public List<StudentTask> getAllTasksForLesson();
}
