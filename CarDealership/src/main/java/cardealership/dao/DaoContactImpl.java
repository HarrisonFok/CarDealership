package cardealership.dao;

import cardealership.dto.Contact;
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
public class DaoContactImpl implements DaoContact {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Contact addContact(Contact newContact) {
        final String sql = "INSERT INTO Contact(contactName, message, email, phone, vehicleID) VALUES (?,?,?,?,?)";
        GeneratedKeyHolder key = new GeneratedKeyHolder();
        jdbc.update((Connection conn) -> {
            PreparedStatement pState = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pState.setString(1, newContact.getContactName());
            pState.setString(2, newContact.getMessage());
            pState.setString(3, newContact.getEmail());
            pState.setString(4, newContact.getPhone());
            pState.setInt(5, newContact.getVehicleID());
            
            return pState;
        }, key);
        newContact.setContactID(key.getKey().intValue());
        return newContact;
    }

    @Override
    public List<Contact> getAllContacts() {
        final String sql = "SELECT contactID, contactName, message, email, phone, vehicleID FROM Contact";
        return jdbc.query(sql, new ContactMapper());
    }

    @Override
    public boolean editContact(Contact newContact) {
        final String sql = "UPDATE Contact SET "
                + "contactName = ?,"
                + "message = ?,"
                + "email = ?,"
                + "phone = ?,"
                + "vehicleID = ?"
                + " WHERE contactID = ?";
        return jdbc.update(sql,
                newContact.getContactName(),
                newContact.getMessage(),
                newContact.getEmail(),
                newContact.getPhone(),
                newContact.getVehicleID(),
                newContact.getContactID()) > 0;
    }

    @Override
    public boolean removeContact(int contactID) {
        final String sql = "DELETE FROM contact WHERE contactID = ?";
        return jdbc.update(sql, contactID) > 0;
    }

    private static final class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact newContact = new Contact();
            newContact.setContactID(rs.getInt("contactID"));
            newContact.setContactName(rs.getString("contactName"));
            newContact.setMessage(rs.getString("message"));
            newContact.setEmail(rs.getString("email"));
            newContact.setPhone(rs.getString("phone"));
            newContact.setVehicleID(rs.getInt("vehicleID"));
            return newContact;
        }
        
    }
    
}
