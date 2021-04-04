package bookstoreapp;

//import bookstoreapp.fxmlData.checkoutScene.fxml;
import java.io.IOException;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;
import java.util.ArrayList;
import java.util.List;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class CustomerSceneController implements Initializable {

    @FXML public Label welcomeLabel;
    @FXML Button logoutButton;
    @FXML Button pointPurchaseButton;
    @FXML Button cashPurchaseButton;

    @FXML public ListView bookListView;
    private Customer currentCustomer = null;
    editBook bookEditor = new editBook();
    editCart cart = new editCart();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookListView.setCellFactory(CheckBoxListCell.forListView(new Callback<Book, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(Book book) {
                return null; 
            }
        }
        ));
        bookEditor.loadBooks();
        refresh();
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

    private void refresh(){ //refreshes listviews within the admin screen
        bookListView.getItems().clear();
        for (Book b:bookEditor.getBooks()
        ) {
            bookListView.getItems().add(b);
        }
        bookListView.refresh();
        System.out.println("Refreshing books");
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
        welcomeLabel.setText("Welcome " + currentCustomer.getUsername() + ". You have: " + currentCustomer.getPoints() + " points. Your status is: " + currentCustomer.customerStatus(currentCustomer.getPoints()));
    }
    
    private void addCart(){
        List<Book> selectedItems = bookListView.getSelectionModel().getSelectedItems();
        cart.addToCart(selectedItems);
        for (Book selectedItem : selectedItems) {
            System.out.println(selectedItem);
        }
    }
    
    public void goToCheckout(ActionEvent e)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxmlData/checkoutScene.fxml"));
        Parent checkoutSceneRoot = loader.load();
        cashPurchaseButton.getScene().setRoot(checkoutSceneRoot);
        addCart();
        
        CheckoutSceneController controller = loader.getController();
        controller.initCart(cart.getTotalPrice());
        int x = (int) (cart.getTotalPrice() * 10);
        currentCustomer.setPoints(x);
        controller.initCustomer(currentCustomer);
    }
    
    public void redeemPointCheckout(ActionEvent e)throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxmlData/checkoutScene.fxml"));
        Parent checkoutSceneRoot = loader.load();
        pointPurchaseButton.getScene().setRoot(checkoutSceneRoot);
        addCart();
        CheckoutSceneController controller = loader.getController();
        cart.getTotalPrice();
        controller.initCart(cart.redeemPoints());
        controller.initCustomer(currentCustomer);
    }}
