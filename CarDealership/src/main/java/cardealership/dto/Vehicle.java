package cardealership.dto;

import java.util.Objects;

/**
 *
 * @author Harrison Fok
 */
public class Vehicle {
    
    private int vehicleID;
//    private String make;
    private String vehicleType;
    private String bodyStyle;
    private int vehicleYear;
    private String transmission;
    private String colour;
    private int mileage;
    private String vin;
    private String msrp;
    private String salesPrice;
    private String vehicleDesc;
    private String salesStatus;
    private int specialID;
    private int modelID;
    
    public Vehicle(){
        
    }
    
    public Vehicle(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Vehicle(int vehicleID, String make, String vehicleType, String bodyStyle, int vehicleYear, String transmission, String colour, int mileage, String vin, String msrp, String salesPrice, String vehicleDesc, String salesStatus, int specialID, int modelID) {
        this.vehicleID = vehicleID;
//        this.make = make;
        this.vehicleType = vehicleType;
        this.bodyStyle = bodyStyle;
        this.vehicleYear = vehicleYear;
        this.transmission = transmission;
        this.colour = colour;
        this.mileage = mileage;
        this.vin = vin;
        this.msrp = msrp;
        this.salesPrice = salesPrice;
        this.vehicleDesc = vehicleDesc;
        this.salesStatus = salesStatus;
        this.specialID = specialID;
        this.modelID = modelID;
    }

    public Vehicle(int vehicleID, int modelID, String vehicleType, String bodyStyle, int vehicleYear,
                   String colour, int mileage, String vin, String msrp, String salesPrice, String vehicleDesc,
                   String salesStatus, int specialID, String transmission) {
        this.vehicleID = vehicleID;

        this.vehicleType = vehicleType;
        this.bodyStyle = bodyStyle;
        this.vehicleYear = vehicleYear;
        this.transmission = transmission;
        this.colour = colour;
        this.mileage = mileage;
        this.vin = vin;
        this.msrp = msrp;
        this.salesPrice = salesPrice;
        this.vehicleDesc = vehicleDesc;
        this.salesStatus = salesStatus;
        this.specialID = specialID;
        this.modelID = modelID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

//    public String getMake() {
//        return make;
//    }
//
//    public void setMake(String make) {
//        this.make = make;
//    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }

    public String getSalesStatus() {
        return salesStatus;
    }

    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    public int getSpecialID() {
        return specialID;
    }

    public void setSpecialID(int specialID) {
        this.specialID = specialID;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.vehicleID;
//        hash = 31 * hash + Objects.hashCode(this.make);
        hash = 31 * hash + Objects.hashCode(this.vehicleType);
        hash = 31 * hash + Objects.hashCode(this.bodyStyle);
        hash = 31 * hash + this.vehicleYear;
        hash = 31 * hash + Objects.hashCode(this.transmission);
        hash = 31 * hash + Objects.hashCode(this.colour);
        hash = 31 * hash + this.mileage;
        hash = 31 * hash + Objects.hashCode(this.vin);
        hash = 31 * hash + Objects.hashCode(this.msrp);
        hash = 31 * hash + Objects.hashCode(this.salesPrice);
        hash = 31 * hash + Objects.hashCode(this.vehicleDesc);
        hash = 31 * hash + Objects.hashCode(this.salesStatus);
        hash = 31 * hash + this.specialID;
        hash = 31 * hash + this.modelID;
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
        final Vehicle other = (Vehicle) obj;
        if (this.vehicleID != other.vehicleID) {
            return false;
        }
        if (this.vehicleYear != other.vehicleYear) {
            return false;
        }
        if (this.mileage != other.mileage) {
            return false;
        }
        if (this.specialID != other.specialID) {
            return false;
        }
        if (this.modelID != other.modelID) {
            return false;
        }
//        if (!Objects.equals(this.make, other.make)) {
//            return false;
//        }
        if (!Objects.equals(this.vehicleType, other.vehicleType)) {
            return false;
        }
        if (!Objects.equals(this.bodyStyle, other.bodyStyle)) {
            return false;
        }
        if (!Objects.equals(this.transmission, other.transmission)) {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour)) {
            return false;
        }
        if (!Objects.equals(this.vin, other.vin)) {
            return false;
        }
        if (!Objects.equals(this.msrp, other.msrp)) {
            return false;
        }
        if (!Objects.equals(this.salesPrice, other.salesPrice)) {
            return false;
        }
        if (!Objects.equals(this.vehicleDesc, other.vehicleDesc)) {
            return false;
        }
        if (!Objects.equals(this.salesStatus, other.salesStatus)) {
            return false;
        }
        return true;
    }
    
    
}
