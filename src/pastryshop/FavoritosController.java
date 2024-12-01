/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author pccas
 */
public class FavoritosController implements Initializable {
 private DatosProductos datosp;
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
    
      @FXML
    private TableColumn<Productos, Double> colTotal;
 
    @FXML
    private TextArea tA_Pedido;
    
    @FXML
    private Button btn_atras;
 
    @FXML 
    private Button btn_save;

     @FXML 
    private Button btn_delete;
    
    
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
     @FXML
     private TextField txt_nombre;
    @FXML
    private TextField txt_codigo;
    @FXML
    private TextField txt_descrip;
    @FXML
    private TextField txt_precio;
    @FXML
    private TextField txt_cantidad;

@FXML
    private TextField txt_eliminar;

    private ObservableList<Productos> productosList;
    private int selectedIndex;




    private void resetButtons() {
        txt_codigo.clear();
        txt_nombre.clear();
        txt_descrip.clear();
        txt_precio.clear();
        txt_cantidad.clear();

        btn_save.setDisable(true);
    }

    private void seleccionarProducto() {
        Productos productoSeleccionado = tbl_productos.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            selectedIndex = productosList.indexOf(productoSeleccionado);
            txt_codigo.setText(String.valueOf(productoSeleccionado.getId()));
            txt_nombre.setText(productoSeleccionado.getNombre());
            txt_descrip.setText(productoSeleccionado.getDescrip());
            txt_precio.setText(String.valueOf(productoSeleccionado.getPrecio()));
            txt_cantidad.setText(String.valueOf(productoSeleccionado.getCantidad()));

 
            btn_save.setDisable(false);
        }
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

    // Configurar el evento para seleccionar un producto al hacer clic
    tbl_productos.setOnMouseClicked((MouseEvent event) -> {
        if (event.getClickCount() == 1) {
            seleccionarProducto();
        }
        
        // Configurar la columna Total para que se use el método getTotal de Productos
    colTotal.setCellValueFactory(cellData -> 
        new SimpleDoubleProperty(cellData.getValue().getTotal()).asObject());
    });
    
    
}

  @FXML
    private void AGP(ActionEvent event) {
        try {
            // Leer valores de los campos de texto
              int codigo = Integer.parseInt(txt_codigo.getText().trim());
            String nombre = txt_nombre.getText().trim();
            String descripcion = txt_descrip.getText().trim();
            double precio = Double.parseDouble(txt_precio.getText().trim());
            int cantidad = Integer.parseInt(txt_cantidad.getText().trim());

            // Validar campos vacíos
            if (nombre.isEmpty() || descripcion.isEmpty()) {
                mostrarError("Por favor, llena todos los campos.");
                return;
            }

            // Agregar producto a la lista
            datosp.setAddProductos(codigo, nombre, descripcion, precio, cantidad);

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
        txt_descrip.clear();
        txt_precio.clear();
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
    datosp.getInfoAll();
    datosp.getInfoArchivo(tA_Pedido);
 
    }
    
 
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarTablaProductos();

        datosp = new DatosProductos();
        btn_save.setDisable(true);

        // Configurar las columnas del TableView
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descrip"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));

        // Cargar los datos iniciales en el TableView
        actualizarTabla();
// Crear la lista inicial de productos
    productosList = FXCollections.observableArrayList(
        // Tus productos aquí
    );

    // Asociar la lista con la tabla
    tableProductos.setItems(productosList);
    
    // Resto de la configuración de la tabla...
    }
    
      @FXML
   private void delete() {
    try {
        // Obtener el ID del producto desde el TextField
        int id = Integer.parseInt(txt_eliminar.getText());
        
        // Llamar al método para eliminar el producto
        datosp.eliminarProductoPorId(id);
         actualizarTabla();
    } catch (NumberFormatException e) {
        // Si el ID no es un número válido, mostrar un mensaje de error
        mostrarError("Por favor, ingresa un ID válido.");
    }
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
            mostrarError("No se pudo abrir el Dashboard . Verifica el archivo FXML y el controlador.");
        }      
        
    }
  
  
    
}