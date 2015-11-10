package ru.hse.sqlsimulator.service;

import java.util.List;
import ru.hse.sqlsimulator.model.User;


/**
 * Created by Anna on 11/4/2015.
 */
public interface UserService {
    /*Get user*/
    public User getUserByID(int id);
    public List<User> getAllUsers();
    public List<User> getAllUsersWithRole(int role);
    
    
}
