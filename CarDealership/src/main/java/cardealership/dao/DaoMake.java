/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.dao;

import cardealership.dto.Make;
import java.util.List;

/**
 *
 * @author Joshua Martel
 */
public interface DaoMake {
    
    public Make getMake(int makeId);
    
    public List<Make> getAllMakes(); 
    
    public Make addMake(Make newMake);

    boolean removeMake(int makeID);
}
