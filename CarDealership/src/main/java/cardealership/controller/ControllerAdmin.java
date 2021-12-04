/*
*   Joshua Martel
*   jophmartel@gmail.com
*   
*
*/

package cardealership.controller;

import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Special;
import cardealership.dto.User;
import cardealership.dto.Vehicle;
import cardealership.servicelayer.ServiceLayerImpl;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joshua Martel
 */
@RestController
@RequestMapping("/dealership/admin")
@ComponentScan(basePackageClasses = ServiceLayerImpl.class)
public class ControllerAdmin {
    
    @Autowired
    private ServiceLayerImpl service;
    
    public ControllerAdmin(ServiceLayerImpl service) {
        this.service = service;
    }
    
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        //return daoUsers.getAllUsers();
        return service.getAllUsers();
    }
    
    @PostMapping("/addUser")
    public User addUser(String firsName, String lastName, String userName,
            String password, String role){
        User newUser = new User();
        //setters here
        //*
        //*
        //*
        //return daoUsers.addUser(newUser);
        return service.addUser(newUser);
    }
    
    @PutMapping("editUser/{id}")
    public ResponseEntity update(@PathVariable int userId, 
            @RequestBody User user) {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if(userId != user.getUserID()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        //} else if (daoUsers.updateUser(user)) {
        } else if (service.updateUser(user)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
    
    @PostMapping("/changePassword")
    public String changePassword(int userId, String password){
        //User user = daoUsers.getUser(userId);
        User user = service.getUser(userId);
        user.setUserPassword(password);
        //daoUsers.updateUserPassword(user);
        service.updateUserPassword(user);
        return "Password changed";
    }
    
    //====Make Methods====
    
    @PostMapping("/addMake")
    public Make addMake(String make, int modelId){
        Make newMake = new Make();
        
        newMake.setModelID(modelId);
        newMake.setVehicleMake(make);
        //return daoMake.addMake(newMake);
        return service.addMake(newMake);
    }
    
    //====Model Methods====
    
    
    @PostMapping("/addModel")
    public Model addModel(String model){
        Model newModel = new Model();
        newModel.setVehicleModel(model);

        //return daoModel.addModel(newModel);
        return service.addModel(newModel);
    }
    
    //=====Specials Methods =====
    
    @PostMapping("/addSpecial")
    public Special addSpecial(LocalDate start, LocalDate end, String discount){
        Special newSpecial = new Special();
        /////Setters
        //
        //
        //
        //return daoSpecials.addSpecial(newSpecial);
        return service.addSpecial(newSpecial);
    }
    
    @DeleteMapping("/removeSpecial/{id}")
    public ResponseEntity<Special> delete(@PathVariable int id) {
        //if(daoSpecials.removeSpecial(id)) {
        if(service.removeSpecial(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    //=====Reports methods=====
    
    @PostMapping("addVehicle")
    public Vehicle addVehicle(int modelId, String vehicleType, String bodyStyle,
            int vehicleYear,String transmission, String colour, int mileage, String vin, 
            String msrp, String salesPrice, String vehicleDesc, String saleStatus, int specialId){
        
        System.out.println("HI");
        
        Vehicle newVehicle = new Vehicle();
        
        newVehicle.setModelID(modelId);
        newVehicle.setVehicleType(vehicleType);
        newVehicle.setBodyStyle(bodyStyle);
        newVehicle.setVehicleYear(vehicleYear);
        newVehicle.setTransmission(transmission);
        newVehicle.setColour(colour);
        newVehicle.setMileage(mileage);
        newVehicle.setVin(vin);
        newVehicle.setMsrp(msrp);
        newVehicle.setSalesPrice(salesPrice);
        newVehicle.setVehicleDesc(vehicleDesc);
        newVehicle.setSalesPrice(saleStatus);
        newVehicle.setSpecialID(specialId);
        
        
        //return daoVehicle.addVehicle(newVehicle);
        return service.addVehicle(newVehicle);
    }
    
    @PutMapping("editVehicle/{id}")
    public ResponseEntity update(@PathVariable int vehicleId, 
            @RequestBody Vehicle vehicle) {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if(vehicleId != vehicle.getVehicleID()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        //} else if (daoVehicle.updateVehicle(vehicle)) {
        } else if (service.updateVehicle(vehicle)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
    
    @PutMapping("remoVehicle/{id}")
    public boolean removeVehicle(@PathVariable int vehicleId) {
        return service.removeVehicle(vehicleId);
    }
    
    @GetMapping("/getVehiclesSold")
    public List<Vehicle> getAllVehiclesSold(){
        //return daoVehicle.getAllVehiclesSold();
        return service.getAllVehiclesSold();
    }
    
    @GetMapping("/getAllUsedVehicles")
    public List<Vehicle> getAllUsedVehicles(){
        //return daoVehicle.getUsedVehicles();
        return service.getUsedVehicles();
    }
    
    @GetMapping("/getAllNewVehicles")
    public List<Vehicle> getAllNewVehicles(){
        //return daoVehicle.getNewVehicles();
        return service.getNewVehicles();
    }
    
    @GetMapping("/getAllNewVehicles/MSRP")
    public List<Vehicle> getAllNewVehiclesByMSRP(){
        //return daoVehicle.getNewVehiclesByMSRP();
        return service.getNewVehiclesByMSRP();
    }
    
}
