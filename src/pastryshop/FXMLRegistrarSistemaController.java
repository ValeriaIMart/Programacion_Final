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
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author pccas
 */
public class FXMLRegistrarSistemaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    
    
    
    @FXML
    private Button btn_ar;
      
    
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_numero;
    @FXML
    private TextField txt_direccion;
    @FXML
    private TextField txt_correo;
    
   @FXML
    private TextField txt_contraseña;
    @FXML
    private TextField txt_rol;
    
      @FXML
    private Button btn_aceptar;
      
         @FXML
    private Button btn_cancelar;
      
    private DatosUsuario datosU;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         datosU = new DatosUsuario();
  // Cargar los datos iniciales en el TableView
       
    }  
    
 @FXML
    private void AGU(ActionEvent event)throws IOException {
      
            
            // Leer valores de los campos de texto
            String nombre = txt_nombre.getText().trim();
            String numero = txt_numero.getText().trim();
            String direccion = txt_direccion.getText().trim();
            String correo = txt_correo.getText().trim();
            String contraseña = txt_contraseña.getText().trim();
            String rol = txt_rol.getText().trim();
            // Validar campos vacíos
            if (nombre.isEmpty() || numero.isEmpty()) {
                mostrarError("Por favor, llena todos los campos.");
                return;
            }

            // Agregar producto a la lista
            datosU.setAddUsuarios( nombre, numero, direccion, correo,contraseña,rol);

            // Confirmar y actualizar la tabla
            mostrarMensaje("Usuario agregado correctamente.");
    
       Stage stage4 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage4.setScene(scene2);
        stage4.initStyle(StageStyle.UNDECORATED);
        stage4.setTitle("Dashboard");
        stage4.show();

        /*Cerrar la ventana*/
      Node source2 = (Node) event.getSource();
      Stage stage = (Stage) source2.getScene().getWindow();
      stage.close();
    }

    
     // Método para limpiar los campos después de agregar un producto
    private void limpiarCampos() {
        
        txt_nombre.clear();
        txt_numero.clear();
        txt_direccion.clear();
        txt_correo.clear();
        txt_contraseña.clear();
        txt_rol.clear();
    }
   
      
      // Método para mostrar mensajes de éxito
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
 
    // Método para mostrar errores
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
@FXML
private void archivo(){
datosU.guardarUsuarios();

}
    
 
}
