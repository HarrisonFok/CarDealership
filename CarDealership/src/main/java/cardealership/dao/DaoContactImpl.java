/*
*   Joshua Martel
*   jophmartel@gmail.com
*   
*
*/

package cardealership.dao;

import cardealership.dto.Contact;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joshua Martel
 */
@Repository
public class DaoContactImpl implements DaoContact {

    @Override
    public Contact addContact(Contact newContact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getAllContacts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editContact(Contact newContact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
