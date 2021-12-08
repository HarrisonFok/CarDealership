/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardealership.dao;

import cardealership.dto.Model;
import java.util.List;

/**
 *
 * @author Joshua Martel
 */
public interface DaoModel {
    
    public Model getModel(int modelId);
    
    public List<Model> getAllModels();
    
    public boolean removeModel(int modelID);
    
    public Model addModel(Model newModel);
    
}
