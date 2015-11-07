package ru.hse.sqlsimulator.model;

import java.util.Date;
import java.util.Random;

/**
 * Created by Anna on 11/4/2015.
 */
public class StudentTask {

    private int id;
    private String taskText;
    private String name;
    private String description;
    private Boolean isActive;
    private Boolean isPlanned;
    private Date startDate;
    private Date endDate;
    private Date actDate;

    //temp
    public static StudentTask get(String name, String taskText) {
        StudentTask task = new StudentTask();
        task.setId(new Random().nextInt());
        task.setName(name);
        task.setDescription(taskText);
        return task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getPlanned() {
        return isPlanned;
    }

    public void setPlanned(Boolean planned) {
        isPlanned = planned;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getActDate() {
        return actDate;
    }

    public void setActDate(Date actDate) {
        this.actDate = actDate;
    }
}
