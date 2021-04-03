/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author danielkhan
 */
public class logInSceneController implements Initializable {

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

            try { //try to load adminScene fxml file, if it fails then print out error and stuff
                Parent adminSceneRoot = FXMLLoader.load(getClass().getResource("fxmlData/adminScene.fxml"));
                logInButton.getScene().setRoot(adminSceneRoot); //set the scene to the new scene or if failed to load, don't switch scene
                adminSceneRoot.getScene().getWindow().sizeToScene();//resizes window to scene size
            }catch (IOException e) {
                System.out.println("error: failed to load adminScene fxml file");
                e.printStackTrace();
            }

            System.out.println("logging in as admin");
        }else{
            Customer currentCustomer;
            if((currentCustomer = customerLogin(user, pass)) != null){
                //set scene to customer scene

                try { //try to load adminScene fxml file, if it fails then print out error and stuff
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlData/customerScene.fxml"));
                    Parent customerSceneRoot = loader.load();
                    logInButton.getScene().setRoot(customerSceneRoot); //set the scene to the new scene or if failed to load, don't switch scene
                    CustomerSceneController c = (CustomerSceneController) loader.getController();
                    c.setCurrentCustomer(currentCustomer);
                    customerSceneRoot.getScene().getWindow().sizeToScene();//resizes window to scene size
                }catch (IOException e) {
                    System.out.println("failed to load customerScene fxml file");
                    e.printStackTrace();
                }

                System.out.println("logging in as customer");
            }else{
                badLoginLabel.setVisible(true);
            }
        }

    }

    private Customer customerLogin(String user, String pass){
        editCustomer ec = new editCustomer();
        ec.loadCustomers();

        for (Customer c:ec.getCustomers()
             ) {
            if(c.getUsername().equals(user) && c.getPassword().equals(pass)){
                return c;
            }
        }

        return null;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
