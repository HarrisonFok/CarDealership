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
import java.math.BigDecimal;
import java.time.LocalDate;
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
     public List<Vehicle> getNewVehiclesByMSRP(String type); //Only first 20 matches
    public List<Vehicle> getUsedVehicles(); //Only first 20 matches
    public List<Vehicle> getAllVehiclesSold();
    public List<Vehicle> getAllVehiclesForSale();
    
    public List<Vehicle> getAllVehiclesByModel(int modelId);
    public List<Vehicle> getAllVehiclesByMake(int makeId);
    public List<Vehicle> getAllVehiclesByYear(int year);
    
    //====Business-Logic Methods====
    //Find sales between dates
    //either-or start and end can be null
    public List<Sale> getSalesInRange(LocalDate start, LocalDate end);
    
    //Find sales between dates and associated with user
    //either-or start and end can be null
    public List<Sale> getSalesInRangeAndUser(LocalDate start, LocalDate end, User user);
    
    //Search for sales related by user
    public List<Sale> getSalesInByUser(User user);
    
    //simply returns sum of sales given
    public BigDecimal totalNumberOfSales(List<Sale> sales);
    
    //WIll return a string with total number of vevicles sold,
    // as well as how many of each model and make
    public List<String> totalNumberOfVehiclesSold(List<Sale> sales);
    
    //cheks if purchase price is no less than 95% of sale price
    // and purchase price is no larger than MSRP
    public String checkIfValidPurchasePrice(Sale newSale, Vehicle boughtVehicle);
    
    public boolean validZip(Sale newSale);
    
    public boolean validYear(Vehicle addedVehicle);
    
    public boolean validTransmission(Vehicle addedVehicle);
    
    public boolean validNewVehicle(Vehicle newVehicle);
    
    public boolean validSalePrice(Vehicle newVehicle);
    
    //Checks that email is in a valid fotmat
    public boolean validEmail(String email);
//    public boolean validEmail(User newUser);
//    public boolean validEmail(Sale newSale);
    
    public boolean validPurchaseType(Sale sale);
    
    public List<Vehicle> getInventoryIndex();
}
