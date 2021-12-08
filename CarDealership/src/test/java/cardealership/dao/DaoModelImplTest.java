
package cardealership.dao;
import cardealership.TestApplicationConfiguration;
import cardealership.dto.Contact;
import cardealership.dto.Make;
import cardealership.dto.Model;
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
/**
 *
 * @author noel
 */

@SpringBootTest(classes = TestApplicationConfiguration.class)
public class DaoModelImplTest {
   
 
    @Autowired
    DaoMake makeDao;
    @Autowired
    DaoVehicle vehicleDao;
    @Autowired
    DaoContact contactDao;
    @Autowired
    DaoModel modelDao;


 public DaoModelImplTest() {
    }

    @BeforeEach
    public void setUp() {
        List<Vehicle> vehicles = vehicleDao.getAllVehicles();
        for(Vehicle vehicle : vehicles) {
            vehicleDao.removeVehicle(vehicle.getVehicleID());
        }
List<Contact> contacts = contactDao.getAllContacts();
        for(Contact contact : contacts) {
            contactDao.removeContact(contact.getContactID());
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
     * Test of getModel method, of class DaoModelImpl.
     */
    @Test
    public void testGetModel() { 
        //make a make
        Make make = new Make();
        make.setVehicleMake("test make");
        makeDao.addMake(make);
        int makeID =make.getMakeID();
        //make a model
        String modelString = "Mustang";
        Model model = new Model();
        model.setVehicleModel(modelString);
        model.setMakeID(makeID);
        
        //add model
        modelDao.addModel(model);
        Model daoModel = modelDao.getModel(model.getModelID());
        //check
        assertEquals(modelString, daoModel.getVehicleModel());
    }
    

    /**
     * Test of getAllModels method, of class DaoModelImpl.
     */
    @Test
    public void testGetAllModels() {
       List<Model>models= modelDao.getAllModels();
        assertEquals(models, modelDao.getAllModels());
    }

    /**
     * Test of addModel method, of class DaoModelImpl.
     */
    @Test
    public void testAddModel() {
        Make make = new Make();
        make.setVehicleMake("Ford");
        makeDao.addMake(make);

        Model model = new Model();
        model.setVehicleModel("Mustang");
        model.setMakeID(make.getMakeID());
        modelDao.addModel(model);
      List<Model>models= modelDao.getAllModels();
        assertEquals(1, models.size());

    }
    
}
