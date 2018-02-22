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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    Date Date = new Date();
    DateFormat dateFormatterFull = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setDate();
    }    
    private void setDate ()
    {
             CurrentDate.setText(" "+dateFormatterFull.format(Date));
    }
    public void LogOut () throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("/attauto/GUI/View/Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) LogOutButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
