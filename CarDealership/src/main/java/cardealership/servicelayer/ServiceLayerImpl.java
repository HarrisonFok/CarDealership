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
import org.springframework.beans.factory.annotation.Autowired;
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
    
    
    @Autowired
    private DaoContact daoContact;
    @Autowired
    private DaoMake daoMake;
    @Autowired
    private DaoModel daoModel;
    @Autowired
    private DaoSales daoSales;
    @Autowired
    private DaoSpecials daoSpecials;
    @Autowired
    private DaoUsers daoUsers;
    @Autowired
    private DaoVehicle daoVehicle;
    
    public ServiceLayerImpl(){
        
    }
    
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
        return daoContact.addContact(newContact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return daoContact.getAllContacts();
    }

    @Override
    public boolean editContact(Contact newContact) {
        return daoContact.editContact(newContact);
    }

    @Override
    public Make getMake(int makeId) {
        return daoMake.getMake(makeId);
    }

    @Override
    public List<Make> getAllMakes() {
        return daoMake.getAllMakes();
    }

    @Override
    public Make addMake(Make newMake) {
        return daoMake.addMake(newMake);
    }

    @Override
    public Model getModel(int modelId) {
        return daoModel.getModel(modelId);
    }

    @Override
    public List<Model> getAllModels() {
        return daoModel.getAllModels();
    }

    @Override
    public Model addModel(Model newModel) {
        return daoModel.addModel(newModel);
    }

    @Override
    public Sale addSale(Sale newSale) {
        return daoSales.addSale(newSale);
    }

    @Override
    public List<Sale> getAllSales() {
        return daoSales.getAllSales();
    }

    @Override
    public Sale getSale(int saleId) {
        return daoSales.getSale(saleId);
    }

    @Override
    public Special addSpecial(Special sp) {
        return daoSpecials.addSpecial(sp);
    }

    @Override
    public boolean removeSpecial(int specialId) {
        return daoSpecials.removeSpecial(specialId);
    }

    @Override
    public Special getSpecial(int specialId) {
        return daoSpecials.getSpecial(specialId);
    }

    @Override
    public User addUser(User newUser) {
        return daoUsers.addUser(newUser);
    }

    @Override
    public boolean updateUser(User user) {
        return daoUsers.updateUser(user);
    }

    @Override
    public boolean updateUserPassword(User user) {
        return daoUsers.updateUserPassword(user);
    }

    @Override
    public User getUser(int userId) {
        return daoUsers.getUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return daoUsers.getAllUsers();
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
    public Vehicle getVehicle(int vehicleID){
        return daoVehicle.getVehicle(vehicleID);
    }

    @Override
    public List<Vehicle> getNewVehicles() {
        return daoVehicle.getNewVehicles();
    }

    @Override
    public List<Vehicle> getUsedVehicles() {
        return daoVehicle.getUsedVehicles();
    }

    @Override
    public List<Vehicle> getAllVehiclesSold() {
        return daoVehicle.getAllVehiclesSold();
    }

    @Override
    public List<Vehicle> getAllVehiclesForSale() {
        return daoVehicle.getAllVehiclesForSale();
    }
    
    @Override
    public List<Vehicle> getNewVehiclesByMSRP(String type) {
        return daoVehicle.getNewVehiclesByMSRP(type);
    }
    
    @Override
    public List<Vehicle> getAllVehiclesByModel(int modelId){
        daoVehicle.getAllVehiclesByModel(modelId);
        return daoVehicle.getAllVehiclesByModel(modelId);
    }
    
    @Override
    public List<Vehicle> getAllVehiclesByMake(int makeId){
        return daoVehicle.getAllVehiclesByMake(makeId);
    }
    
    @Override
    public List<Vehicle> getAllVehiclesByYear(int year){
        return daoVehicle.getAllVehiclesByYear(year);
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
//        System.out.println(year);
//        System.out.println(addedVehicle.getVehicleYear());
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
        final String MANUAL = "manual";
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
    
    @Override
    public boolean validPurchaseType(Sale sale){
        if(sale.getPurchaseType().equalsIgnoreCase("Bank Finance")){
            return true;
        }else if(sale.getPurchaseType().equalsIgnoreCase("Cash")){
            return true;
        }else if(sale.getPurchaseType().equalsIgnoreCase("Dealer Finance")){
            return true;
        }
        return false;
    }
    
    @Override
    public boolean validVehicleForSale(int vehicleID){
        Vehicle vec = daoVehicle.getVehicle(vehicleID);
        if(vec.getSalesStatus().equalsIgnoreCase("sold")){
            return false;
        }
        return true;
    }
    
    
    //====Sales Methods====
    @Override
    
    //Get all used and new cars for 
    public List<Vehicle> getInventoryIndex(){
        List<Vehicle> inventory = daoVehicle.getAllVehiclesForSale();
        
        List<Vehicle> inventoryIndex = inventory.stream()
                .filter((s) -> s.getSalesStatus().equalsIgnoreCase("new"))
                .collect(Collectors.toList());
        
        inventoryIndex.addAll(inventory.stream()
                .filter((s) -> s.getSalesStatus().equalsIgnoreCase("used"))
                .collect(Collectors.toList()));
        
        return inventoryIndex;
    }
    
    
    
}
