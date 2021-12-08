/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.servicelayer;

import cardealership.TestApplicationConfiguration;
import cardealership.dao.DaoContactImpl;
import cardealership.dao.DaoMakeImpl;
import cardealership.dao.DaoModelImpl;
import cardealership.dao.DaoSalesImpl;
import cardealership.dao.DaoSpecialsImpl;
import cardealership.dao.DaoUsersImpl;
import cardealership.dao.DaoVehicleImpl;
import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Sale;
import cardealership.dto.Special;
import cardealership.dto.User;
import cardealership.dto.Vehicle;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Joshua Martel
 */
//@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class ServiceLayerImplTest {
    
    @Autowired
    JdbcTemplate jdbc;
    
    @Autowired
    private DaoContactImpl daoContact;
    @Autowired
    private DaoMakeImpl  daoMake;
    @Autowired
    private DaoModelImpl  daoModel;
    @Autowired
    private DaoSalesImpl  daoSales;
    @Autowired
    private DaoSpecialsImpl  daoSpecials;
    @Autowired
    private DaoUsersImpl  daoUsers;
    @Autowired
    private DaoVehicleImpl  daoVehicle;
    
    @Autowired

    private ServiceLayerImpl service;
    
    
    public ServiceLayerImplTest() {
        
    }

    @BeforeEach
    public void setUp(){
        List<Sale> sales = daoSales.getAllSales();
        for (Sale sale: sales) {
            daoSales.deleteSaleById(sale.getSaleID());
        }
        
        List<User> users = daoUsers.getAllUsers();
        for (User user: users) {
            daoUsers.deleteUserById(user.getUserID());
        }
        List<Vehicle> vehicles = daoVehicle.getAllVehicles();
        for (Vehicle vehicle: vehicles) {
            daoVehicle.removeVehicle(vehicle.getVehicleID());
        }
        List<Model> models = daoModel.getAllModels();
        for(Model model : models) {
            daoModel.removeModel(model.getModelID());
        }

        List<Make> makes = daoMake.getAllMakes();
        for(Make make : makes) {
            daoMake.removeMake(make.getMakeID());
        }
        
        Make make = service.addMake(new Make(1,"Honda"));
        
        Model model = service.addModel(new Model(make.getMakeID(),"Fit",make.getMakeID()));
        Special sp = service.addSpecial(new Special(1, null,null, "none"));
        
        service.addVehicle(new Vehicle(1, model.getModelID(), "New", "Car", 2021, "Rouge", 300, "12DGS543F",
			"15000","14000", "new Honda car","Sold", sp.getSpecialID(), "automatic"));
        service.addVehicle(new Vehicle(1 , model.getModelID(), "new", "truck", 1999, "blue", 643456, "12DGS543F",
			"5000","10000", "used Honda car","in stock", sp.getSpecialID(), "semi-auto"));
        service.addVehicle(new Vehicle(1 , model.getModelID(), "used", "mini-van", 2008, "silver", 15450, "12DGS543F",
			"5000","4000", "used Windstar mini-van","in stock", sp.getSpecialID(), "automatic"));

        User user = new User(1, "Emperor Palpatine", "Evil", "supreme.ruler", "IAmTheSenate", "disabled");
        service.addUser(user);
        
    }
    
        

    /**
     * Test of getSalesInRange method, of class ServiceLayerImpl.
     */
    
//    public Sale(int saleID, String email, String phone, 
//            String street, int zipCode, 
//            String purchasePrice, String purchaseType, 
//            int userID, int vehicleID, LocalDate saleDate) {
//        this.saleID = saleID;
//        this.email = email;
//        this.phone = phone;
//        this.street = street;
//        this.zipCode = zipCode;
//        this.purchasePrice = purchasePrice;
//        this.purchaseType = purchaseType;
//        this.userID = userID;
//        this.vehicleID = vehicleID;
//        this.saleDate = saleDate;
//    }
    @Test
    public void testGetSalesInRange() {
        //createa dates for test
        LocalDate march = LocalDate.of(2000, Month.MARCH, 1);
        LocalDate june =LocalDate.of(2000, Month.JUNE, 1);
        LocalDate july = LocalDate.of(2000, 07, 1);
        
        //create sales for test
        Sale sal1 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                march);
        Sale sal2 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                june);
        Sale sal3 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                july);
        
