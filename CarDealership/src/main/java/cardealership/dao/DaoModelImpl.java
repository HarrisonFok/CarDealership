package cardealership.dao;

import cardealership.dto.Model;
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
public class DaoModelImpl implements DaoModel {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Model getModel(int modelId) {
        final String sql = "SELECT modelID, vehicleModel FROM Model WHERE modelID = ?";
        return jdbc.queryForObject(sql, new ModelMapper(), modelId);
    }

    @Override
    public List<Model> getAllModels() {
        final String sql = "SELECT modelID, vehicleModel FROM Model";
        return jdbc.query(sql, new ModelMapper());
    }

    @Override
    public Model addModel(Model newModel) {
        final String sql = "INSERT INTO Model(vehicleModel, makeId) VALUES (?,?)";
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pState.setString(1, newModel.getVehicleModel());
            pState.setInt(2, newModel.getMakeID());
            return pState;
        }, key);
        newModel.setModelID(key.getKey().intValue());
        return newModel;
    }
    
    private static final class ModelMapper implements RowMapper<Model> {

        @Override
        public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
            Model newModel = new Model();
            newModel.setModelID(rs.getInt("modelID"));
            newModel.setVehicleModel(rs.getString("vehicleModel"));
            return newModel;
        }
        
    }
}
