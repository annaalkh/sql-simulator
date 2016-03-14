package ru.hse.sqlsimulator.service;

import java.sql.Date;

import org.springframework.transaction.annotation.Transactional;
import ru.hse.sqlsimulator.model.StudentTask;

import java.util.List;

/**
 * Created by Anna on 11/4/2015.
 */
public interface TaskService {
    /**
     * Find a task for id
     * @param id taskID to find for
     * @return requested StudentTask
     */
    @Transactional
    StudentTask getTaskByID(int id);

    /**
     * Get task with is_active flag
     * @return active StudentTask
     */
    @Transactional
    StudentTask getActiveTaskForLecture();

    /**
     * Set flag is_active on student task
     * @param studentTask task to set flag on
     * @return updated StudentTask with set flag
     */
    @Transactional
    StudentTask setActiveTaskForLecture(StudentTask studentTask);

    /**
     * Set flag is_active on student task
     * @param taskId taskID to set flag on
     * @return updated StudentTask with set flag
     */
    @Transactional
    StudentTask setActiveTaskForLecture(Integer taskId);

    /**
     * Save task to DB
     * @param task task to save
     */
    @Transactional
    void saveTask(StudentTask task);

    /**
     * Returns list of tasks for specified task
     * @param date necessary date of tasks
     * @return List of tasks
     */
    @Transactional
    List<StudentTask> getAllTasksForLesson(Date date);

    /**
     * @return all existing tasks
     */
    @Transactional
    List<StudentTask> getAllTasks();
}
