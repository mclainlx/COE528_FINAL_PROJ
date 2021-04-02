package bookstoreapp;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerSceneController implements Initializable {

    private Customer currentCustomer = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }
}
