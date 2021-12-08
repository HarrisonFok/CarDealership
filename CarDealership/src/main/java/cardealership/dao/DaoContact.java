/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.dao;

import cardealership.dto.Contact;
import java.util.List;

/**
 *
 * @author Joshua Martel
 */
public interface DaoContact {
    
    public Contact addContact(Contact newContact);
    
    public List<Contact> getAllContacts();
    
    public boolean editContact(Contact newContact);

    boolean removeContact(int contactID);
    
    
}
