package cardealership.dto;

import java.util.Objects;

/**
 *
 * @author Harrison Fok
 */
public class Model {
    
    private int modelID;
    private String vehicleModel;
    private int makeID;

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
    
    public int getMakeID(){
        return makeID;
    }
    
    public void setMakeID(int makeID){
        this.makeID = makeID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.modelID;
        hash = 19 * hash + Objects.hashCode(this.vehicleModel);
        hash = 19 * hash + this.makeID;
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
        if (this.makeID != other.makeID) {
            return false;
        }
        if (!Objects.equals(this.vehicleModel, other.vehicleModel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model{" + "modelID=" + modelID + ", vehicleModel=" + vehicleModel + ", makeID=" + makeID + '}';
    }

    
    
    
}
