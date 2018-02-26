/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.model;

import attauto.BE.Students;
import attauto.BLL.BLLManager;
import javafx.collections.ObservableList;

/**
 *
 * @author atilk
 */
public class ModelManager {
    
    private BLLManager manager = new BLLManager();
    
    public ObservableList<Students> getStudents()
    {
        return manager.getStudents();
    }
    
}
