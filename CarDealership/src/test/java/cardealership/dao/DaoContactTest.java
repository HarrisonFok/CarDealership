package cardealership.dao;

import cardealership.TestApplicationConfiguration;
import cardealership.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoContactTest {

    @Autowired
    DaoContact contactDao;

    @Autowired
    DaoVehicle vehicleDao;

    @Autowired
    DaoModel modelDao;

    @Autowired
    DaoMake makeDao;

    @Autowired
    DaoUsers usersDao;

    @Autowired
    DaoSales salesDao;

    @Autowired
    DaoSpecials specialsDao;


    public DaoContactTest() {
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

        List<Vehicle> vehicles = vehicleDao.getAllVehicles();
        for(Vehicle vehicle : vehicles) {
            vehicleDao.removeVehicle(vehicle.getVehicleID());
        }

        List<Model> models = modelDao.getAllModels();
        for(Model model : models) {
            modelDao.removeModel(model.getModelID());
        }

        List<Make> makes = makeDao.getAllMakes();
        for(Make make : makes) {
            makeDao.removeMake(make.getMakeID());
        }
        List<User> users = usersDao.getAllUsers();
        for (User user: users) {
            usersDao.removeUser(user.getUserID());
        }
        List<Special> specials = specialsDao.getAllSpecials();
        for (Special special: specials) {
            specialsDao.removeSpecial(special.getSpecialID());
        }

    }


    @Test
    public void testAddGetContact() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        User newUser = new User();
        newUser.setFirstName("Bob");
        newUser.setLastName("Zuckerberg");
        newUser.setUserName("zucker");
        newUser.setUserPassword("iambob");
        newUser.setUserRole("Admin");
        usersDao.addUser(newUser);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);

        Vehicle vehicle = new Vehicle();
        vehicle.setSalesStatus("sold");
        vehicle.setBodyStyle("car");
        vehicle.setColour("red");
        vehicle.setMileage(1000);
        vehicle.setVehicleType("used");
        vehicle.setMsrp("200");
        vehicle.setSalesPrice("15000");
        vehicle.setTransmission("manual");
        vehicle.setVehicleYear(2020);
        vehicle.setVin("GF52D");
        vehicle.setVehicleDesc("test vehicle");
        vehicle.setModelID(model.getModelID());
        vehicle.setSpecialID(special.getSpecialID());
        vehicleDao.addVehicle(vehicle);

        Sale sale = new Sale();
        sale.setEmail("ROBERT@GMAIL.COM");
        sale.setPhone("343-554-5234");
        sale.setStreet("4 Sample lane");
        sale.setZipCode(33755);
        sale.setPurchasePrice("4000");
        sale.setPurchaseType("cash");
        sale.setUserID(newUser.getUserID());
        sale.setVehicleID(vehicle.getVehicleID());
        sale.setSaleDate(LocalDate.now());
        salesDao.addSale(sale);


        Contact contact = new Contact();
        contact.setContactName("test name");
        contact.setEmail("test@gmail.com");
        contact.setPhone("905-334-2234");
        contact.setMessage("this is a test");
        contact.setVehicleID(vehicle.getVehicleID());
        Contact actualNotNull = contactDao.addContact(contact);

        Contact contact2 = new Contact();
        contact2.setContactName("test name2");
        contact2.setEmail("test2@gmail.com");
        contact2.setPhone("905-334-5471");
        contact2.setMessage("this is a test 2");
        contact2.setVehicleID(vehicle.getVehicleID());
        contactDao.addContact(contact2);

        List<Contact> actual = contactDao.getAllContacts();

        List<Contact> expected = new ArrayList<>();
        expected.add(contact);
        expected.add(contact2);

        assertNotNull(actualNotNull, "object should not be null");
        assertEquals(expected, actual, "expected and actual should be the same");
    }

    @Test
    public void testEditContact() {
        Special special = new Special();
        special.setDiscount("Great 20%!!!!");
        Calendar C = new GregorianCalendar(2021,Calendar.DECEMBER,21);
        Calendar CTwo = new GregorianCalendar(2021,Calendar.DECEMBER,25);
        Date DD = C.getTime();
        Date DDTwo = CTwo.getTime();
        special.setStartDate(DD);
        special.setEndDate(DDTwo);
        specialsDao.addSpecial(special);

        User newUser = new User();
        newUser.setFirstName("Bob");
        newUser.setLastName("Zuckerberg");
        newUser.setUserName("zucker");
        newUser.setUserPassword("iambob");
        newUser.setUserRole("Admin");
        usersDao.addUser(newUser);

        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);

        Model model = new Model();
        model.setMakeID(1);
        model.setVehicleModel("test model");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);


        Vehicle vehicle = new Vehicle();
        vehicle.setSalesStatus("sold");
        vehicle.setBodyStyle("car");
        vehicle.setColour("red");
        vehicle.setMileage(1000);
        vehicle.setVehicleType("used");
        vehicle.setMsrp("200");
        vehicle.setSalesPrice("15000");
        vehicle.setTransmission("manual");
        vehicle.setVehicleYear(2020);
        vehicle.setVin("GF52D");
        vehicle.setVehicleDesc("test vehicle");
        vehicle.setModelID(model.getModelID());
        vehicle.setSpecialID(special.getSpecialID());
        vehicleDao.addVehicle(vehicle);


        Contact contact = new Contact();
        contact.setContactName("test name");
        contact.setEmail("test@gmail.com");
        contact.setPhone("905-334-2234");
        contact.setMessage("this is a edit test");
        contact.setVehicleID(vehicle.getVehicleID());
        contactDao.addContact(contact);

        contact.setContactName("updated name test");
        contactDao.editContact(contact);
        List<Contact> actual = contactDao.getAllContacts();

        List<Contact> expected = new ArrayList<>();
        expected.add(contact);

        assertEquals(expected, actual, "expected and actual contacts should be the same");
    }
}
