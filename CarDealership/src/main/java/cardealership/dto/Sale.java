package cardealership.dto;

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
    
    public Sale() {
        
    }

    public Sale(int saleID, String email, String phone, String street, int zipCode, String purchasePrice, String purchaseType, int userID, int vehicleID) {
        this.saleID = saleID;
        this.email = email;
        this.phone = phone;
        this.street = street;
        this.zipCode = zipCode;
        this.purchasePrice = purchasePrice;
        this.purchaseType = purchaseType;
        this.userID = userID;
        this.vehicleID = vehicleID;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.saleID;
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.phone);
        hash = 53 * hash + Objects.hashCode(this.street);
        hash = 53 * hash + this.zipCode;
        hash = 53 * hash + Objects.hashCode(this.purchasePrice);
        hash = 53 * hash + Objects.hashCode(this.purchaseType);
        hash = 53 * hash + this.userID;
        hash = 53 * hash + this.vehicleID;
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
        return true;
    }
    
    
}
