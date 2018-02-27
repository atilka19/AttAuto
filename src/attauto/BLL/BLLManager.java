/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.BLL;

import attauto.BE.Days;
import attauto.BE.Students;
import attauto.DB.DALManager;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 *
 * @author atilk
 */
public class BLLManager 
{
    private DALManager manager = new DALManager();
 public ObservableList<Students> getStudents() throws IOException
 {
     return manager.getStudents();
 }
 
  public ObservableList<Days> getAllDay() throws IOException
 {
     return manager.getAllDay();
 }
  public ObservableList <Days> getDays(String id) throws IOException
  {
      return manager.getDays(id);
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
