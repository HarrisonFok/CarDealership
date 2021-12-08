package cardealership.dao;

import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    public DaoVehicleImpl(){
        
    }

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
                + "modelID = ?,"
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
                + "saleStatus = ?, "
                + "specialID = ? "
                + "WHERE vehicleID = ?";
                
        
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
                vehicle.getSpecialID(),
                vehicle.getVehicleID()) > 0;
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
        final String GET_NEW_VEHICLES = "SELECT * FROM vehicle WHERE vehicleType = ?";
        return jdbc.query(GET_NEW_VEHICLES, new VehicleMapper(), "new");
    }

//SELECT DISTINCT ElectricityBill AS 3rdHighestElectricityBill
//FROM Bills
//ORDER BY ElectricityBill DESC
//LIMIT 1
    @Override
    public List<Vehicle> getNewVehiclesByMSRP(String type) {
        final String GET_NEW_VEHICLES = "SELECT * FROM vehicle WHERE vehicleType = ?" +
                        " ORDER BY msrp DESC " +
                        "LIMIT 20";
        System.out.println(jdbc.query(GET_NEW_VEHICLES, new VehicleMapper(), type));
        return jdbc.query(GET_NEW_VEHICLES, new VehicleMapper(), type);
    }

    @Override
    public List<Vehicle> getUsedVehicles() {
        final String GET_USED_VEHICLES = "SELECT * FROM vehicle WHERE vehicleType = ?";
        return jdbc.query(GET_USED_VEHICLES, new VehicleMapper(), "used");    
    }

    @Override
    public List<Vehicle> getAllVehiclesSold() {
        final String GET_SOLD = "SELECT * FROM vehicle WHERE saleStatus = ?";
        return jdbc.query(GET_SOLD, new VehicleMapper(), "sold");
    }

    @Override
    public List<Vehicle> getAllVehiclesForSale() {
        final String GET_FOR_SALE = "SELECT * FROM vehicle WHERE saleStatus = ?";
        return jdbc.query(GET_FOR_SALE, new VehicleMapper(), "in stock");
    }
    
    @Override
    public List<Vehicle> getAllVehiclesByModel(int modelID){
        final String GET_BY_MODEL = "SELECT * FROM vehicle WHERE modelID = ?";

        return jdbc.query(GET_BY_MODEL, new VehicleMapper(), modelID);
    }
    
    @Override
    public List<Vehicle> getAllVehiclesByMake(int makeId){
        final String GET_MAKE = "SELECT * FROM Model WHERE makeID = ?";
        final String GET_BY_MODEL = "SELECT * FROM vehicle WHERE modelID = ?";
        List<Model> model = jdbc.query(GET_MAKE, new ModelMapper(), makeId);
        List<Vehicle> vehicles = new ArrayList();
        List<Vehicle> tempVeh;
        for(Model m: model){
            tempVeh = jdbc.query(GET_BY_MODEL, new VehicleMapper(), m.getModelID());
            vehicles.addAll(tempVeh);
        }
        return vehicles;
    }
    
    @Override
    public List<Vehicle> getAllVehiclesByYear(int year){
        final String GET_BY_YEAR = "SELECT * FROM vehicle WHERE vehicleYear = ?";
        return jdbc.query(GET_BY_YEAR, new VehicleMapper(), year);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        final String GET_BY_YEAR = "SELECT * FROM vehicle";
        return jdbc.query(GET_BY_YEAR, new VehicleMapper());
    }

    public static final class VehicleMapper implements RowMapper<Vehicle>{

        @Override
        public Vehicle mapRow(ResultSet rs, int index) throws SQLException{
           Vehicle vec = new Vehicle();
           vec.setVehicleID(rs.getInt("vehicleID"));
           vec.setBodyStyle(rs.getString("bodyStyle"));
           vec.setVehicleType(rs.getString("vehicleType"));
           vec.setVehicleYear(rs.getInt("vehicleYear"));
           vec.setTransmission(rs.getString("transmission"));
           vec.setColour(rs.getString("colour"));
           vec.setMileage(rs.getInt("mileage"));
           vec.setVin(rs.getString("vin"));
           vec.setMsrp(rs.getString("msrp"));
           vec.setSalesPrice(rs.getNString("salesPrice"));
           vec.setVehicleDesc(rs.getString("vehicleDesc"));
           vec.setSalesStatus(rs.getString("saleStatus"));
           vec.setSpecialID(rs.getInt("specialID"));
           vec.setModelID(rs.getInt("modelID"));
           return vec;
        }
        
    }
    
    private static final class ModelMapper implements RowMapper<Model> {

        @Override
        public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
            Model newModel = new Model();
            newModel.setModelID(rs.getInt("modelID"));
            newModel.setVehicleModel(rs.getString("vehicleModel"));
            newModel.setMakeID(rs.getInt("makeID"));
            return newModel;
        }
        
    }
}
