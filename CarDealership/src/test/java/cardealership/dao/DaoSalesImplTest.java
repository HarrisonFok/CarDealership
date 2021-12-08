/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cardealership.dao;

import cardealership.TestApplicationConfiguration;
import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Sale;
import cardealership.dto.User;
import cardealership.dto.Vehicle;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author noel
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoSalesImplTest {
    
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
    
    
    public DaoSalesImplTest() {
    }
    

    @BeforeEach
    public void setUp() {
        
        List<Sale> sales = salesDao.getAllSales();
        for (Sale sale: sales) {
            salesDao.removeSale(sale.getSaleID());
        }
        
        List<User> users = userDao.getAllUsers();
        for (User user: users) {
            userDao.removeUser(user.getUserID());
        }
        List<Vehicle> vehicles = daoVehicle.getAllVehicles();
        for (Vehicle vehicle: vehicles) {
            daoVehicle.removeVehicle(vehicle.getVehicleID());
        }
        List<Model> models = modelDao.getAllModels();
        for(Model model : models) {
            modelDao.removeModel(model.getModelID());
        }

        List<Make> makes = makeDao.getAllMakes();
        for(Make make : makes) {
            makeDao.removeMake(make.getMakeID());
        }
    }
    
    

    /**
     * Test of addSale method, of class DaoSalesImpl.
     */
    @Test
    public void testAddSale() {
        User newUser = new User();
        newUser.setFirstName("Shawn");
        newUser.setLastName("Mendes");
        newUser.setUserName("Shawn");
        newUser.setUserPassword("password");
        newUser.setUserRole("Admin");
        userDao.addUser(newUser);
               
        Make make = new Make();
        make.setVehicleMake("test");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType("new");
        vehicle.setBodyStyle("car");
        vehicle.setVehicleYear(2021);
        vehicle.setTransmission("auto");
        vehicle.setColour("green");
        vehicle.setMileage(3000);
        vehicle.setVin("1269");
        vehicle.setMsrp("5000");
        vehicle.setSalesPrice("4000");
        vehicle.setVehicleDesc("test");
        vehicle.setSalesStatus("Sold");
        vehicle.setSpecialID(1);
        vehicle.setModelID(model.getModelID());
        vehicle = daoVehicle.addVehicle(vehicle);
        
        int vehicleID = vehicle.getVehicleID();
        
        Sale sale = new Sale();
        sale.setEmail("ROBERT@GMAIL.COM");
        sale.setPhone("343-554-5234");
        sale.setStreet("4 Sample lane");
        sale.setZipCode(33755);
        sale.setPurchasePrice("4000");
        sale.setPurchaseType("cash");
        sale.setUserID(newUser.getUserID());
        sale.setVehicleID(vehicleID);
        sale.setSaleDate(LocalDate.now());
        sale = salesDao.addSale(sale);
        int saleID = sale.getSaleID();
        List<Sale> sales = salesDao.getAllSales();
        assertEquals(1, sales.size());
        assertEquals(saleID, sale.getSaleID());
        
    }

    /**
     * Test of getAllSales method, of class DaoSalesImpl.
     */
    @Test
    public void testGetAllSales() {
        User newUser = new User();
        newUser.setFirstName("Shawn");
        newUser.setLastName("Mendes");
        newUser.setUserName("Shawn");
        newUser.setUserPassword("password");
        newUser.setUserRole("Admin");
        userDao.addUser(newUser);
               
        Make make = new Make();
        make.setVehicleMake("test");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType("new");
        vehicle.setBodyStyle("car");
        vehicle.setVehicleYear(2021);
        vehicle.setTransmission("auto");
        vehicle.setColour("green");
        vehicle.setMileage(3000);
        vehicle.setVin("1269");
        vehicle.setMsrp("5000");
        vehicle.setSalesPrice("4000");
        vehicle.setVehicleDesc("test");
        vehicle.setSalesStatus("Sold");
        vehicle.setSpecialID(1);
        vehicle.setModelID(model.getModelID());
        vehicle = daoVehicle.addVehicle(vehicle);
        
        int vehicleID = vehicle.getVehicleID();
        
        Sale sale = new Sale();
        sale.setEmail("ROBERT@GMAIL.COM");
        sale.setPhone("343-554-5234");
        sale.setStreet("4 Sample lane");
        sale.setZipCode(33755);
        sale.setPurchasePrice("4000");
        sale.setPurchaseType("cash");
        sale.setUserID(newUser.getUserID());
        sale.setVehicleID(vehicleID);
        sale.setSaleDate(LocalDate.now());
        sale = salesDao.addSale(sale);
        
        List<Sale> sales = salesDao.getAllSales();
        assertEquals(1, sales.size());
        
        Sale saleTwo = new Sale();
        saleTwo.setEmail("ROBERT@GMAIL.COM");
        saleTwo.setPhone("343-554-5234");
        saleTwo.setStreet("4 Sample lane");
        saleTwo.setZipCode(33755);
        saleTwo.setPurchasePrice("4000");
        saleTwo.setPurchaseType("cash");
        saleTwo.setUserID(newUser.getUserID());
        saleTwo.setVehicleID(vehicleID);
        saleTwo.setSaleDate(LocalDate.now());
        saleTwo = salesDao.addSale(sale);
        sales = salesDao.getAllSales();
        assertEquals(2, sales.size());
    }

    /**
     * Test of getSale method, of class DaoSalesImpl.
     */
    @Test
    public void testGetSale() {
        User newUser = new User();
        newUser.setFirstName("Shawn");
        newUser.setLastName("Mendes");
        newUser.setUserName("Shawn");
        newUser.setUserPassword("password");
        newUser.setUserRole("Admin");
        userDao.addUser(newUser);
               
        Make make = new Make();
        make.setVehicleMake("test");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType("new");
        vehicle.setBodyStyle("car");
        vehicle.setVehicleYear(2021);
        vehicle.setTransmission("auto");
        vehicle.setColour("green");
        vehicle.setMileage(3000);
        vehicle.setVin("1269");
        vehicle.setMsrp("5000");
        vehicle.setSalesPrice("4000");
        vehicle.setVehicleDesc("test");
        vehicle.setSalesStatus("Sold");
        vehicle.setSpecialID(1);
        vehicle.setModelID(model.getModelID());
        vehicle = daoVehicle.addVehicle(vehicle);
        
        int vehicleID = vehicle.getVehicleID();
        
        Sale sale = new Sale();
        sale.setEmail("ROBERT@GMAIL.COM");
        sale.setPhone("343-554-5234");
        sale.setStreet("4 Sample lane");
        sale.setZipCode(33755);
        sale.setPurchasePrice("4000");
        sale.setPurchaseType("cash");
        sale.setUserID(newUser.getUserID());
        sale.setVehicleID(vehicleID);
        sale.setSaleDate(LocalDate.now());
        sale = salesDao.addSale(sale);
        int saleID = sale.getSaleID();
        Sale fromDaoSale = new Sale();
        fromDaoSale = salesDao.getSale(saleID);
        assertEquals(fromDaoSale, sale);
    }
}
