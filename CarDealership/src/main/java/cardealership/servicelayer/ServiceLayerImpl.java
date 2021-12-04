/*
*   Joshua Martel
*   jophmartel@gmail.com
*   
*
*/

package cardealership.servicelayer;

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
import cardealership.dto.Contact;
import cardealership.dto.Make;
import cardealership.dto.Model;
import cardealership.dto.Sale;
import cardealership.dto.Special;
import cardealership.dto.User;
import cardealership.dto.Vehicle;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 *
 * @author Joshua Martel
 */
@Service
@ComponentScan(basePackageClasses = DaoContactImpl.class)
@ComponentScan(basePackageClasses = DaoMakeImpl.class)
@ComponentScan(basePackageClasses = DaoModelImpl.class)
@ComponentScan(basePackageClasses = DaoSalesImpl.class)
@ComponentScan(basePackageClasses = DaoSpecialsImpl.class)
@ComponentScan(basePackageClasses = DaoUsersImpl.class)
@ComponentScan(basePackageClasses = DaoVehicleImpl.class)
public class ServiceLayerImpl implements ServiceLayer {
    
    private DaoContact daoContact;
    private DaoMake daoMake;
    private DaoModel daoModel;
    private DaoSales daoSales;
    private DaoSpecials daoSpecials;
    private DaoUsers daoUsers;
    private DaoVehicle daoVehicle;
    
