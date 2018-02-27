/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.GUI.Controller;

import attauto.BE.Days;
import attauto.BE.Students;
import attauto.model.ModelManager;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atilk
 */
public class SelectStudentViewController implements Initializable {

    @FXML
    private Label NameLabel;
    @FXML
    private Label MostMissedLabel;
    @FXML
    private Label PercLabel;
    @FXML
    private JFXButton CloseButton;
    @FXML
    private TableView<Days> StudentTable;
    @FXML
    private TableColumn<Days, String> DateCol;
    @FXML
    private TableColumn<Days, String> StatusCol;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    private String studentid="";
    ModelManager Mmanager = new ModelManager();
    private int waspresent = 0;
    private int allDays = 0;
    private int max=0;
    String[] Skip = new String[5];
    int[] WeekDays = new int[5];
    String mostSkippedResult="";
    
    public void setID (String id) throws IOException
    {
        this.studentid=id;
        DateCol.setCellValueFactory(new PropertyValueFactory("date"));
        StatusCol.setCellValueFactory(new PropertyValueFactory("status"));
        setName();
        loadDays();
        setPerc(id);
        checkForSkippedDay(0);
    }
    public void setName() throws IOException
    {
        for (Students student : Mmanager.getStudents())
        {
            if(student.getID().equals(studentid))
                NameLabel.setText(student.getName());
        }
    }
    @FXML
    public void close()
    {
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();
    }
    private void loadDays() throws IOException
    {
        StudentTable.getItems().clear();
        for(Days day: Mmanager.getDays(studentid))
        {
            StudentTable.getItems().add(day);
        }
    }
    private void setPerc(String id) throws IOException
    {
        
        for (Days day: Mmanager.getDays(id))
        {
            allDays++;
            if (day.getStatus().equals("Present"))
            {
                waspresent++;
            }
        }
        PercLabel.setText(""+(waspresent*100/allDays+" %"));
    }
        private void setDaysInWeek()
    {
        Skip[0]="Monday";
        Skip[1]="Tuesday";
        Skip[2]="Wednesday";
        Skip[3]="Thursday";
        Skip[4]="Friday";
        max=0;
        for(int i=0;i<5;i++)
        {
            WeekDays[i]=0;
        }
    }
      private void checkForSkippedDay(int dayNumber)
    {

        if(dayNumber==2)
            WeekDays[0]++;
        else if(dayNumber==3)
            WeekDays[1]++;
        else if(dayNumber==4)
            WeekDays[2]++;
        else if(dayNumber==5)
            WeekDays[3]++;
        else if(dayNumber==6)
            WeekDays[4]++;

        for (int i = 0; i < 5; i++)
        {
            if (WeekDays[i] > max)
            {
                max =WeekDays[i];
            }
        }
        mostSkippedResult = Skip[max];
        MostMissedLabel.setText(mostSkippedResult);
    }
}
