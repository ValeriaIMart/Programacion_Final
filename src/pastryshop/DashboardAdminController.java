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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author pccas
 */
public class DashboardAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
 @FXML
    private void Open_AgregarProducto(ActionEvent event) {
        abrirVentana(event, "AgregarProducto.fxml", "Agregar Producto");
    }

    @FXML
    private void Open_Seguridad(ActionEvent event) {
        abrirVentana(event, "Seguridad.fxml", "Seguridad");
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }
    
     private void abrirVentana(ActionEvent event, String fxmlFile, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(title);
            stage.show();

            // Cerrar la ventana actual
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("No se pudo abrir la ventana: " + title);
        }
    }

    @FXML
    private void Open_PedidoAdministrativo(ActionEvent event) {
        try {
            // Cargar el archivo FXML para la ventana de pedidos
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PedidoAdministrativo.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Crear la nueva ventana
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Pedidos Administrativos");
            stage.show();

            // Cerrar la ventana actual
            Node source = (Node) event.getSource();
            Stage currentStage = (Stage) source.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarError("No se pudo abrir la ventana de pedidos administrativos.");
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
