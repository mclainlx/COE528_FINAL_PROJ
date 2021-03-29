/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author danielkhan
 */
public class BookStoreApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxmlData/logInScene.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false); //makes main window not resizable
        stage.setTitle("Book Store App");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/book.png")));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
