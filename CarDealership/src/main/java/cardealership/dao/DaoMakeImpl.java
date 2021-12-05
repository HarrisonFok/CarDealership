package cardealership.dao;

import cardealership.dto.Make;
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
public class DaoMakeImpl implements DaoMake {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Make getMake(int makeId) {
        final String sql = "SELECT makeID, vehicleMake FROM Make WHERE makeID = ?";
        return jdbc.queryForObject(sql, new MakeMapper(), makeId);
    }

    @Override
    public List<Make> getAllMakes() {
       final String sql = "SELECT makeID, vehicleMake FROM Make";
       return jdbc.query(sql, new MakeMapper());
    }

    @Override
    public Make addMake(Make newMake) {
        final String sql = "INSERT INTO Make(vehicleMake) VALUES (?)";
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pState.setString(1, newMake.getVehicleMake());
//            pState.setInt(2, newMake.getModelID());
            
            return pState;
        }, key);
        newMake.setMakeID(key.getKey().intValue());
        return newMake;
    }
    
    private static final class MakeMapper implements RowMapper<Make> {

        @Override
        public Make mapRow(ResultSet rs, int rowNum) throws SQLException {
            Make newMake = new Make();
            newMake.setMakeID(rs.getInt("makeID"));
            newMake.setVehicleMake(rs.getString("vehicleMake"));
//            newMake.setModelID(rs.getInt("modelID"));
            return newMake;
        }
        
    }
    
}
