package ru.hse.sqlsimulator.model;

import java.sql.Date;

/**
 * Created by Anna on 10/12/2015.
 */
public class UserTask {

    private int id;
    private int userId;
    private int taskId;
    private boolean isDraft;
    private boolean isCorrect;
    private String answer;
    private Date answerDate;
    
    
    public UserTask(){}

    public UserTask(int userID, int taskID){
        this.userId = userID;
        this.taskId = taskID;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getTaskId(){
        return taskId;
    }

    public void setTaskId(int taskId){
        this.taskId = taskId;
    }

    public boolean isIsDraft(){
        return isDraft;
    }

    public void setIsDraft(boolean isDraft){
        this.isDraft = isDraft;
    }

    public boolean isIsCorrect(){
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect){
        this.isCorrect = isCorrect;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public Date getAnswerDate(){
        return answerDate;
    }

    public void setAnswerDate(Date answerDate){
        this.answerDate = answerDate;
    }
   
}
