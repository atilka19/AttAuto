/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.GUI.Controller;

import attauto.BE.Students;
import attauto.model.ModelManager;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atilk
 */
public class TeacherViewController implements Initializable {

    @FXML
    private TableView<Students> StudentTable;
    @FXML
    private ImageView Logo;
    @FXML
    private JFXButton LogOutButton;
    @FXML
    private Label CurrentDate;
    @FXML    
    private TableColumn<Students, String> NameCol;
    @FXML
    private TableColumn<Students, String> AttendanceCol;
    @FXML
    private TableColumn<Students, String> PercCol;
    @FXML
    private TableColumn<Students, String> MostMissedDayCol;
        
        
    ModelManager Mmanager = new ModelManager();
    Date Date = new Date();
    DateFormat dateFormatterFull = new SimpleDateFormat("dd/MM/yyyy");



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDate();
        try {
            loadStudents();
        } catch (IOException ex) {
            Logger.getLogger(TeacherViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        NameCol.setCellValueFactory(new PropertyValueFactory("name"));
        AttendanceCol.setCellValueFactory(new PropertyValueFactory("attendance"));
        PercCol.setCellValueFactory(new PropertyValueFactory("percantage"));
        MostMissedDayCol.setCellValueFactory(new PropertyValueFactory("mostmissedday"));
    }
    private void setDate ()
    {
             CurrentDate.setText(" "+dateFormatterFull.format(Date));
    }

    @FXML
    public void LogOut () throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/attauto/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) LogOutButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void ifAttendance(Students student)
    {
        if(student.getAttendance().equals("FALSE"))
            {
                student.setAttendance("Absent");
                StudentTable.getItems().add(student);
            }
            else if(student.getAttendance().equals("TRUE"))
                    {
                     student.setAttendance("Present");
                StudentTable.getItems().add(student);   
                    }
            else
            {
             StudentTable.getItems().add(student);   
            }
    }
    private void loadStudents() throws IOException {
        StudentTable.getItems().clear();
        for(Students student : Mmanager.getStudents())
        {
            ifAttendance(student);
        }
    
}
}
