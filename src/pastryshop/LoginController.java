/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author PCDeveloper
 */

public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txt_usuario;
    @FXML
    private TextField txt_password;
    @FXML
    private Button btn_aceptar;
    @FXML
    private Button btn_cancelar;
    
    @FXML
    private Button btn_registrarse;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void init(String hola, Stage stage, LandingPageController aThis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
       @FXML
    private void Salir(ActionEvent event) {
        System.exit(0);
    }

}
    
