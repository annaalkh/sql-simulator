package ru.hse.sqlsimulator.web.dto;

import org.springframework.stereotype.Component;
import ru.hse.sqlsimulator.web.dto.StudentTaskDTO;

import javax.annotation.PostConstruct;

/**
 * Created by Anna on 10/12/2015.
 */
@Component
public class UserDTO {

    private int id;
    private String login;
    private String name;
    private String lastname;
    private int role;
    
    public UserDTO(){}

    public UserDTO(String login, String name, String lastname, int role){
        this.login = login;
        this.name = name;
        this.lastname = lastname;
        this.role = role;
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public int getRole(){
        return role;
    }

    public void setRole(int role){
        this.role = role;
    }
}
