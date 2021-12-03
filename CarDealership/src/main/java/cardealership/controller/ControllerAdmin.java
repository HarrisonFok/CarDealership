/*
*   Joshua Martel
*   jophmartel@gmail.com
*   
*
*/

package cardealership.controller;

import cardealership.dao.DaoContact;
import cardealership.dao.DaoContactImpl;
import cardealership.dao.DaoMake;
import cardealership.dao.DaoMakeImpl;
import cardealership.dao.DaoModel;
import cardealership.dao.DaoModelImpl;
import cardealership.dao.DaoSales;
import cardealership.dao.DaoSalesImpl;
import cardealership.dao.DaoSpecials;
import cardealership.dao.DaoSpecialsImpl;
import cardealership.dao.DaoUsers;
import cardealership.dao.DaoUsersImpl;
import cardealership.dao.DaoVehicle;
import cardealership.dao.DaoVehicleImpl;
import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Special;
import cardealership.dto.User;
import cardealership.dto.Vehicle;
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
@RequestMapping("/dealership") //gtn stands for "Guess The Number"
@ComponentScan(basePackageClasses = DaoContactImpl.class)
@ComponentScan(basePackageClasses = DaoMakeImpl.class)
@ComponentScan(basePackageClasses = DaoModelImpl.class)
@ComponentScan(basePackageClasses = DaoSalesImpl.class)
@ComponentScan(basePackageClasses = DaoSpecialsImpl.class)
@ComponentScan(basePackageClasses = DaoUsersImpl.class)
@ComponentScan(basePackageClasses = DaoVehicleImpl.class)
public class ControllerAdmin {
    
    @Autowired
    private final DaoContact daoContact;
    @Autowired
    private final DaoMake daoMake;
    @Autowired
    private final DaoModel daoModel;
    @Autowired
    private final DaoSales daoSales;
    @Autowired
    private final DaoSpecials daoSpecials;
    @Autowired
    private final DaoUsers daoUsers;
    @Autowired
    private final DaoVehicle daoVehicle;
    
    public ControllerAdmin(DaoContact daoContact, DaoMake daoMake,
            DaoModel daoModel, DaoSales daoSales, DaoSpecials daoSpecials,
            DaoUsers daoUsers, DaoVehicle daoVehicle){
        this.daoContact = daoContact;
        this.daoMake = daoMake;
        this.daoModel = daoModel;
        this.daoSales = daoSales;
        this.daoSpecials = daoSpecials;
        this.daoUsers = daoUsers;
        this.daoVehicle = daoVehicle;
    }
    
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return daoUsers.getAllUsers();
    }
    
    @PostMapping("/addUser")
    public User addUser(String firsName, String lastName, String userName,
            String password, String role){
        User newUser = new User();
        //setters here
        //*
        //*
        //*
        return daoUsers.addUser(newUser);
    }
    
    @PutMapping("editUser/{id}")
    public ResponseEntity update(@PathVariable int userId, 
            @RequestBody User user) {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if(userId != user.getId()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (daoUsers.updateUser(user)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
    
    @PostMapping("/changePassword")
    public String changePassword(int userId, String password){
        User user = daoUsers.getUser(userId);
        user.setPasswrod(password);
        daoUsers.updateUserPassword(user);
        return "Password changed";
    }
    
    //====Make Methods====
    
    @PostMapping("/addMake")
    public Make addMake(String make, int modelId){
        Make newMake = new Make();
        
        newMake.setModelID(modelId);
        newMake.setVehicleMake(make);
        return daoMake.addMake(newMake);
    }
    
    //====Model Methods====
    
    
    @PostMapping("/addModel")
    public Model addModel(String model){
        Model newModel = new Model();
        newModel.setVehicleModel(model);

        return daoModel.addModel(newModel);
    }
    
    //=====Specials Methods =====
    
    @PostMapping("/addSpecial")
    public Special addSpecial(LocalDate start, LocalDate end, String discount){
        Special newSpecial = new Special();
        /////Setters
        //
        //
        //
        return daoSpecials.addSpecial(newSpecial);
    }
    
    @DeleteMapping("/removeSpecial/{id}")
    public ResponseEntity<Special> delete(@PathVariable int id) {
        if(daoSpecials.removeSpecial(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    //=====Reports methods=====
    
    
    
    
    @PostMapping("/addVehicle")
    public Vehicle addVehicle(String make, String vehicleType, String bodyStyle,
            int vehicleYear,String transmission, String colour, int mileage, String vin, 
            String msrp, String salesPrice, String vehicleDesc, String saleStatus){
        Vehicle newVehicle = new Vehicle();
        
        //setters here
        //*
        //*
        //*
        
        return daoVehicle.addVehicle(newVehicle);
    }
    
    @PutMapping("editVehicle/{id}")
    public ResponseEntity update(@PathVariable int vehicleId, 
            @RequestBody Vehicle vehicle) {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if(vehicleId != vehicle.getId()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (daoVehicle.updateVehicle(vehicle)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
    
    @GetMapping("/getVehiclesSold")
    public List<Vehicle> getAllVehiclesSold(){
        return daoVehicle.getAllVehiclesSold();
    }
    
    @GetMapping("/getAllUsedVehicles")
    public List<Vehicle> getAllUsedVehicles(){
        return daoVehicle.getUsedVehicles();
    }
    
    @GetMapping("/getAllNewVehicles")
    public List<Vehicle> getAllNewVehicles(){
        return daoVehicle.getNewVehicles();
    }
    
    @GetMapping("/getAllNewVehicles/MSRP")
    public List<Vehicle> getAllNewVehiclesByMSRP(){
        return daoVehicle.getNewVehiclesByMSRP();
    }
    
}
