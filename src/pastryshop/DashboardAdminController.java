/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
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
        datosp = new DatosProductos();
         inicializarTablaProductos();
    } 
    
      @FXML
    private void Open_Pedido(ActionEvent event) {
        abrirVentana(event, "PedidoAdministrativo.fxml", "PedidoAdministrativo");
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
    @FXML
    private TextArea textArea;
    @FXML
    private Button btn_produ;
    @FXML
    private DatosProductos datosp;
    
    @FXML 
     private TableColumn<Productos, Integer> clm_codigo;
    @FXML
    private TableColumn<Productos, String> clm_nombre;
    @FXML
    private TableColumn<Productos, String> clm_descrip;
    @FXML
    private TableColumn<Productos, Double> clm_precio;
    @FXML 
    private TableColumn<Productos, Integer> clm_cantidad;
    
     @FXML
    private TableView<Productos> tbl_productos;

    
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

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
     private ObservableList<Productos> productosList;
        @FXML
    public void archivo(){
        
    datosp.getInfoArchivo(textArea);
    }
    

    
   private void inicializarTablaProductos() {
     clm_codigo.setCellValueFactory(new PropertyValueFactory<>("Id"));
    clm_nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    clm_descrip.setCellValueFactory(new PropertyValueFactory<>("descrip"));
    clm_precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
    clm_cantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

    // Crear la lista inicial de productos
  
    productosList = FXCollections.observableArrayList(
        new Productos(1, "Torta infantil león", "Infantiles", 50000, 10),
        new Productos(5, "Torta infantil tigre", "Infantiles", 60000, 8),
        new Productos(15, "Torta infantil hello Kitty", "Infantiles", 55000, 15),
        new Productos(12, "Torta infantil arcoíris", "Infantiles", 50000, 12),
        new Productos(5, "Torta de boda 2 pisos glam", "Bodas", 120000, 5),
        new Productos(7, "Torta de boda 2 pisos", "Bodas", 100000, 7),
        new Productos(10, "Torta de boda redonda", "Bodas", 70000, 10),
        new Productos(8, "Torta de boda corazón", "Bodas", 50000, 8),
        new Productos(9, "Torta de cumpleaños caballero", "Cumpleaños", 60000, 9),
        new Productos(11, "Torta de cumpleaños para dama", "Cumpleaños", 40000, 11),
        new Productos(6, "Torta de cumpleaños para dama", "Cumpleaños", 70000, 6),
        new Productos(8, "Torta de cumpleaños para dama", "Cumpleaños", 60000, 8),
        new Productos(5, "Torta de halloween", "Temporada", 80000, 5),
        new Productos(10, "Torta de amor y amistad", "Temporada", 60000, 10),
        new Productos(8, "Torta de navidad", "Temporada", 70000, 8),
        new Productos(7, "Torta de fin de año", "Temporada", 90000, 7)
    ); 
        // Asociar la lista con la tabla
    tbl_productos.setItems(productosList);
}
}