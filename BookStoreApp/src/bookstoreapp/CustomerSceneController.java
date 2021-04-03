package bookstoreapp;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerSceneController implements Initializable {

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
