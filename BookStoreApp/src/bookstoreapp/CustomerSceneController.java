package bookstoreapp;

import java.io.IOException;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class CustomerSceneController implements Initializable {
    
    @FXML Button logoutButton;
    @FXML Button pointPurchaseButton;
    @FXML Button cashPurchaseButton;

    @FXML public ListView bookListView;
    private Customer currentCustomer = null;
    editBook bookEditor = new editBook();

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
    }
}
