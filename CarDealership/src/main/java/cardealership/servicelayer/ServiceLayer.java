/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.servicelayer;

import cardealership.dto.Contact;
import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Sale;
import cardealership.dto.Special;
import cardealership.dto.User;
import cardealership.dto.Vehicle;
import java.util.List;

/**
 *
 * @author Joshua Martel
 */
public interface ServiceLayer {
    //====Contact pass-Through methods====
    public Contact addContact(Contact newContact);
    public List<Contact> getAllContacts();
    public boolean editContact(Contact newContact);
    
    //====Make pass-Through methods====
    public Make getMake(int makeId);
    public List<Make> getAllMakes(); 
    public Make addMake(Make newMake);
    
    //====Model pass-Through methods====
    public Model getModel(int modelId);
    public List<Model> getAllModels();
    public Model addModel(Model newModel);
    
    //====Sale pass-Through methods====
    public Sale addSale(Sale newSale);
    public List<Sale> getAllSales();
    public Sale getSale(int saleId);
    
    //====Special pass-Through methods====
    public Special addSpecial(Special sp);
    public boolean removeSpecial(int specialId);
    public Special getSpecial(int specialId);
    
    //====User pass-Through methods====
    public User addUser(User newUser);
    public boolean updateUser (User user);
    public boolean updateUserPassword(User user);
    public User getUser(int userId);
    public List<User> getAllUsers();
    
    //====Vehicle pass-Through methods====
    public Vehicle addVehicle(Vehicle newVehicle);
    public boolean removeVehicle(int vehicleId);
    public boolean updateVehicle(Vehicle vehicle);
    public List<Vehicle> getNewVehicles(); //Only first 20 matches
    //Highest MSRP
    public List<Vehicle> getNewVehiclesByMSRP(); //Only first 20 matches
    public List<Vehicle> getUsedVehicles(); //Only first 20 matches
    public List<Vehicle> getAllVehiclesSold();
    public List<Vehicle> getAllVehiclesForSale();
    
    //====Business-Logic Methods====
    
    
    
    
}
