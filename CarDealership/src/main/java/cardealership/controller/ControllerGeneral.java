/*
*   Joshua Martel
*   jophmartel@gmail.com
*   
*
*/

package cardealership.controller;

import cardealership.dto.Vehicle;
import cardealership.servicelayer.ServiceLayerImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Joshua Martel
 */
@RestController
@RequestMapping("/dealership/general")
@ComponentScan(basePackageClasses = ServiceLayerImpl.class)
public class ControllerGeneral {
    
    @Autowired
    private ServiceLayerImpl service;
    
    public ControllerGeneral(ServiceLayerImpl service){
        this.service = service;
    }
    
    @GetMapping("/inventoryNew")
    public List<Vehicle> getInventoryNew(){
        return service.getNewVehicles();
    }
    
    @GetMapping("/inventoryUsed")
    public List<Vehicle> getInventoryUsed(){
        return service.getUsedVehicles();
    }
    
    //type can be new or used
    @PostMapping("/invMSPR/{type}")
    public List<Vehicle> getInventoryByMSRP(@PathVariable String type){
        return service.getNewVehiclesByMSRP(type);
    }
    
    @PostMapping("/invModel")
    public List<Vehicle> getInventoryByModal(int modelId){
        return service.getAllVehiclesByModel(modelId);
    }
    
    @PostMapping("/invMake/{makeId}")
    public List<Vehicle> getInventoryByMake(@PathVariable int makeId){
        return service.getAllVehiclesByMake(makeId);
    }
    
    @PostMapping("/invYear/{year}")
    public List<Vehicle> getInventoryByYear(@PathVariable int year){
        return service.getAllVehiclesByYear(year);
    }
    
    
    
}
