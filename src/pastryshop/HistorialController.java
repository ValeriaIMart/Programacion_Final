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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author pccas
 */
public class HistorialController implements Initializable {
  @FXML
    private DatosProductos datosp;
   @FXML
    private Button btn_atras;
 
  @FXML
    private TextArea textArea;
  
      @FXML
    private Button btn_produ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          datosp = new DatosProductos();
    }    
          @FXML
    public void archivo(){
        
    datosp.getInfoArchivo(textArea);
    }
    
     @FXML
    private void Open_Dashboard(ActionEvent event) throws IOException {
          try {
            // Cargar el archivo FXML del DashboardAdmin
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Crear una nueva ventana para DashboardAdmin
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Dashboard ");
            stage.show();

            // Cerrar la ventana actual
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("No se pudo abrir el Dashboard Admin. Verifica el archivo FXML y el controlador.");
        }      
        
    }
      // Método para mostrar errores
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
}