//        service.addSale(sal1);
//        service.addSale(sal2);
//        service.addSale(sal3);

        daoSales.addSale(sal1);
        daoSales.addSale(sal2);
        daoSales.addSale(sal3);
        
        List<Sale> fromDao = service.getSalesInRange(march,march);
        //Test getting a with a single date range
        assertEquals(1 ,fromDao.size() , "Size should be 1");
        assertTrue(fromDao.contains(sal1) );
        
        fromDao = service.getSalesInRange(march,june);
        
        //test with a range containing the centre and first element
        assertEquals(2 ,fromDao.size() , "Size should be 2");
        assertTrue(fromDao.contains(sal1) );
        assertTrue(fromDao.contains(sal2) );
        
        fromDao = service.getSalesInRange(march,july);
        
        //test with a full range
        assertEquals(3 ,fromDao.size() , "Size should be 3");
        assertTrue(fromDao.contains(sal1) );
        assertTrue(fromDao.contains(sal2) );
        assertTrue(fromDao.contains(sal3) );
        
        fromDao = service.getSalesInRange(june,july);
        
        //test with a range containing the centre and last element
        assertEquals(2 ,fromDao.size() , "Size should be 2");
        assertTrue(fromDao.contains(sal3) );
        assertTrue(fromDao.contains(sal2) );
    }

    /**
     * Test of getSalesInRangeAndUser method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetSalesInRangeAndUser() {
        //createa dates for test
        LocalDate march = LocalDate.of(2000, Month.MARCH, 1);
        LocalDate june =LocalDate.of(2000, Month.JUNE, 1);
        LocalDate july = LocalDate.of(2000, 07, 1);
        
        //create sales for test
        Sale sal1 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                march);
        Sale sal2 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                june);
        Sale sal3 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                july);
        
        daoSales.addSale(sal1);
        daoSales.addSale(sal2);
        daoSales.addSale(sal3);
        
        User user = service.getUser(1);
        User userFake = new User(2,"sir-fizzle-jam", "jazz jam", "nota realuser","icanconfirmthat","imposter");
        service.addUser(userFake);
        
        List<Sale> fromDao = service.getSalesInRangeAndUser(march,march,user.getUserID());
        //Test getting a with a single date range
        assertEquals(1 ,fromDao.size() , "Size should be 1");
        assertTrue(fromDao.contains(sal1) );
        
        fromDao = service.getSalesInRangeAndUser(march,june,user.getUserID());
        
        //test with a range containing the centre and first element
        assertEquals(2 ,fromDao.size() , "Size should be 2");
        assertTrue(fromDao.contains(sal1) );
        assertTrue(fromDao.contains(sal2) );
        
        fromDao = service.getSalesInRangeAndUser(march,july,user.getUserID());
        
        //test with a full range
        assertEquals(3 ,fromDao.size() , "Size should be 3");
        assertTrue(fromDao.contains(sal1) );
        assertTrue(fromDao.contains(sal2) );
        assertTrue(fromDao.contains(sal3) );
        
        fromDao = service.getSalesInRangeAndUser(june,july,user.getUserID());
        
        //test with a range containing the centre and last element
        assertEquals(2 ,fromDao.size() , "Size should be 2");
        assertTrue(fromDao.contains(sal3) );
        assertTrue(fromDao.contains(sal2) );
        
        //compare with user who has not made any sales
        fromDao = service.getSalesInRangeAndUser(june,july,userFake.getUserID());
        assertEquals(0 ,fromDao.size() , "Size should be 0 since no sales from user");
    }

    /**
     * Test of getSalesInByUser method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetSalesInByUser() {
        //Setup users
        User user = service.getUser(1);
        User userFake = new User(2,"sir-fizzle-jam", "jazz jam", "nota realuser","icanconfirmthat","imposter");
        service.addUser(userFake);
        
        //test case with no sales
        List<Sale> fromDao = service.getSalesInByUser(userFake.getUserID());
        assertEquals(0 ,fromDao.size() , "Size should be 0 since no sales were added");
        
          //createa dates for test
        LocalDate march = LocalDate.of(2000, Month.MARCH, 1);
        LocalDate june =LocalDate.of(2000, Month.JUNE, 1);
        LocalDate july = LocalDate.of(2000, 07, 1);
        
        //create sales for test
        Sale sal1 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                march);
        Sale sal2 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                june);
        Sale sal3 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                july);
        
        daoSales.addSale(sal1);
        daoSales.addSale(sal2);
        daoSales.addSale(sal3);
        //test with added sales but wrong user
        fromDao = service.getSalesInByUser(userFake.getUserID());
        assertEquals(0 ,fromDao.size() , "Size should be 0 since no sales were added by user");
        
         fromDao = service.getSalesInByUser(user.getUserID());
        //now test with a user who added sales
        assertEquals(3 ,fromDao.size() , "Size should be 3");
        assertTrue(fromDao.contains(sal3) );
        assertTrue(fromDao.contains(sal2) );
        assertTrue(fromDao.contains(sal1) );
    }

    /**
     * Test of totalNumberOfSales method, of class ServiceLayerImpl.
     */
    @Test
    public void testTotalOfSales() {
        //createa dates for test
        LocalDate march = LocalDate.of(2000, Month.MARCH, 1);
        LocalDate june =LocalDate.of(2000, Month.JUNE, 1);
        LocalDate july = LocalDate.of(2000, 07, 1);
        
        //create sales for test
        Sale sal1 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                march);
        Sale sal2 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                june);
        Sale sal3 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                july);
        
        daoSales.addSale(sal1);
        daoSales.addSale(sal2);
        daoSales.addSale(sal3);
        
        List<Sale> sales = service.getAllSales();
        
        assertEquals(3 ,sales.size() , "Size should be 3");
        
        BigDecimal total = service.totalOfSales(sales);
        
        assertEquals(3600.0 ,total.doubleValue(), "3 sales were conducted");
    }
 

    /**
     * Test of checkIfValidPurchasePrice method, of class ServiceLayerImpl.
     */
    @Test
    public void testCheckIfValidPurchasePrice() {
        //createa dates for test
        LocalDate march = LocalDate.of(2000, Month.MARCH, 1);
        
        //create sales for test
        Sale sal1 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                march);
        
        //sale purchase price is less than 14000
        assertFalse(service.validPurchasePrice(sal1));
        
        //create sales for test
        Sale sal2 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"14000","Cash", 1, 1, 
                march);
        
        //sale is valid
        assertTrue(service.validPurchasePrice(sal2));
        
        //create sales for test with purchase price greater than MSRP
        Sale sal3 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"17000","Cash", 1, 1, 
                march);
        
        assertFalse(service.validPurchasePrice(sal3),"should be false: msrp < pPrice");
    }

    /**
     * Test of validZip method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidZip() {
        //createa dates for test
        LocalDate march = LocalDate.of(2000, Month.MARCH, 1);
        LocalDate june =LocalDate.of(2000, Month.JUNE, 1);
        LocalDate july = LocalDate.of(2000, 07, 1);
        
        //create sales for test
        //valid zip
        Sale sal1 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                march);
        //invalid zip
        Sale sal2 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11,"1200","Cash", 1, 1, 
                june);
        //invalid zip
        Sale sal3 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",1111122,"1200","Cash", 1, 1, 
                july);
        
        daoSales.addSale(sal1);
        daoSales.addSale(sal2);
        daoSales.addSale(sal3);
        
        assertTrue(service.validZip(sal1));
        assertFalse(service.validZip(sal2));
        assertFalse(service.validZip(sal3));
    }

    /**
     * Test of validYear method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidYear() {
        //valid year
        Vehicle valid = service.getVehicle(1);
        //invalid year
        Vehicle invalid = service.getVehicle(2);
        
        assertTrue(service.validYear(valid));
        assertFalse(service.validYear(invalid));
    }

    /**
     * Test of validTransmission method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidTransmission() {
        //valid transmission
        Vehicle valid = service.getVehicle(1);
        //invalid transmission
        Vehicle invalid = service.getVehicle(2);
        
        assertTrue(service.validTransmission(valid));
        assertFalse(service.validTransmission(invalid));
    }

    /**
     * Test of validNewVehicle method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidNewVehicle() {
        //valid new vehicle
        Vehicle valid = service.getVehicle(1);
        //invalid new vehicle
        Vehicle invalid = service.getVehicle(2);
        
        assertTrue(service.validNewVehicle(valid));
        assertFalse(service.validNewVehicle(invalid));
    }

    /**
     * Test of validSalePrice method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidSalePrice() {
        //valid sale price
        Vehicle valid = service.getVehicle(1);
        //invalid sale price
        Vehicle invalid = service.getVehicle(2);
        
        assertTrue(service.validSalePrice(valid));
        assertFalse(service.validSalePrice(invalid));
    }

    /**
     * Test of validEmail method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidEmail() {
        //valid email
        String validEmail = "jpmartel@gmail.com";
        //invalid email
        String invalidEmail = "123^^.hga";
        
        assertTrue(service.validEmail(validEmail));
        assertFalse(service.validEmail(invalidEmail));
        
    }

    /**
     * Test of validPurchaseType method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidPurchaseType() {
        //createa dates for test
        LocalDate march = LocalDate.of(2000, Month.MARCH, 1);
        LocalDate june =LocalDate.of(2000, Month.JUNE, 1);
        LocalDate july = LocalDate.of(2000, 07, 1);
        
        //create sales for test
        //valid type
        Sale sal1 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","Cash", 1, 1, 
                march);
        //valid type
        Sale sal2 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","nothing", 1, 1, 
                june);
        //valid type
        Sale sal3 = new Sale(1,"jpm@gmail.com", "123-456-7890",
                "street",11111,"1200","loan", 1, 1, 
                july);
       
        
        assertTrue(service.validPurchaseType(sal1));
        assertFalse(service.validPurchaseType(sal2));
        assertFalse(service.validPurchaseType(sal3));
    }

    /**
     * Test of validVehicleForSale method, of class ServiceLayerImpl.
     */
    @Test
    public void testValidVehicleForSale() {
        
        //valid sale price
        Vehicle valid = service.getVehicle(2);
        //invalid sale price
        Vehicle invalid = service.getVehicle(1);
        
        assertTrue(service.validVehicleForSale(valid.getVehicleID()));
        assertFalse(service.validVehicleForSale(invalid.getVehicleID()));
    }

    /**
     * Test of getInventoryIndex method, of class ServiceLayerImpl.
     */
    @Test
    public void testGetInventoryIndex() {
        //should get used and new cars
        List<Vehicle> sold = service.getInventoryIndex();
        
        //get vehicles in database
        Vehicle v1 = service.getVehicle(1);
        Vehicle v2 = service.getVehicle(2);
        Vehicle v3 = service.getVehicle(3);
        
        assertEquals(2, sold.size());
        //should not contain 1
        assertTrue(!sold.contains(v1));
        
        assertTrue(sold.contains(v2));
        assertTrue(sold.contains(v3));
        
    }
    
}
