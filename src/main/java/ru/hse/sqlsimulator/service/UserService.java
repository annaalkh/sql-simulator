package ru.hse.sqlsimulator.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import ru.hse.sqlsimulator.model.User;


/**
 * Created by Anna on 11/4/2015.
 */
public interface UserService {
    /**
     * Returns user with specified id
     * @param id UserID to find for
     * @return requested User
     */
    @Transactional
    User getUserByID(int id);

    /**
     * Returns list of all users
     * @return list of all users
     */
    @Transactional
    List<User> getAllUsers();

    /**
     * Returns all users with specified role
     * @param role
     * @return list of Users
     */
    @Transactional
    List<User> getAllUsersWithRole(int role);

    /**
     * @param query query to execute
     * @return result of execution
     */
    @Transactional
    List<Map<String, Object>> executeUserQuery(String query);
}
