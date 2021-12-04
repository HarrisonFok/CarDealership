package cardealership.dao;

import cardealership.dto.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Harrison Fok
 */
@Repository
public class DaoVehicleImpl implements DaoVehicle {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Vehicle addVehicle(Vehicle newVehicle) {
        // Add a new vehicle into the vehicle table
        final String sql = "INSERT INTO Vehicle( modelId, vehicleType, bodyStyle, vehicleYear, transmission, colour, mileage, vin, msrp, salesPrice, vehicleDesc, saleStatus, specialID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pState.setInt(1, newVehicle.getModelID());
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
//            pState.setInt(14, newVehicle.getMake());
            
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
                + "modelID = ?;";
        
        return jdbc.update(sql,
                vehicle.getModelID(),
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
                vehicle.getSpecialID()) > 0;
//        ,
//                vehicle.getMakeID())
    }
    
    @Override
    public Vehicle getVehicle(int vehicleId){
        final String GET_VEHICLE = "SELECT * FROM vehicle WHERE vehicleID = ?";
        return jdbc.queryForObject(GET_VEHICLE, new VehicleMapper(), vehicleId);
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
    
    public static final class VehicleMapper implements RowMapper<Vehicle>{

        @Override
        public Vehicle mapRow(ResultSet rs, int index) throws SQLException{
           Vehicle vec = new Vehicle();
           vec.setBodyStyle(rs.getString("bodyStyle"));
           vec.setVehicleYear(rs.getInt("vehicleYear"));
           vec.setTransmission(rs.getString("transmission"));
           vec.setColour(rs.getString("colour"));
           vec.setMileage(rs.getInt("mileage"));
           vec.setVin(rs.getString("vin"));
           vec.setMsrp(rs.getString("msrp"));
           vec.setSalesPrice(rs.getNString("salesPrice"));
           vec.setVehicleDesc(rs.getString("vehicleDesc"));
           vec.setSalesStatus(rs.getString("salesStatus"));
           vec.setSpecialID(rs.getInt("specialID"));
           vec.setModelID(rs.getInt("modelID"));
           return vec;
        }
        
    }
}
