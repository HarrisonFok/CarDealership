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
    
    @Autowired
    private ControllerAdmin admin;
    
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
        //checks for valid email
        if(!service.validEmail(email) && email.length() != 0){
            return ResponseHandler.generateResponse(
                "Error: invalid email. Must be in proper format", 
                    HttpStatus.MULTI_STATUS, null);
        }
        newSale.setPhone(phone);
        //cheks if missing a phone and a email
        if(phone.length() == 0 && email.length() == 0){
            return ResponseHandler.generateResponse(
                "Error: must have either an email or phone number", 
                    HttpStatus.MULTI_STATUS, null);
        }
        newSale.setStreet(street);
        newSale.setZipCode(zipCode);
        //cheks if zip is exactly 5 digits long
        if(!service.validZip(newSale)){
            return ResponseHandler.generateResponse(
                    "Error: invalid zip", HttpStatus.MULTI_STATUS, null);
        }
        newSale.setPurchasePrice(purchasePrice);
        newSale.setPurchaseType(purchaseType);
        //Checks if proper finance type
        if(!service.validPurchaseType(newSale)){
            return ResponseHandler.generateResponse(
                    "Error: invalid purchase type. Must be Bank Finance, Cash, or Dealer Finance", 
                        HttpStatus.MULTI_STATUS, null);
        }
        newSale.setUserID(userID);
        newSale.setVehicleID(vehicleID);
        //checks if vehicle has already be sold
        if(!service.validVehicleForSale(vehicleID)){
            return ResponseHandler.generateResponse(
                    "Error: vehicle has already been sold", 
                        HttpStatus.MULTI_STATUS, null);
        }
        
        //Update vehicle saleStatus
        
        Vehicle vecForSale = service.getVehicle(vehicleID);
        vecForSale.setSalesStatus("sold");
        admin.update(vehicleID, vecForSale);
        //add sales date
        newSale.setSaleDate(saleDate);
        service.addSale(newSale);
        
        return ResponseHandler.generateResponse("Successfully added sale!", HttpStatus.OK, newSale);
    }
}