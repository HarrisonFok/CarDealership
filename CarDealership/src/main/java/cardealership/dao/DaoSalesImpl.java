package cardealership.dao;

import cardealership.dto.Sale;
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
public class DaoSalesImpl implements DaoSales {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Sale addSale(Sale newSale) {
        // SQL statement to add a sale to the Sales table
        final String sql = "INSERT INTO Sales(email, phone, street, zipCode, purchasePrice, purchaseType, userID, vehicleID) VALUES (?,?,?,?,?,?,?,?)";
        
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pState.setString(1, newSale.getEmail());
            pState.setString(2, newSale.getPhone());
            pState.setString(3, newSale.getStreet());
            pState.setInt(4, newSale.getZipCode());
            pState.setString(5, newSale.getPurchasePrice());
            pState.setString(6, newSale.getPurchaseType());
            pState.setInt(7, newSale.getUserID());
            pState.setInt(8, newSale.getVehicleID());
            
            return pState;
        }, key);
        
        newSale.setSaleID(key.getKey().intValue());
        
        return newSale;
    }

    @Override
    public List<Sale> getAllSales() {
        // SQL statement that selects all the sales from the Sales table
        final String sql = "SELECT saleID, email, phone, street, zipCode, purchasePrice, purchaseType, userID, vehicleID FROM Sales";
        return jdbc.query(sql, new SalesMapper());
    }

    @Override
    public Sale getSale(int saleId) {
        // SQL statement that selects a single sale from the Sales table
        final String sql = "SELECT saleID, email, phone, street, zipCode, purchasePrice, purchaseType, userID, vehicleID FROM Sales WHERE saleID = ?";
        return jdbc.queryForObject(sql, new SalesMapper(), saleId);
    }
    
    private static final class SalesMapper implements RowMapper<Sale> {
        @Override
        public Sale mapRow(ResultSet rs, int rowNum) throws SQLException {
            Sale sale = new Sale();
            sale.setSaleID(rs.getInt("saleID"));
            sale.setEmail(rs.getString("email"));
            sale.setPhone(rs.getString("phone"));
            sale.setStreet(rs.getString("street"));
            sale.setZipCode(rs.getInt("zipCode"));
            sale.setPurchasePrice(rs.getString("purchasePrice"));
            sale.setPurchaseType(rs.getString("purchaseType"));
            sale.setUserID(rs.getInt("userID"));
            sale.setVehicleID(rs.getInt("vehicleID"));
            return sale;
        }
        
    }
    
}
