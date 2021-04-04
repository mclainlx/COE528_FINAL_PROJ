/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp.fxmlData;

import bookstoreapp.Customer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Student
 */
public class CheckoutSceneController implements Initializable {
    @FXML public Label totPrice;
    @FXML public Label points;
    @FXML public Label stat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void initCart(double d){ //takes price data from cart
        String s = Double.toString(d);
        totPrice.setText(s);
       
    }
    
    public void initCustomer(Customer c){
        String s = Integer.toString(c.getPoints());
        points.setText(s);
        stat.setText(c.customerStatus(c.getPoints()));
    }
    
}
