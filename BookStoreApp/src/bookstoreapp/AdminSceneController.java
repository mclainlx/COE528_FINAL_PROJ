package bookstoreapp;

import java.io.IOException;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

public class AdminSceneController implements Initializable {


    @FXML public ListView customerListView;
    @FXML public ListView bookListView;
    @FXML public TextField titleTextField;
    @FXML public TextField priceTextField;
    @FXML Button logoutButton1;
    @FXML Button logoutButton2;
    @FXML public TextField customerUser;
    @FXML public TextField customerPass;

    editBook bookEditor;
    editCustomer customerEditor;

    @FXML
    private void onLogout(ActionEvent event) {
    
            try {
                Parent logInSceneRoot = FXMLLoader.load(getClass().getResource("fxmlData/logInScene.fxml"));
                logoutButton1.getScene().setRoot(logInSceneRoot); //set the scene to the new scene or if failed to load, don't switch scene
                logInSceneRoot.getScene().getWindow().sizeToScene();//resizes window to scene size
                logoutButton2.getScene().setRoot(logInSceneRoot); //set the scene to the new scene or if failed to load, don't switch scene
                logInSceneRoot.getScene().getWindow().sizeToScene();//resizes window to scene size
            }catch (IOException e) {
                System.out.println("failed to load LoginScene fxml file");
                e.printStackTrace();
            }
    
    
    }
    @FXML
    private void refresh(){ //refreshes listviews within the admin screen
        bookListView.getItems().clear();
        for (Book b:bookEditor.getBooks()
        ) {
            bookListView.getItems().add(b);
        }
        customerListView.refresh();
        bookListView.refresh();
        System.out.println("Refreshing books and customers");
    }

    @FXML
    private void addBook(ActionEvent e){ //adds a book using the EditBook object that we declared earlier
        String title = titleTextField.getText();
        if(isDouble(priceTextField.getText())){
            bookEditor.addBook(title, Double.parseDouble(priceTextField.getText()));
            refresh();
            System.out.println("Adding a book");
        }else{
            System.out.println("could not add book - price is bad");
        }
    }

    boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @FXML
    private void removeBook(ActionEvent event){
        List<Book> selectedItems = new ArrayList<>(bookListView.getSelectionModel().getSelectedItems());
        bookListView.getItems().removeAll(selectedItems);
        bookEditor.removeBook(selectedItems);
        refresh();
    }

    @FXML
    public void editBook(ActionEvent e){
        Book b = (Book) bookListView.getSelectionModel().getSelectedItem();
        priceTextField.setText(Double.toString(b.getPrice()));
        titleTextField.setText(b.getTitle());
    }
    
        @FXML
    private void addCustomer(ActionEvent e){
        String userName = customerUser.getText();
        String password = customerPass.getText();
        customerEditor.addCustomer(userName, password);
        refresh();
    }
    
    @FXML
    public void removeCustomer(ActionEvent event){
        List<Customer> selectedItems = new ArrayList(customerListView.getSelectionModel().getSelectedItems());
        customerListView.getItems().removeAll(selectedItems);
        customerEditor.removeCustomer(selectedItems);
        refresh();
    }
    
    @FXML
    public void editCustomer(ActionEvent e){
        Customer c = (Customer) customerListView.getSelectionModel().getSelectedItem();
        customerUser.setText(c.getUsername());
        customerPass.setText(c.getPassword());
    }

    @FXML
    public void applyEdit(ActionEvent e){
        Book b = (Book) bookListView.getSelectionModel().getSelectedItem();
        if(isDouble(priceTextField.getText())){
            b.setPrice(Double.parseDouble(priceTextField.getText()));
            b.setTitle(titleTextField.getText());
            bookEditor.saveChanges();
            refresh();
        }else{
            System.out.println("bad price");
        }
        
        Customer c = (Customer) customerListView.getSelectionModel().getSelectedItem();
        c.setUsername(customerUser.getText());
        c.setPassword(customerPass.getText());
        customerEditor.saveChangesCus();
        refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookEditor = new editBook();
        bookEditor.loadBooks();
        for (Book b:bookEditor.getBooks()
             ) {
            bookListView.getItems().add(b);
        }
        
        customerEditor = new editCustomer();
        customerEditor.loadCustomers();
        for (Customer c:customerEditor.getCustomers()){
            customerListView.getItems().add(c);
        }
    }
}
