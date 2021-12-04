package cardealership.controller;

import cardealership.dto.Sale;
import cardealership.servicelayer.ServiceLayerImpl;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Harrison Fok
 */
@RestController
@RequestMapping("/dealership/sales")
@ComponentScan(basePackageClasses = ServiceLayerImpl.class)
public class ControllerSales {
    
    @Autowired
    private ServiceLayerImpl service;
    
    public ControllerSales(ServiceLayerImpl service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public List<Sale> getAllSales() {
        return service.getAllSales();
    }
    
    @GetMapping("/{id}")
    public Sale getSale(int saleID) {
        return service.getSale(saleID);
    }
    
    @PostMapping("/addSale")
    public Sale addSale(String email, String phone, String street, 
            Integer zipCode, String purchasePrice, String purchaseType, 
            Integer userID, Integer vehicleID, LocalDate saleDate)
    {
        Sale newSale = new Sale();
        newSale.setEmail(email);
        newSale.setPhone(phone);
        newSale.setStreet(street);
        newSale.setZipCode(zipCode);
        newSale.setPurchasePrice(purchasePrice);
        newSale.setPurchaseType(purchaseType);
        newSale.setUserID(userID);
        newSale.setVehicleID(vehicleID);
        newSale.setSaleDate(saleDate);
        return service.addSale(newSale);
    }
}
