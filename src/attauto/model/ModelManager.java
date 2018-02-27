/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.model;

import attauto.BE.Days;
import attauto.BE.Students;
import attauto.BLL.BLLManager;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 *
 * @author atilk
 */
public class ModelManager {
    
    private BLLManager manager = new BLLManager();
    
    public ObservableList<Students> getStudents() throws IOException
    {
        return manager.getStudents();
    }
    
    public ObservableList<Days> getAllDay() throws IOException
    {
        return manager.getAllDay();
    }
    
    public void Present() throws IOException
    {
        manager.Present();
    }
    
    public void Absent() throws IOException
    {
        manager.Absent();
    }
    
    
}
