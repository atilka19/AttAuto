/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attauto.GUI.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author atilk
 */
public class LoginController implements Initializable {
    

    @FXML
    private ImageView Logo;
    @FXML
    private JFXPasswordField PasswordtxtField;
    @FXML
    private JFXTextField UsertxtField;
    @FXML
    private JFXButton LoginButton;
    @FXML
    private AnchorPane root;
    @FXML
    private Label nonoLabel;
    @FXML
    private JFXButton ExitButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        AnchorPane root = new AnchorPane();
        root.setId("AnchorPane");
    }

    private void login(Event event) throws IOException //Checks who is trying to log-in tells the user if login failed
    {
        if((UsertxtField.getText().equals("AttilaR")&&PasswordtxtField.getText().equals("aztamindenit"))
                || (UsertxtField.getText().equals("ViktorH")&&PasswordtxtField.getText().equals("marxwasokiguess")))
        {
            setScene("Student",event);
        }
        else if (UsertxtField.getText().equals("Teacher")&&PasswordtxtField.getText().equals("javafxrulez"))
        {
            setScene("Teacher",event);
        }
        else 
        {
            nonoLabel.setVisible(true);
        }
    }
    @FXML
    private void LoginClicked (ActionEvent event) //Handles the "Login" Button
    {
        try 
        {
          login(event);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void onEnter(ActionEvent event) throws IOException
    {
           login(event); 
    }
    
    private void setScene(String view,Event event) throws IOException //Setting the scene in regard of who logged in
    {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent Root = FXMLLoader.load(getClass().getResource("/attauto/GUI/View/"+view+"View.fxml"));
        Scene scene = new Scene (Root);
        stage.setScene(scene);
        stage.setTitle(view);
        stage.show();
    }
    @FXML
    private void Exit ()
    {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
}
