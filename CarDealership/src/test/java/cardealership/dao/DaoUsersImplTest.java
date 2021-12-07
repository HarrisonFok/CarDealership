/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cardealership.dao;

import cardealership.TestApplicationConfiguration;
import cardealership.dto.User;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author harrisonfok
 */
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoUsersImplTest {
    
    @Autowired
    DaoUsers daoUsers;
    
    public DaoUsersImplTest() {
    }
    
    @BeforeEach
    public void setUp() {
        List<User> users = daoUsers.getAllUsers();
        for (User user: users) {
            daoUsers.removeUser(user.getUserID());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class DaoUsersImpl.
     */
    @Test
    public void testAddGetUser() {
        System.out.println("addUser");
        User newUser = new User();
        newUser.setFirstName("Bob");
        newUser.setLastName("Zuckerberg");
        newUser.setUserName("zucker");
        newUser.setUserPassword("iambob");
        newUser.setUserRole("Admin");
        User fromDao = daoUsers.addUser(newUser);
        assertEquals(newUser, fromDao);
    }

    /**
     * Test of updateUser method, of class DaoUsersImpl.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser");
        User user = new User();
        user.setFirstName("Bob");
        user.setLastName("Zuckerberg");
        user.setUserName("zucker");
        user.setUserPassword("iambob");
        user.setUserRole("Admin");
        user = daoUsers.addUser(user);
        
        User fromDao = daoUsers.getUser(user.getUserID());
        
        assertEquals(user, fromDao);
        
        user.setFirstName("Alice");
        daoUsers.updateUser(user);
        
        assertNotEquals(user, fromDao);
        
        fromDao = daoUsers.getUser(user.getUserID());

        assertEquals(user, fromDao);
    }

    /**
     * Test of updateUserPassword method, of class DaoUsersImpl.
     */
    @Test
    public void testUpdateUserPassword() {
        System.out.println("updateUserPassword");
        String updatedPassword = "iamnotbob";
        User user = new User();
        user.setUserID(1);
        user.setFirstName("Bob");
        user.setLastName("Zuckerberg");
        user.setUserName("zucker");
        user.setUserPassword("iambob");
        user.setUserRole("Admin");
        daoUsers.addUser(user);
        user.setUserPassword(updatedPassword);
        daoUsers.updateUserPassword(user);
        assertEquals(user.getUserPassword(), updatedPassword);
    }

    /**
     * Test of getAllUsers method, of class DaoUsersImpl.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        User user1 = new User();
        user1.setUserID(1);
        user1.setFirstName("Bob");
        user1.setLastName("Zuckerberg");
        user1.setUserName("zucker");
        user1.setUserPassword("iambob");
        user1.setUserRole("Admin");
        daoUsers.addUser(user1);
        User user2 = new User();
        user2.setUserID(2);
        user2.setFirstName("Bob");
        user2.setLastName("Zuckerberg");
        user2.setUserName("zucker");
        user2.setUserPassword("iambob");
        user2.setUserRole("Admin");
        daoUsers.addUser(user2);
        User user3 = new User();
        user3.setUserID(3);
        user3.setFirstName("Bob");
        user3.setLastName("Zuckerberg");
        user3.setUserName("zucker");
        user3.setUserPassword("iambob");
        user3.setUserRole("Admin");
        List<User> fromDao = daoUsers.getAllUsers();
        assertEquals(2, fromDao.size());
        assertTrue(fromDao.contains(user1));
        assertTrue(fromDao.contains(user2));
        assertFalse(fromDao.contains(user3));
    }
    
}
