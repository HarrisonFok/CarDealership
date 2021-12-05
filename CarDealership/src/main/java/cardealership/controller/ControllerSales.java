package cardealership.controller;

import cardealership.dto.Sale;
import cardealership.dto.Vehicle;
import cardealership.servicelayer.ServiceLayerImpl;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @GetMapping("/allSales")
    public List<Sale> getAllSales() {
        return service.getAllSales();
    }
    
    @GetMapping("/salesIndex")
    public List<Vehicle> getInventoryIndex(){
        return service.getInventoryIndex();
    }
    
    @GetMapping("/getSale/{saleID}")
    public Sale getSale(int saleID) {
        return service.getSale(saleID);
    }
    
    
    
    @PostMapping("/addSale")
    public ResponseEntity<Object> addSale(String email, String phone, String street, 
            Integer zipCode, String purchasePrice, String purchaseType, 
            Integer userID, Integer vehicleID, LocalDate saleDate)
    {
        Sale newSale = new Sale();
        newSale.setEmail(email);
        if(!service.validEmail(email)){
            return ResponseHandler.generateResponse(
                "Error: invalid email. Must be in proper format", 
                    HttpStatus.MULTI_STATUS, null);
        }
        newSale.setPhone(phone);
        if(phone.length() == 0 && email.length() == 0){
            return ResponseHandler.generateResponse(
                "Error: must have either an email or phone number", 
                    HttpStatus.MULTI_STATUS, null);
        }
        newSale.setStreet(street);
        newSale.setZipCode(zipCode);
        if(!service.validZip(newSale)){
            return ResponseHandler.generateResponse(
                    "Error: invalid zip", HttpStatus.MULTI_STATUS, null);
        }
        newSale.setPurchasePrice(purchasePrice);
        newSale.setPurchaseType(purchaseType);
        newSale.setUserID(userID);
        newSale.setVehicleID(vehicleID);
        newSale.setSaleDate(saleDate);
        service.addSale(newSale);
        return ResponseHandler.generateResponse("Successfully added sale!", HttpStatus.OK, newSale);
    }
}