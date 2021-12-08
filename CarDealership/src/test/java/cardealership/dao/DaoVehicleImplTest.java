/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cardealership.dao;

import cardealership.TestApplicationConfiguration;
import cardealership.dto.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author harrisonfok
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoVehicleImplTest {
    
    @Autowired
    DaoVehicle daoVehicle;

    @Autowired
    DaoModel modelDao;

    @Autowired
    DaoMake makeDao;

    @Autowired
    DaoSpecials specialsDao;

    @Autowired
    DaoContact contactDao;

    @Autowired
    DaoSales salesDao;
    
    public DaoVehicleImplTest() {
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
        List<Model> models = modelDao.getAllModels();
        for(Model model : models) {
            modelDao.removeModel(model.getModelID());
        }

        List<Make> makes = makeDao.getAllMakes();
        for(Make make : makes) {
            makeDao.removeMake(make.getMakeID());
        }
        List<Special> specials = specialsDao.getAllSpecials();
        for (Special special: specials) {
            specialsDao.removeSpecial(special.getSpecialID());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addVehicle method, of class DaoVehicleImpl.
     */
    @Test
    public void testAddGetVehicle() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("addGetVehicle");
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType("New");
        vehicle.setBodyStyle("Car");
        vehicle.setVehicleYear(2021);
        vehicle.setTransmission("Automatic");
        vehicle.setColour("Blue");
        vehicle.setMileage(950);
        vehicle.setVin("1232");
        vehicle.setMsrp("5000");
        vehicle.setSalesPrice("4000");
        vehicle.setVehicleDesc("This is a good vehicle");
        vehicle.setSalesStatus("Sold");
        vehicle.setSpecialID(special.getSpecialID());
        vehicle.setModelID(model.getModelID());
        vehicle = daoVehicle.addVehicle(vehicle);
        Vehicle fromDao = daoVehicle.addVehicle(vehicle);
        assertEquals(vehicle, fromDao);
    }
    
    /**
     * Test of addVehicle method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetAllVehicles() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getAllVehicles");
        
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setVehicleYear(2021);
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("5000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1.setModelID(model.getModelID());
        daoVehicle.addVehicle(vehicle1);
        
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType("New");
        vehicle2.setBodyStyle("Van");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Manual");
        vehicle2.setColour("Green");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setMsrp("6000");
        vehicle2.setSalesPrice("5000");
        vehicle2.setVehicleDesc("This is another good vehicle");
        vehicle2.setSalesStatus("Sold");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2.setModelID(model.getModelID());
        daoVehicle.addVehicle(vehicle2);
        
        List<Vehicle> vehicles = daoVehicle.getAllVehicles();
        
        assertEquals(2, vehicles.size());
        assertTrue(vehicles.contains(vehicle1));
        assertTrue(vehicles.contains(vehicle2));
    }
    
    /**
     * Test of addVehicle method, of class DaoVehicleImpl.
     */
    @Test
    public void testUpdateVehicle() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("updateVehicle");
        
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType("New");
        vehicle.setBodyStyle("Car");
        vehicle.setVehicleYear(2021);
        vehicle.setTransmission("Automatic");
        vehicle.setColour("Blue");
        vehicle.setMileage(950);
        vehicle.setVin("1232");
        vehicle.setMsrp("5000");
        vehicle.setSalesPrice("4000");
        vehicle.setVehicleDesc("This is a good vehicle");
        vehicle.setSalesStatus("Sold");
        vehicle.setSpecialID(special.getSpecialID());
        vehicle.setModelID(model.getModelID());
        vehicle = daoVehicle.addVehicle(vehicle);
        
        Vehicle fromDao = daoVehicle.getVehicle(vehicle.getVehicleID());
        assertEquals(vehicle, fromDao);
        
        vehicle.setColour("grey");
        daoVehicle.updateVehicle(vehicle);
        assertNotEquals(vehicle, fromDao);
        
        fromDao = daoVehicle.getVehicle(vehicle.getVehicleID());
        assertEquals(vehicle, fromDao);
    }

    /**
     * Test of removeVehicle method, of class DaoVehicleImpl.
     */
    @Test
    public void testRemoveVehicle() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("removeVehicle");
        
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType("New");
        vehicle.setBodyStyle("Car");
        vehicle.setVehicleYear(2021);
        vehicle.setTransmission("Automatic");
        vehicle.setColour("Blue");
        vehicle.setMileage(950);
        vehicle.setVin("1232");
        vehicle.setMsrp("5000");
        vehicle.setSalesPrice("4000");
        vehicle.setVehicleDesc("This is a good vehicle");
        vehicle.setSalesStatus("Sold");
        vehicle.setSpecialID(special.getSpecialID());
        vehicle.setModelID(model.getModelID());
        vehicle = daoVehicle.addVehicle(vehicle);
        
        daoVehicle.removeVehicle(vehicle.getVehicleID());
        
        List<Vehicle> fromDao = daoVehicle.getAllVehicles();
        assertEquals(0, fromDao.size());
    }

    /**
     * Test of getNewVehicles method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetNewVehicles() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getNewVehicles");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setVehicleYear(2021);
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("5000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1.setModelID(model.getModelID());
        vehicle1 = daoVehicle.addVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType("Used");
        vehicle2.setBodyStyle("SUV");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Automatic");
        vehicle2.setColour("Blue");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setMsrp("5000");
        vehicle2.setSalesPrice("4000");
        vehicle2.setVehicleDesc("This is a good vehicle");
        vehicle2.setSalesStatus("Sold");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2.setModelID(model.getModelID());
        vehicle2 = daoVehicle.addVehicle(vehicle2);
        List<Vehicle> fromDao = daoVehicle.getNewVehicles();
        
        assertEquals(1, fromDao.size());
        assertTrue(fromDao.contains(vehicle1));
        assertFalse(fromDao.contains(vehicle2));
    }

    /**
     * Test of getNewVehiclesByMSRP method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetNewVehiclesByMSRP() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getNewVehiclesByMSRP");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setVehicleYear(2021);
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("1000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1.setModelID(model.getModelID());
        vehicle1 = daoVehicle.addVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setMsrp("5000");
        vehicle2.setVehicleType("Used");
        vehicle2.setBodyStyle("SUV");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Automatic");
        vehicle2.setColour("Blue");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setSalesPrice("4000");
        vehicle2.setVehicleDesc("This is a good vehicle");
        vehicle2.setSalesStatus("Sold");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2.setModelID(model.getModelID());
        vehicle2 = daoVehicle.addVehicle(vehicle2);
        
        List<Vehicle> fromDao = daoVehicle.getNewVehiclesByMSRP("New");
        
        assertEquals(1, fromDao.size());
        assertTrue(fromDao.contains(vehicle1));
        assertFalse(fromDao.contains(vehicle2));
    }

    /**
     * Test of getUsedVehicles method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetUsedVehicles() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getUsedVehicles");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setVehicleYear(2021);
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("5000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1.setModelID(model.getModelID());
        vehicle1 = daoVehicle.addVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType("Used");
        vehicle2.setBodyStyle("Van");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Manual");
        vehicle2.setColour("Green");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setMsrp("6000");
        vehicle2.setSalesPrice("5000");
        vehicle2.setVehicleDesc("This is another good vehicle");
        vehicle2.setSalesStatus("In Stock");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2.setModelID(model.getModelID());
        
        vehicle2 = daoVehicle.addVehicle(vehicle2);
        List<Vehicle> fromDao = daoVehicle.getUsedVehicles();
        
        assertEquals(1, fromDao.size());
        assertFalse(fromDao.contains(vehicle1));
        assertTrue(fromDao.contains(vehicle2));
    }

    /**
     * Test of getAllVehiclesSold method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetAllVehiclesSold() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getAllVehiclesSold");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setVehicleYear(2021);
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("5000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1.setModelID(model.getModelID());
        vehicle1 = daoVehicle.addVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType("Used");
        vehicle2.setBodyStyle("Van");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Manual");
        vehicle2.setColour("Green");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setMsrp("6000");
        vehicle2.setSalesPrice("5000");
        vehicle2.setVehicleDesc("This is another good vehicle");
        vehicle2.setSalesStatus("In Stock");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2.setModelID(model.getModelID());
        
        vehicle2 = daoVehicle.addVehicle(vehicle2);
        List<Vehicle> fromDao = daoVehicle.getAllVehiclesSold();
        
        assertEquals(1, fromDao.size());
        assertTrue(fromDao.contains(vehicle1));
        assertFalse(fromDao.contains(vehicle2));
    }

    /**
     * Test of getAllVehiclesForSale method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetAllVehiclesForSale() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getAllVehiclesForSale");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setVehicleYear(2021);
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("5000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1.setModelID(model.getModelID());
        vehicle1 = daoVehicle.addVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleType("Used");
        vehicle2.setBodyStyle("Van");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Manual");
        vehicle2.setColour("Green");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setMsrp("6000");
        vehicle2.setSalesPrice("5000");
        vehicle2.setVehicleDesc("This is another good vehicle");
        vehicle2.setSalesStatus("in stock");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2.setModelID(model.getModelID());
        vehicle2 = daoVehicle.addVehicle(vehicle2);
        Vehicle vehicle3 = new Vehicle();
        vehicle3.setVehicleType("Used");
        vehicle3.setBodyStyle("Truck");
        vehicle3.setVehicleYear(2021);
        vehicle3.setTransmission("Manual");
        vehicle3.setColour("Grey");
        vehicle3.setMileage(950);
        vehicle3.setVin("1232");
        vehicle3.setMsrp("7000");
        vehicle3.setSalesPrice("3000");
        vehicle3.setVehicleDesc("This is a good truck");
        vehicle3.setSalesStatus("in stock");
        vehicle3.setSpecialID(special.getSpecialID());
        vehicle3.setModelID(model.getModelID());
        vehicle3 = daoVehicle.addVehicle(vehicle3);
        List<Vehicle> fromDao = daoVehicle.getAllVehiclesForSale();
        assertEquals(2, fromDao.size());
        assertFalse(fromDao.contains(vehicle1));
        assertTrue(fromDao.contains(vehicle2));
        assertTrue(fromDao.contains(vehicle3));
    }

    /**
     * Test of getAllVehiclesByModel method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetAllVehiclesByModel() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getAllVehiclesByModel");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setModelID(model.getModelID());
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setVehicleYear(2021);
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("5000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1 = daoVehicle.addVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setModelID(model.getModelID());
        vehicle2.setVehicleType("Used");
        vehicle2.setBodyStyle("Van");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Manual");
        vehicle2.setColour("Green");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setMsrp("6000");
        vehicle2.setSalesPrice("5000");
        vehicle2.setVehicleDesc("This is another good vehicle");
        vehicle2.setSalesStatus("In Stock");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2 = daoVehicle.addVehicle(vehicle2);
        
        List<Vehicle> fromDao = daoVehicle.getAllVehiclesByModel(model.getModelID());
        
        assertEquals(2, fromDao.size());
        assertTrue(fromDao.contains(vehicle1));
        assertTrue(fromDao.contains(vehicle2));
    }

    /**
     * Test of getAllVehiclesByYear method, of class DaoVehicleImpl.
     */
    @Test
    public void testGetAllVehiclesByYear() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        System.out.println("getAllVehiclesByYear");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleYear(2020);
        vehicle1.setModelID(model.getModelID());
        vehicle1.setVehicleType("New");
        vehicle1.setBodyStyle("Car");
        vehicle1.setTransmission("Automatic");
        vehicle1.setColour("Blue");
        vehicle1.setMileage(950);
        vehicle1.setVin("1232");
        vehicle1.setMsrp("5000");
        vehicle1.setSalesPrice("4000");
        vehicle1.setVehicleDesc("This is a good vehicle");
        vehicle1.setSalesStatus("Sold");
        vehicle1.setSpecialID(special.getSpecialID());
        vehicle1 = daoVehicle.addVehicle(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setModelID(model.getModelID());
        vehicle2.setVehicleType("Used");
        vehicle2.setBodyStyle("Van");
        vehicle2.setVehicleYear(2021);
        vehicle2.setTransmission("Manual");
        vehicle2.setColour("Green");
        vehicle2.setMileage(950);
        vehicle2.setVin("1232");
        vehicle2.setMsrp("6000");
        vehicle2.setSalesPrice("5000");
        vehicle2.setVehicleDesc("This is another good vehicle");
        vehicle2.setSalesStatus("In Stock");
        vehicle2.setSpecialID(special.getSpecialID());
        vehicle2 = daoVehicle.addVehicle(vehicle2);
        
        List<Vehicle> fromDao = daoVehicle.getAllVehiclesByYear(2021);
        
        assertEquals(1, fromDao.size());
        assertFalse(fromDao.contains(vehicle1));
        assertTrue(fromDao.contains(vehicle2));
    }
    
}
