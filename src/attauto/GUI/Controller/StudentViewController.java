/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.GUI.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author atilk
 */
public class StudentViewController implements Initializable {

    @FXML
    private TableView<?> StudentTable;
    @FXML
    private ImageView Logo;
    @FXML
    private Label CurrentDate;
    @FXML
    private JFXButton LogOutButton;
    
    Date DateF = new Date();
    Date DateM = new Date();
    DateFormat dateFormatterFull = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dateFormatterMonth = new SimpleDateFormat("MM");
    private String[] months = new String [12];
    private int t;
    @FXML
    private ComboBox<?> monthsBox;
    @FXML
    private JFXButton CommitButton;
    @FXML
    private Label CommitLabel;
    @FXML
    private Label CommittedLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDate();
        setMonths();
    }    
    private void setDate ()
    {
             CurrentDate.setText(" "+dateFormatterFull.format(DateF));
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
    @FXML
    public void Commit ()
    {
        CommittedLabel.setVisible(true);
        CommitLabel.setVisible(false);
        CommitButton.setVisible(false);
        
    }
    public void setMonths()
    {
        t =Integer.parseInt(dateFormatterMonth.format(DateM))-1;
        months[0]="January";
        months[1]="February";
        months[2]="March";
        months[3]="April";
        months[4]="May";
        months[5]="June";
        months[6]="July";
        months[7]="August";
        months[8]="September";
        months[9]="October";
        months[10]="November";
        months[11]="December";
        //monthsBox.setItems(months);
    }
}
