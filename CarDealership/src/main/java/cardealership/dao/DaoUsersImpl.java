package cardealership.dao;

import cardealership.dto.User;
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
public class DaoUsersImpl implements DaoUsers {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public User addUser(User newUser) {
        final String sql = "INSERT INTO Users(firstName, lastName, userName, userPassword, userRole) VALUES (?,?,?,?,?)";
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pState.setString(1, newUser.getFirstName());
            pState.setString(2, newUser.getLastName());
            pState.setString(3, newUser.getUserName());
            pState.setString(4, newUser.getUserPassword());
            pState.setString(5, newUser.getUserRole());
            
            return pState;
        }, key);
        newUser.setUserID(key.getKey().intValue());
        return newUser;
    }

    @Override
    public boolean updateUser(User user) {
        final String sql = "UPDATE Users SET firstName = ?"
                + ", lastName = ?"
                + ", userName = ?"
                + ", userRole = ?"
                + "WHERE userID = ?";
        return jdbc.update(sql, 
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getUserRole(),
                user.getUserID()) > 0;
    }

    @Override
    public boolean updateUserPassword(User user) {
        final String sql = "UPDATE Users SET userPassword = ? WHERE userID = ?";
        return jdbc.update(sql,
                user.getUserPassword(),
                user.getUserID()) > 0;
    }

    @Override
    public User getUser(int userId) {
        final String sql = "SELECT userID, firstName, lastName, userName, userPassword, userRole FROM Users WHERE userID = ?";
        return jdbc.queryForObject(sql, new UserMapper(), userId);
    }

    @Override
    public List<User> getAllUsers() {
        final String sql = "SELECT userID, firstName, lastName, userName, userPassword, userRole FROM Users";
        return jdbc.query(sql, new UserMapper());
    }
    
    private static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User newUser = new User();
            newUser.setUserID(rs.getInt("userID"));
            newUser.setFirstName(rs.getString("firstName"));
            newUser.setLastName(rs.getString("lastName"));
            newUser.setUserName(rs.getString("userName"));
            newUser.setUserPassword(rs.getString("userPassword"));
            newUser.setUserRole(rs.getString("userRole"));
            return newUser;
        }
        
    }
    
}
