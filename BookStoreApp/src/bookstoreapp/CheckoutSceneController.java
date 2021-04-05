/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import bookstoreapp.Customer;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author Student
 */
public class CheckoutSceneController implements Initializable {
    @FXML public Label totPrice;
    @FXML public Label points;
    @FXML public Label stat;
    @FXML Button logoutButton;

    Customer currentCustomer;
    int bonusPoints;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void onLogout(ActionEvent event) {
    
        try {
            Parent logInSceneRoot = FXMLLoader.load(getClass().getResource("fxmlData/logInScene.fxml"));
            logoutButton.getScene().setRoot(logInSceneRoot);
            logInSceneRoot.getScene().getWindow().sizeToScene();
        }catch (IOException e) {
            System.out.println("failed to load LoginScene fxml file");
            e.printStackTrace();
        }
        
    }    
    
    public void initCart(double d){ //takes price data from cart
        bonusPoints = (int) d * 10;
        String s = Double.toString(d);
        totPrice.setText(s);
        points.setText(Integer.toString(bonusPoints));
    }
    
    public void initCustomer(Customer c){
        currentCustomer = c;
        editCustomer ec = new editCustomer();
        ec.loadCustomers();
        ec.updateCus(c, c.getPoints() + (bonusPoints));

        String s = Integer.toString(c.getPoints());
        //points.setText(s);
        stat.setText(c.customerStatus(c.getPoints()));
    }
    
}
