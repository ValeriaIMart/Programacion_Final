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
 * @author pccas
 */
public class SeguridadController implements Initializable {

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
    private TableView<Usuario> tableUsuario;
    @FXML
    private TableColumn<Usuario, String> colNombre;
    @FXML
    private TableColumn<Usuario, String> colNumero;
    @FXML
    private TableColumn<Usuario, String> colDireccion;
    @FXML
    private TableColumn<Usuario, String> colCorreo;
    @FXML
    private TableColumn<Usuario, String> colContraseña;
    @FXML
    private TableColumn<Usuario, String> colRol;

    private DatosUsuario datosU;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         datosU = new DatosUsuario();

        // Configurar las columnas del TableView
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colNumero.setCellValueFactory(new PropertyValueFactory<>("Numero"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        colContraseña.setCellValueFactory(new PropertyValueFactory<>("Contraseña"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("Rol"));

        // Cargar los datos iniciales en el TableView
        actualizarTabla();
    }  
    
    @FXML
    private void AGU(ActionEvent event) {
        try {
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
            mostrarMensaje("Producto agregado correctamente.");
            actualizarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarError("Error en los datos ingresados: Verifica que los números sean válidos.");
        }
    }
    
     // Método para actualizar el TableView con los datos de DatosProductos
    private void actualizarTabla() {
        ObservableList<Usuario> usuario = datosU.getProductosObservable();
        tableUsuario.setItems(usuario);
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
    

  
   

}