    public ServiceLayerImpl(DaoContact daoContact, DaoMake daoMake,
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

    @Override
    public Contact addContact(Contact newContact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getAllContacts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editContact(Contact newContact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Make getMake(int makeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Make> getAllMakes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Make addMake(Make newMake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model getModel(int modelId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Model> getAllModels() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model addModel(Model newModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    @Override
    public Special addSpecial(Special sp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeSpecial(int specialId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Special getSpecial(int specialId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User addUser(User newUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUserPassword(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehicle addVehicle(Vehicle newVehicle) {
        return daoVehicle.addVehicle(newVehicle);
    }

    @Override
    public boolean removeVehicle(int vehicleId) {
        return daoVehicle.removeVehicle(vehicleId);
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        return daoVehicle.updateVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getNewVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getNewVehiclesByMSRP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getUsedVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getAllVehiclesSold() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicle> getAllVehiclesForSale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //====Business-Logic Methods====
    //Find sales between dates
    //either-or start and end can be null
    @Override
    public List<Sale> getSalesInRange(LocalDate start, LocalDate end){
        List<Sale> allSales = daoSales.getAllSales();
        List<Sale> salesReport = allSales.stream()
                .filter((s) -> s.getSaleDate().compareTo(start) > 0 
                                &&
                               s.getSaleDate().compareTo(end)   < 0)
                .collect(Collectors.toList());
        return salesReport;
    }
    
    //Find sales between dates and associated with user
    //either-or start and end can be null
    @Override
    public List<Sale> getSalesInRangeAndUser(LocalDate start, LocalDate end, 
            User user){
        List<Sale> salesByUser = getSalesInByUser(user);
        List<Sale> filterSaleList = getSalesInRange(start,end);
        return filterSaleList;
    }
    
    //Search for sales related by user
    @Override
    public List<Sale> getSalesInByUser(User user){
        List<Sale> sales = daoSales.getAllSales();
        List<Sale> saleByUser = sales.stream()
                .filter((s) -> s.getUserID() == user.getUserID())
                .collect(Collectors.toList());
        return saleByUser;
        
        
    }
    
    //simply returns sum of sales given
    @Override
    public BigDecimal totalNumberOfSales(List<Sale> sales){
        BigDecimal sum = new BigDecimal("0.0");
        BigDecimal pPrice;
        for(int i = 0; i < sales.size(); i++){
            pPrice = new BigDecimal(sales.get(i).getPurchasePrice());
            sum.add(pPrice);
        }
        sum.setScale(2, RoundingMode.HALF_UP);
        return sum;
    }
    
    //WIll return a string with total number of vehicles sold,
    // as well as how many of each model and make
    @Override
    public List<String> totalNumberOfVehiclesSold(List<Sale> sales){
        List<Model> allModels = daoModel.getAllModels();
        //get total amount of vehicles sold
        int totalSold = sales.size();
        String info = Integer.toString(totalSold);
        //Create array to hold all info
        List<String> fullInfo = new ArrayList();
        Map<String, Integer> amountModelsSold = new HashMap();
        
        //Initialise map
        for(Model m: allModels){
                amountModelsSold.put(m.getVehicleModel(), 0);
        }
        
        fullInfo.add("Total vehicles sold: " + info);
        
        for(Sale s: sales){
            Vehicle tempV = daoVehicle.getVehicle(s.getVehicleID());
            for(Model m: allModels){
                //If model ids are the same add that to number of models sold
                //in map
                if(tempV.getModelID() == m.getModelID()){
                    int amount = amountModelsSold.get(m.getVehicleModel()) + 1;
                    amountModelsSold.put(m.getVehicleModel(), amount);
                }
            }
        }
        
        Set<String> keyValues = amountModelsSold.keySet();
        for(String key: keyValues){
            info = "";
            info = "Model: " + key + " - Sold: " + amountModelsSold.get(key);
            fullInfo.add(info);
        }
        return fullInfo;
    }
    
    //cheks if purchase price is no less than 95% of sale price
    // and purchase price is no larger than MSRP
    @Override
    public String checkIfValidPurchasePrice(Sale newSale, Vehicle boughtVehicle){
        BigDecimal ninetyFivePercent = new BigDecimal("0.95");
        BigDecimal salePrice = new BigDecimal(boughtVehicle.getSalesPrice());
        BigDecimal purchasePrice = new BigDecimal(newSale.getPurchasePrice());
        BigDecimal msrp = new BigDecimal(boughtVehicle.getMsrp());
        
        if(purchasePrice.compareTo(salePrice.multiply(ninetyFivePercent)) < 0){
            return "Error: purchase price is less than 95% of sale price";
        }else if(purchasePrice.compareTo(msrp) > 0){
            return "Error: purchase price is no larger than MSRP.\n" +
                    "purchase price: " + newSale.getPurchasePrice() +
                    "\n MSRP: " + boughtVehicle.getMsrp();
        }
        
        return "Sale is valid";
    }
    
    //tests if zip is 5 digits
    @Override
    public boolean validZip(Sale newSale){
        int zip = newSale.getZipCode();
        if(zip > 99999){
            return false;
        }else if(zip < 1000){
            return false;
        }
        return true;
    }
    
    //Checks if year of vehicle is within 2000 - this year + 1;
    @Override
    public boolean validYear(Vehicle addedVehicle){
        int year = Year.now().getValue();
        if(addedVehicle.getVehicleYear() < 2000){
            return false;
        }else if(addedVehicle.getVehicleYear() > year + 1){
            return false;
        }
        return true;
    }
    
    //Checks if transmission type is valid
    @Override
    public boolean validTransmission(Vehicle addedVehicle){
        final String AUTO = "automatic";
        final String MANUAL = "manul";
        if(AUTO.equalsIgnoreCase(addedVehicle.getTransmission())){
            return true;
        }else if(MANUAL.equalsIgnoreCase(addedVehicle.getTransmission())){
            return true;
        }
        return false;
    }
    
    //checks if vehicle is new
    //can only be new if mileage is less than 1000
    @Override
    public boolean validNewVehicle(Vehicle newVehicle){
        final String NEW = "new";
        final String USED = "used";
        int mileage = newVehicle.getMileage();
        if(mileage > 1000){
            return false;
        }
        return true;
    }
    
    //Checks if sale price is less-than/equal-to msrp
    @Override
    public boolean validSalePrice(Vehicle newVehicle){
        BigDecimal salesPrice = new BigDecimal(newVehicle.getSalesPrice());
        BigDecimal msrp = new BigDecimal(newVehicle.getMsrp());
        if(salesPrice.compareTo(msrp) > 0){
            return false;
        }
        return true;
    }
    
    //Checks that email is in a valid fotmat
    //This code is from an internet source: 
    //https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
    @Override
    public boolean validEmail(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    
//    //Checks that email is in a valid fotmat
//    @Override
//    public boolean validEmail(User newUser){
//        
//    }
//    //Checks that email is in a valid fotmat
//    @Override
//    public boolean validEmail(Sale newSale){
//        
//    }
}
