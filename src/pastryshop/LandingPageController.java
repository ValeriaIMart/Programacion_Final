/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author PCDeveloper
 */
public class LandingPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Button btn_login;
     @FXML
    private Button btn_login_admin;
     @FXML
    private Button btn_exit;
     
    @FXML 
    private Stage stageIni;
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Open_Login(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login");
        stage.show();
        
        /*Cerrar la centana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }
@FXML
    private void Open_loginadm(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("loginadm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("loginadm");
        stage.show();
        
        /*Cerrar la centana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }
    
    
    @FXML
    private void closeAction(ActionEvent event) {
        System.exit(0);
    }
    
    
}
