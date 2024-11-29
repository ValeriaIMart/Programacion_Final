/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;


public class RegisterController {
    
    

    @FXML
    private TextField txt_newUsuario;
    @FXML
    private PasswordField txt_newPassword;
    
    @FXML
    private TextField txt_phone;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_Direccion;
   
    
       @FXML
    private void Open_Dashboard(ActionEvent event) throws IOException {
        /*Abrir una ventana*/
        Stage stage3 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage3.setScene(scene2);
         stage3.initStyle(StageStyle.UNDECORATED);
        stage3.setTitle("Dashboard");
        stage3.show();

        /*Cerrar la ventana*/
      Node source2 = (Node) event.getSource();
      Stage stage = (Stage) source2.getScene().getWindow();
      stage.close();

    }
    
}
            
                