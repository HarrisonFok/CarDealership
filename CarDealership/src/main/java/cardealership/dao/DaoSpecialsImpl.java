package cardealership.dao;

import cardealership.dto.Special;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class DaoSpecialsImpl implements DaoSpecials {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Special addSpecial(Special newSpecial) {
        // SQL statement to add a sale
        final String sql = "INSERT INTO specials(startDate, endDate, discount) VALUES (?,?,?)";
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Convert java.util.Date to java.sql.Date
            pState.setDate(1, new java.sql.Date(newSpecial.getStartDate().getTime()));
            pState.setDate(2, new java.sql.Date(newSpecial.getEndDate().getTime()));
            pState.setString(3, newSpecial.getDiscount());
            return pState;
        }, key);
        
        newSpecial.setSpecialID(key.getKey().intValue());
        return newSpecial;
    }

    @Override
    public boolean removeSpecial(int specialId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Special getSpecial(int specialId) {
        final String sql = "SELECT specialID, startDate, endDate, discount FROM Specials WHERE specialID = ?";
        return jdbc.queryForObject(sql, new SpecialMapper(), specialId);
    }
    
    private static final class SpecialMapper implements RowMapper<Special> {

        @Override
        public Special mapRow(ResultSet rs, int rowNum) throws SQLException {
            Special special = new Special();
            special.setSpecialID(rs.getInt("specialID"));
            special.setStartDate(rs.getDate("startDate"));
            special.setEndDate(rs.getDate("endDate"));
            special.setDiscount(rs.getString("discount"));
            return special;
        }
        
    }
    
}
