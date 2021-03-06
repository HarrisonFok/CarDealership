package cardealership.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Harrison Fok
 */
public class Sale {
    
    private int saleID;
    private String email;
    private String phone;
    private String street;
    private int zipCode;
    private String purchasePrice;
    private String purchaseType;
    private int userID;
    private int vehicleID;
    private LocalDate saleDate;
    
    public Sale(){
        
    }

    public Sale(int saleID, String email, String phone, String street, int zipCode, String purchasePrice, String purchaseType, int userID, int vehicleID, LocalDate saleDate) {
        this.saleID = saleID;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.zipCode = zipCode;
        this.purchasePrice = purchasePrice;
        this.purchaseType = purchaseType;
        this.userID = userID;
        this.vehicleID = vehicleID;
        this.saleDate = saleDate;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
    
    public LocalDate getSaleDate(){
        return saleDate;
    }
    
    public void setSaleDate(LocalDate saleDate){
        this.saleDate = saleDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.saleID;
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.phone);
        hash = 67 * hash + Objects.hashCode(this.street);
        hash = 67 * hash + this.zipCode;
        hash = 67 * hash + Objects.hashCode(this.purchasePrice);
        hash = 67 * hash + Objects.hashCode(this.purchaseType);
        hash = 67 * hash + this.userID;
        hash = 67 * hash + this.vehicleID;
        hash = 67 * hash + Objects.hashCode(this.saleDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sale other = (Sale) obj;
        if (this.saleID != other.saleID) {
            return false;
        }
        if (this.zipCode != other.zipCode) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        if (this.vehicleID != other.vehicleID) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.purchasePrice, other.purchasePrice)) {
            return false;
        }
        if (!Objects.equals(this.purchaseType, other.purchaseType)) {
            return false;
        }
        if (!Objects.equals(this.saleDate, other.saleDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sale{" + "saleID=" + saleID + ", email=" + email + ", phone=" + phone + ", street=" + street + ", zipCode=" + zipCode + ", purchasePrice=" + purchasePrice + ", purchaseType=" + purchaseType + ", userID=" + userID + ", vehicleID=" + vehicleID + ", saleDate=" + saleDate + '}';
    }

    

    
    
    
}
