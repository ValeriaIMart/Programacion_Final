/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisController {

    @FXML
    private Button btn_registrarse;

    @FXML
    private TextField txt_password2;

    @FXML
    private TextField txt_usuario;

    @FXML
    private TextField txt_usuario1;

    @FXML
    private TextField txt_usuario2;

    @FXML
    private TextField txt_usuario3;

    @FXML
    private TextField txt_usuario4;
    
     @FXML
     private void Open_Login2(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage3=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage3.setScene(scene);
        stage3.setTitle("Login");
        stage3.show();
        
        /*Cerrar la centana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }

}
