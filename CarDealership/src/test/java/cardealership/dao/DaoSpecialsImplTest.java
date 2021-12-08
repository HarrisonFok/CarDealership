/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cardealership.dao;

import cardealership.TestApplicationConfiguration;
import cardealership.dto.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
 * @author noel
 */
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoSpecialsImplTest {
    
    @Autowired
    DaoSpecialsImpl dao;
    
    @Autowired
    DaoSalesImpl salesDao;
    
    @Autowired
    DaoUsersImpl userDao;
    
    @Autowired
    DaoVehicleImpl daoVehicle;
    
    @Autowired
    DaoModelImpl modelDao;
    
    @Autowired
    DaoMakeImpl makeDao;

    @Autowired
    DaoContact contactDao;
    
    public DaoSpecialsImplTest() {
    }
    

    @BeforeEach
    public void setUp() {
        List<Sale> sales = salesDao.getAllSales();
        for (Sale sale: sales) {
            salesDao.removeSale(sale.getSaleID());
        }
        List<Contact> contacts = contactDao.getAllContacts();
        for(Contact contact : contacts) {
            contactDao.removeContact(contact.getContactID());
        }

        List<Vehicle> vehicles = daoVehicle.getAllVehicles();
        for (Vehicle vehicle: vehicles) {
            daoVehicle.removeVehicle(vehicle.getVehicleID());
        }
        
        List<User> users = userDao.getAllUsers();
        for (User user: users) {
            userDao.removeUser(user.getUserID());
        }
        
        List<Model> models = modelDao.getAllModels();
        for(Model model : models) {
            modelDao.removeModel(model.getModelID());
        }

        List<Make> makes = makeDao.getAllMakes();
        for(Make make : makes) {
            makeDao.removeMake(make.getMakeID());
        }
        List<Special> specials = dao.getAllSpecials();
        for (Special special: specials) {
            dao.removeSpecial(special.getSpecialID());
        }
    }
    

    /**
     * Test of addSpecial method, of class DaoSpecialsImpl.
     */
    @Test
    public void testAddSpecial() {
     
        Special special = new Special();
        List<Special> specials = dao.getAllSpecials();
        assertEquals(0, specials.size());
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,12,21);
        Calendar CTwo = new GregorianCalendar(2021,12,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setEndDate(DD);
        special.setEndDate(DDTwo);
        assertEquals(0, specials.size());
    }

    /**
     * Test of removeSpecial method, of class DaoSpecialsImpl.
     */
    @Test
    public void testRemoveSpecial() {
         Special special = new Special();
        List<Special> specials = dao.getAllSpecials();
        assertEquals(0, specials.size());
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,12,21);
        Calendar CTwo = new GregorianCalendar(2021,12,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setEndDate(DD);
        special.setEndDate(DDTwo);
        int specialID = special.getSpecialID();
        dao.removeSpecial(specialID);
        specials = dao.getAllSpecials();
        assertEquals(0, specials.size());   
    }
    
}
