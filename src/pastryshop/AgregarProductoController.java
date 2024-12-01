/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * FXML Controller class
 *
 * @author eveli
 */
public class AgregarProductoController implements Initializable {
   @FXML
    private TextField txt_codigo;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextArea txt_descripcion;
    @FXML
    private TextField txt_valor;
    @FXML
    private TextField txt_cantidad;
    @FXML
    private Button btn_Agregar;
    
    @FXML
    private Button btn_archivo;
    @FXML
    private TableView<Productos> tableProductos;
    @FXML
    private TableColumn<Productos, Integer> colId;
    @FXML
    private TableColumn<Productos, String> colNombre;
    @FXML
    private TableColumn<Productos, String> colDescripcion;
    @FXML
    private TableColumn<Productos, Double> colPrecio;
    @FXML
    private TableColumn<Productos, Integer> colCantidad;

    private DatosProductos datosp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          datosp = new DatosProductos();

        // Configurar las columnas del TableView
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descrip"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        // Cargar los datos iniciales en el TableView
        actualizarTabla();
    }  
       @FXML
    private TextArea textArea;
    @FXML
    private Button btn_archi; 
       
       
     @FXML
    private void AGP(ActionEvent event) {
        try {
            // Leer valores de los campos de texto
            int id = Integer.parseInt(txt_codigo.getText().trim());
            String nombre = txt_nombre.getText().trim();
            String descripcion = txt_descripcion.getText().trim();
            double precio = Double.parseDouble(txt_valor.getText().trim());
            int cantidad = Integer.parseInt(txt_cantidad.getText().trim());

            // Validar campos vacíos
            if (nombre.isEmpty() || descripcion.isEmpty()) {
                mostrarError("Por favor, llena todos los campos.");
                return;
            }

            // Agregar producto a la lista
            datosp.setAddProductos(id, nombre, descripcion, precio, cantidad);

            // Confirmar y actualizar la tabla
            mostrarMensaje("Producto agregado correctamente.");
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarError("Error en los datos ingresados: Verifica que los números sean válidos.");
        }
    }

    // Método para actualizar el TableView con los datos de DatosProductos
    private void actualizarTabla() {
        ObservableList<Productos> productos = datosp.getProductosObservable();
        tableProductos.setItems(productos);
    }

    // Método para limpiar los campos después de agregar un producto
    private void limpiarCampos() {
        txt_codigo.clear();
        txt_nombre.clear();
        txt_descripcion.clear();
        txt_valor.clear();
        txt_cantidad.clear();
    }
    
        // Método para mostrar mensajes de éxito
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
  
     @FXML
    private void Open_DashboardAdmin(ActionEvent event) throws IOException {
          try {
            // Cargar el archivo FXML del DashboardAdmin
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DashboardAdmin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Crear una nueva ventana para DashboardAdmin
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Dashboard Admin");
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
     @FXML
    public void archivo(){
    
    datosp.setRegistrarArchivo();
    }
    
      @FXML
    public void archivo2(){
        
    datosp.getInfoArchivo(textArea);
    }
    

}