/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author danielkhan
 */
public class FXMLDocumentController implements Initializable {

    @FXML Button logInButton;
    @FXML TextField userTextField;
    @FXML PasswordField passTextField;
    @FXML Label badLoginLabel;


    @FXML
    private void onLogin(ActionEvent event) {
        System.out.println("Loggin in");
        badLoginLabel.setVisible(false);

        String user, pass;

        user = userTextField.getText();//getting username and password
        pass = passTextField.getText();

        if(user.equals("admin") && pass.equals("admin")){
            //set to admin scene
            System.out.println("loggin in as admin");
        }else{
            if(customerLogin(user, pass)){
                //set scene to customer scene
                System.out.println("logging in as customer");
            }else{
                badLoginLabel.setVisible(true);
            }
        }

    }

    private boolean customerLogin(String user, String pass){
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
