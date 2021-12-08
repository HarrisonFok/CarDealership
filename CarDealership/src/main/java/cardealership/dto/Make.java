package cardealership.dto;

import java.util.Objects;

/**
 *
 * @author Harrison Fok
 */
public class Make {
    
    public Make(){
        
    }
    
    private int makeID;
    private String vehicleMake;
//    private int modelID;

    public int getMakeID() {
        return makeID;
    }

    public Make(int makeID, String vehicleMake) {
        this.makeID = makeID;
        this.vehicleMake = vehicleMake;
    }

    public void setMakeID(int makeID) {
        this.makeID = makeID;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

//    public int getModelID() {
//        return modelID;
//    }
//
//    public void setModelID(int modelID) {
//        this.modelID = modelID;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.makeID;
        hash = 53 * hash + Objects.hashCode(this.vehicleMake);
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
        final Make other = (Make) obj;
        if (this.makeID != other.makeID) {
            return false;
        }
        if (!Objects.equals(this.vehicleMake, other.vehicleMake)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Make{" + "makeID=" + makeID + ", vehicleMake=" + vehicleMake + '}';
    }

   
}
