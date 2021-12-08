/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.dao;

import cardealership.dto.Special;

/**
 *
 * @author Joshua Martel
 */
public interface DaoSpecials {
    
    public Special addSpecial(Special sp);
    
    public boolean removeSpecial(int specialId);
    
    public Special getSpecial(int specialId);
    
}
