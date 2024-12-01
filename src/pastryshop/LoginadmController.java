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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author pccas
 */
public class LoginadmController implements Initializable {

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
    

 
    
      private DatosUsuario datosU;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         datosU = new DatosUsuario();
          datosU.setAddUsuarioss("Admin"," 3103332810", "calle11", "Admin@ejemplo", "Dios"," Administrador");
        // TODO
    }    

    
    
    @FXML
    private void Open_Dashboard(ActionEvent event) throws IOException {
        
             
        int idx = datosU.getBuscarCor(this.txt_usuario.getText().trim());

    if (idx != -1) { // Si se encuentra el usuario
        Usuario auxven = datosU.getCliente(idx); // Recuperar datos del usuario
    if (auxven.contraseña.equals(this.txt_password.getText()))
        {
            /*Abrir una ventana*/
        Stage stage3 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DashboardAdmin.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage3.setScene(scene2);
         stage3.initStyle(StageStyle.UNDECORATED);
        stage3.setTitle("DashboardAdmin");
        stage3.show();

        /*Cerrar la ventana*/
      Node source2 = (Node) event.getSource();
      Stage stage = (Stage) source2.getScene().getWindow();
      stage.close();

        }
        else
        {
            mostrarAlerta("Usuario o clave incorrecta");

        }    
       

    
    } else { // Si no se encuentra el usuario
       mostrarAlerta( "Todos los campos deben estar llenos"+"  No se encuentra el usuario!");
        
        // Limpiar el campo de texto y devolverle el foco
        this.txt_usuario.setText("");
        this.txt_password.requestFocus();
    }
    
        
    }
    

    // Método para mostrar alertas
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void Salir(ActionEvent event) {
        System.exit(0);
    }
}
   
    

