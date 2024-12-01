/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

import java.io.*;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;


public class DatosProductos {

   
    private NodoProducto cabeza;
    private NodoProducto cola;

    // Pila de productos
    private Stack<Productos> pilaProductos;

    public DatosProductos() {
        cabeza = null;
        cola = null;
        pilaProductos = new Stack<>();
    }

    // Nodo 
    private class NodoProducto {
        Productos producto;
        NodoProducto siguiente;
        NodoProducto anterior;

        NodoProducto(Productos producto) {
            this.producto = producto;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    // Método para buscar 
    public int getBuscarCor(int id) {
        NodoProducto actual = cabeza;
        int i = 0;
        while (actual != null) {
            if (actual.producto.id == id) {
                return i;
            }
            actual = actual.siguiente;
            i++;
        }
        return -1;
    }

   
    public void setAddProductos(int id, String nombre, String descrip, double precio, int cantidad) {
        if (nombre.isEmpty() || descrip.isEmpty()) {
            mostrarAlerta("Todos los campos deben estar llenos.");
        } else {
            int bus = getBuscarCor(id);
            if (bus != -1) {
                mostrarAlerta("El producto ya está registrado.");
            } else {
                Productos producto = new Productos(id, nombre, descrip, precio, cantidad);
                NodoProducto nuevoNodo = new NodoProducto(producto);
                
                if (cabeza == null) {
                    cabeza = nuevoNodo;
                    cola = nuevoNodo;
                } else {
                    cola.siguiente = nuevoNodo;
                    nuevoNodo.anterior = cola;
                    cola = nuevoNodo;
                }
                mostrarAlerta("Producto agregado correctamente.");
            }
        }
    }

 
    public void setAddProductoPila(int id, String nombre, String descrip, double precio, int cantidad) {
        Productos producto = new Productos(id, nombre, descrip, precio, cantidad);
        pilaProductos.push(producto); // Agregar a la pila
        mostrarAlerta("Producto agregado a la pila.");
    }


    public ObservableList<Productos> getProductosObservable() {
        ObservableList<Productos> listaObservable = FXCollections.observableArrayList();
        NodoProducto actual = cabeza;
        while (actual != null) {
            listaObservable.add(actual.producto);
            actual = actual.siguiente;
        }
        return listaObservable;
    }

    
    public Productos getProductos(int idx) {
        NodoProducto actual = cabeza;
        int i = 0;
        while (actual != null) {
            if (i == idx) {
                return actual.producto;
            }
            actual = actual.siguiente;
            i++;
        }
        return null;
    }

   
    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

   
    public void setRegistrarArchivo() {
        try (FileWriter fichero = new FileWriter("DatosProductos.txt");
             PrintWriter pw = new PrintWriter(fichero)) {

            if (cabeza == null) {
                pw.println("Lista de productos vacía.");
            } else {
                NodoProducto actual = cabeza;
                while (actual != null) {
                    Productos producto = actual.producto;
                    pw.println("Codigo: " + producto.id + "\n" + "Nombre: " + producto.nombre + "\n" +
                            "Descripcion: " + producto.descrip + "\n" + "Precio: " +
                            producto.precio + "\n" + "Cantidad: " + producto.cantidad + "\n" +
                            "Total: " + producto.getTotal() + "\n" + "=================================\n");
                    actual = actual.siguiente;
                }
            }

            mostrarAlerta("Datos guardados en el archivo.");
        } catch (IOException e) {
            mostrarAlerta("Error al guardar el archivo: " + e.getMessage());
        }
    }

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

    public void getInfoAll() {
        if (cabeza == null) {
            mostrarAlerta("Lista de productos vacía.");
        } else {
            StringBuilder info = new StringBuilder();
            NodoProducto actual = cabeza;
            while (actual != null) {
                Productos producto = actual.producto;
                info.append("ID: ").append(producto.id).append("\n");
                info.append("Nombre: ").append(producto.nombre).append("\n");
                info.append("Descripción: ").append(producto.descrip).append("\n");
                info.append("Precio: ").append(producto.precio).append("\n");
                info.append("Cantidad: ").append(producto.cantidad).append("\n");
                info.append("=================================\n");
                actual = actual.siguiente;
            }
            mostrarAlerta(info.toString());
        }
    }

    public void eliminarProductoPorId(int id) {
        NodoProducto actual = cabeza;
        while (actual != null) {
            if (actual.producto.id == id) {
                if (actual.anterior != null) {
                    actual.anterior.siguiente = actual.siguiente;
                } else {
                    cabeza = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                } else {
                    cola = actual.anterior;
                }
                mostrarAlerta("Producto eliminado correctamente.");
                return;
            }
            actual = actual.siguiente;
        }
        mostrarAlerta("Producto no encontrado.");
    }
}