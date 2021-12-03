/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.dao;

import cardealership.dto.Vehicle;
import java.util.List;

/**
 *
 * @author Joshua Martel
 */
public interface DaoVehicle {
    
    public Vehicle addVehicle(Vehicle newVehicle);
    
    public boolean removeVehicle(int vehicleId);
    
    public boolean updateVehicle(Vehicle vehicle);
    
    public List<Vehicle> getNewVehicles(); //Only first 20 matches
    //Highest MSRP
    public List<Vehicle> getNewVehiclesByMSRP(); //Only first 20 matches
    
    public List<Vehicle> getUsedVehicles(); //Only first 20 matches
    
    public List<Vehicle> getAllVehiclesSold();
    
    public List<Vehicle> getAllVehiclesForSale();
    
}
