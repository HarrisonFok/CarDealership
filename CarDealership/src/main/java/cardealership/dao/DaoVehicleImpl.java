package cardealership.dao;

import cardealership.dto.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

/**
 *
 * @author Harrison Fok
 */
public class DaoVehicleImpl implements DaoVehicle {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Vehicle addVehicle(Vehicle newVehicle) {
        // Add a new vehicle into the vehicle table
        final String sql = "INSERT INTO Vehicle(vehicleID, make, vehicleType, bodyStyle, vehicleYear, transmission, colour, mileage, vin, msrp, salesPrice, vehicleDesc, saleStatus, specialID, makeID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pState.setString(1, newVehicle.getMake());
            pState.setString(2, newVehicle.getVehicleType());
            pState.setString(3, newVehicle.getBodyStyle());
            pState.setInt(4, newVehicle.getVehicleYear());
            pState.setString(5, newVehicle.getTransmission());
            pState.setString(6, newVehicle.getColour());
            pState.setInt(7, newVehicle.getMileage());
            pState.setString(8, newVehicle.getVin());
            pState.setString(9, newVehicle.getMsrp());
            pState.setString(10, newVehicle.getSalesPrice());
            pState.setString(11, newVehicle.getVehicleDesc());
            pState.setString(12, newVehicle.getSalesStatus());
            pState.setInt(13, newVehicle.getSpecialID());
            pState.setInt(14, newVehicle.getMakeID());
            return pState;
        }, key);
        
        newVehicle.setVehicleID(key.getKey().intValue());
        
        return newVehicle;
    }

    @Override
    public boolean removeVehicle(int vehicleId) {
        // Remove a vehicle in the Vehicle table
        final String sql = "DELETE FROM Vehicle WHERE vehicleID = ?";
        return jdbc.update(sql, vehicleId) > 0;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        // Update a vehicle in the Vehicle table
        final String sql = "UPDATE Vehicle SET "
                + "make = ?, "
                + "vehicleType = ?, "
                + "bodyStyle = ?, "
                + "vehicleYear = ?, "
                + "transmission = ?, "
                + "colour = ?, "
                + "mileage = ?, "
                + "vin = ?, "
                + "msrp = ?, "
                + "salesPrice = ?, "
                + "vehicleDesc = ?, "
                + "salesStatus = ?, "
                + "specialID = ?, "
                + "makeID = ?;";
        
        return jdbc.update(sql,
                vehicle.getMake(),
                vehicle.getVehicleType(),
                vehicle.getBodyStyle(),
                vehicle.getVehicleYear(),
                vehicle.getTransmission(),
                vehicle.getColour(),
                vehicle.getMileage(),
                vehicle.getVin(),
                vehicle.getMsrp(),
                vehicle.getSalesPrice(),
                vehicle.getVehicleDesc(),
                vehicle.getSalesStatus(),
                vehicle.getSpecialID(),
                vehicle.getMakeID()) > 0;
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
