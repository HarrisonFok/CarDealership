/*
*   Joshua Martel
*   jophmartel@gmail.com
*   
*
*/

package cardealership.dao;

import cardealership.dto.Sale;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Joshua Martel
 */
@Repository
public class DaoSalesImpl implements DaoSales {

    @Override
    public Sale addSale(Sale newSale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sale> getAllSales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sale getSale(int saleId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
