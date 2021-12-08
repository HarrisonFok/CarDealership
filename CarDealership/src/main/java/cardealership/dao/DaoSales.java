/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.dao;

import cardealership.dto.Sale;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Joshua Martel
 */
public interface DaoSales {
    
    public Sale addSale(Sale newSale);
    
    public List<Sale> getAllSales();
    //optional one if we have time or is required by assessment
//    public List<Sale> getAllSalesForDate(LocalDate date);
    
    public Sale getSale(int saleId);
    
    
}
