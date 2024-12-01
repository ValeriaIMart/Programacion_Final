/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;


    
 import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;


/**
 * Clase para manejar datos de productos.
 */
public class DatosProductos {

    private ArrayList<Productos> misProductos;

    public DatosProductos() {
        misProductos = new ArrayList<>();
    }

    // Método para buscar un producto por ID
    public int getBuscarCor(int id) {
        for (int i = 0; i < misProductos.size(); i++) {
            if (misProductos.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }

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
                misProductos.add(producto);
                mostrarAlerta("Producto agregado correctamente.");
            }
        }
    }

    // Método para obtener los productos como lista
    public List<Productos> getMisProductos() {
        return misProductos;
    }

    // Método para convertir los productos en un ObservableList
    public ObservableList<Productos> getProductosObservable() {
        return FXCollections.observableArrayList(misProductos);
    }

    // Método para obtener un producto específico
    public Productos getProductos(int idx) {
        return misProductos.get(idx);
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    
    // Método para guardar productos en un archivo
    public void setRegistrarArchivo() {
        try (FileWriter fichero = new FileWriter("DatosProductos.txt");
             PrintWriter pw = new PrintWriter(fichero)) {

            if (misProductos.isEmpty()) {
                pw.println("Lista de productos vacía.");
            } else {
                for (Productos producto : misProductos) {
                    pw.println("Codigo: "+producto.id + "\n" + "Nombre: "+ producto.nombre + "\n" +"Descripcion: "+ producto.descrip + "\n" +"Precio: "+
                            producto.precio + "\n"+"Cantidad: "+ producto.cantidad +"\n"+"Total: "+ producto.getTotal()+"\n"+("=================================\n"));
                }
            }

            mostrarAlerta("Datos guardados en el archivo.");
        } catch (IOException e) {
            mostrarAlerta("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Método para leer información desde un archivo
    public void getInfoArchivo(TextArea textArea) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("DatosProductos.txt"))) {
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            textArea.setText(contenido.toString());
        } catch (IOException e) {
            mostrarAlerta("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para mostrar información de todos los productos
    public void getInfoAll() {
        if (misProductos.isEmpty()) {
            mostrarAlerta("Lista de productos vacía.");
        } else {
            StringBuilder info = new StringBuilder();
            for (Productos producto : misProductos) {
                info.append("ID: ").append(producto.id).append("\n");
                info.append("Nombre: ").append(producto.nombre).append("\n");
                info.append("Descripción: ").append(producto.descrip).append("\n");
                info.append("Precio: ").append(producto.precio).append("\n");
                info.append("Cantidad: ").append(producto.cantidad).append("\n");
                info.append("=================================\n");
            }
            mostrarAlerta(info.toString());
        }
    }
    
    // Método para eliminar un producto por ID
public void eliminarProductoPorId(int id) {
    int indice = getBuscarCor(id); // Buscar el índice del producto por ID
    if (indice != -1) {
        misProductos.remove(indice); // Eliminar el producto de la lista
        mostrarAlerta("Producto eliminado correctamente.");
    } else {
        mostrarAlerta("Producto no encontrado.");
    }
}

}