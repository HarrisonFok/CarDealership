package cardealership.dto;

import java.util.Objects;

/**
 *
 * @author Harrison Fok
 */
public class Model {
    
    private int modelID;
    private String vehicleModel;

    public Model(){
        
    }
    
    public Model(int modelID, String vehicleModel) {
        this.modelID = modelID;
        this.vehicleModel = vehicleModel;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.modelID;
        hash = 41 * hash + Objects.hashCode(this.vehicleModel);
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
        final Model other = (Model) obj;
        if (this.modelID != other.modelID) {
            return false;
        }
        if (!Objects.equals(this.vehicleModel, other.vehicleModel)) {
            return false;
        }
        return true;
    }
    
    
}
