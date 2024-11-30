/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author pccas
 */
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
/**
 *
 * @author pccas
 */
public class DatosProductos {
     public ArrayList MisProductos;
     
   DatosProductos() {
        MisProductos = new ArrayList();
    }

    public int getBuscarCor(int Id) {
        int i;
        Productos auxE = null;
        for (i = 0; i < MisProductos.size(); i++) {
            auxE = (Productos) MisProductos.get(i);
            if (auxE.id==Id) { 
                return i; }
        } return -1;}
    
    
  // Método para agregar un producto
    public void setAddProductos(int id, String nombre, String descrip, double precio, int cantidad) {
        if (nombre.isEmpty() || descrip.isEmpty()) {
            mostrarAlerta("Todos los campos deben estar llenos.");
        } else {
            int bus = getBuscarCor(id);
            if (bus != -1) {
                mostrarAlerta("El producto ya está registrado.");
            } else {
                Productos producto = new Productos(id, nombre, descrip, precio, cantidad);
                MisProductos.add(producto);
                mostrarAlerta("Producto agregado correctamente.");
            }
        }
    }
    

 // Método para obtener los productos como lista
    public List<Productos> getMisProductos() {
        return MisProductos;
    }

    // Método para convertir los productos en un ObservableList
    public ObservableList<Productos> getProductosObservable() {
        return FXCollections.observableArrayList(MisProductos);
    }

    public Productos getProductos(int idx) {
        Productos aux = null;
        aux = (Productos) MisProductos.get(idx);
        return aux;
    }
    
    
     
    // Método para mostrar alertas
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
     
     
     
     
     
     
     
}
