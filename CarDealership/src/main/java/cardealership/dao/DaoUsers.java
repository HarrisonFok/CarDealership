/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.dao;

import cardealership.dto.User;
import java.util.List;

/**
 *
 * @author Joshua Martel
 */
public interface DaoUsers {
    
    public User addUser(User newUser);
    
    public boolean updateUser (User user);
    
    public boolean updateUserPassword(User user);
    
    public User getUser(int userId);
    
    public List<User> getAllUsers();
    
}
