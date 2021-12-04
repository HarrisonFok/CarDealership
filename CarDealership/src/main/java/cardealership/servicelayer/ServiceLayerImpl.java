/*
*   Joshua Martel
*   jophmartel@gmail.com
*   
*
*/

package cardealership.servicelayer;

import cardealership.dao.DaoContact;
import cardealership.dao.DaoContactImpl;
import cardealership.dao.DaoMake;
import cardealership.dao.DaoMakeImpl;
import cardealership.dao.DaoModel;
import cardealership.dao.DaoModelImpl;
import cardealership.dao.DaoSales;
import cardealership.dao.DaoSalesImpl;
import cardealership.dao.DaoSpecials;
import cardealership.dao.DaoSpecialsImpl;
import cardealership.dao.DaoUsers;
import cardealership.dao.DaoUsersImpl;
import cardealership.dao.DaoVehicle;
import cardealership.dao.DaoVehicleImpl;
import cardealership.dto.Contact;
import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Sale;
import cardealership.dto.Special;
import cardealership.dto.User;
import cardealership.dto.Vehicle;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joshua Martel
 */
@Service
@ComponentScan(basePackageClasses = DaoContactImpl.class)
@ComponentScan(basePackageClasses = DaoMakeImpl.class)
@ComponentScan(basePackageClasses = DaoModelImpl.class)
@ComponentScan(basePackageClasses = DaoSalesImpl.class)
@ComponentScan(basePackageClasses = DaoSpecialsImpl.class)
@ComponentScan(basePackageClasses = DaoUsersImpl.class)
@ComponentScan(basePackageClasses = DaoVehicleImpl.class)
public class ServiceLayerImpl implements ServiceLayer {
    
    private DaoContact daoContact;
    private DaoMake daoMake;
    private DaoModel daoModel;
    private DaoSales daoSales;
    private DaoSpecials daoSpecials;
    private DaoUsers daoUsers;
    private DaoVehicle daoVehicle;
    
    public ServiceLayerImpl(DaoContact daoContact, DaoMake daoMake,
            DaoModel daoModel, DaoSales daoSales, DaoSpecials daoSpecials,
            DaoUsers daoUsers, DaoVehicle daoVehicle){
        this.daoContact = daoContact;
        this.daoMake = daoMake;
        this.daoModel = daoModel;
        this.daoSales = daoSales;
        this.daoSpecials = daoSpecials;
        this.daoUsers = daoUsers;
        this.daoVehicle = daoVehicle;
    }

    @Override
    public Contact addContact(Contact newContact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getAllContacts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editContact(Contact newContact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Make getMake(int makeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Make> getAllMakes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Make addMake(Make newMake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getModel(int modelId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Model> getAllModels() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model addModel(Model newModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sale addSale(Sale newSale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sale> getAllSales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sale getSale(int saleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Special addSpecial(Special sp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeSpecial(int specialId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Special getSpecial(int specialId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User addUser(User newUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUserPassword(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehicle addVehicle(Vehicle newVehicle) {
        return daoVehicle.addVehicle(newVehicle);
    }

    @Override
    public boolean removeVehicle(int vehicleId) {
        return daoVehicle.removeVehicle(vehicleId);
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        return daoVehicle.updateVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getNewVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getNewVehiclesByMSRP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getUsedVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getAllVehiclesSold() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getAllVehiclesForSale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
