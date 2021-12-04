package cardealership.dto;

import java.util.Objects;

/**
 *
 * @author Harrison Fok
 */
public class Contact {
    
    private int contactID;
    private String contactName;
    private String message;
    private String email;
    private String phone;
    private int vehicleID;
    
    public Contact() {
        
    }
    
    public Contact(String contactName) {
        this.contactName = contactName;
    }
    
    public Contact(String contactName, String message, String email, String phone, int vehicleID) {
        this.contactName = contactName;
        this.message = message;
        this.email = email;
        this.phone = phone;
        this.vehicleID = vehicleID;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.contactID;
        hash = 23 * hash + Objects.hashCode(this.contactName);
        hash = 23 * hash + Objects.hashCode(this.message);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.phone);
        hash = 23 * hash + this.vehicleID;
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
        final Contact other = (Contact) obj;
        if (this.contactID != other.contactID) {
            return false;
        }
        if (this.vehicleID != other.vehicleID) {
            return false;
        }
        if (!Objects.equals(this.contactName, other.contactName)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }
}

