package ru.hse.sqlsimulator.web.dto;

import java.util.Date;
import java.util.Random;

/**
 * Created by Anna on 10/11/2015.
 */
public class StudentTaskDTO {

    private int id;
//    private String taskText;
    private String name;
    private String description;
    private Boolean isActive;
    private Boolean isPlanned;
    private Date startDate;
    private Date endDate;
    private Date actDate;
    private String correctAnswer;

    public StudentTaskDTO() {

    }

    public StudentTaskDTO(String name, String description, Boolean isActive) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
    }

    public static StudentTaskDTO taskForPair(String taskText) {
        StudentTaskDTO dto = new StudentTaskDTO("", taskText, true);
        dto.setId(new Random().nextInt());
        return dto;
    }

//    public String getTaskText() {
//        return taskText;
//    }
//
//    public void setTaskText(String taskText) {
//        this.taskText = taskText;
//    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
