package cardealership.dao;

import cardealership.TestApplicationConfiguration;
import cardealership.dto.Contact;
import cardealership.dto.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoContactTest {

    @Autowired
    DaoContact contactDao;

    @Autowired
    DaoVehicle vehicleDao;


    public DaoContactTest() {
    }

    @BeforeEach
    public void setUp() {

        List<Contact> contacts = contactDao.getAllContacts();
        for(Contact contact : contacts) {
            contactDao.removeContact(contact.getContactID());
        }
    }


    @Test
    public void testAddGetContact() {

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
        vehicle.setModelID(1);
        vehicle.setSpecialID(1);
        vehicleDao.addVehicle(vehicle);


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
        vehicle.setModelID(1);
        vehicle.setSpecialID(1);
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
