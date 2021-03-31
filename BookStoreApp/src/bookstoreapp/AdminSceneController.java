package bookstoreapp;

import java.io.IOException;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class AdminSceneController implements Initializable {


    @FXML Button logoutButton1;
    @FXML Button logoutButton2;
    
    @FXML
    private void onLogout(ActionEvent event) {
    
    System.out.println("Loggin in");
    
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
  
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
