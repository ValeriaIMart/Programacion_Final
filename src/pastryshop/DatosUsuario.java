package pastryshop;


import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pccas
 */
public class DatosUsuario {

    public ArrayList MisClientes;

    DatosUsuario() {
        MisClientes = new ArrayList();
    }

    public int getBuscarCor(String Cor) {
        int i;
        Usuario auxE = null;
        for (i = 0; i < MisClientes.size(); i++) {
            auxE = (Usuario) MisClientes.get(i);
            if (auxE.correo.equals(Cor)) { 
                return i; }
        } return -1;}
    
    
   // Método para agregar un producto
    public void setAddUsuarios( String nombre, String numero, String direccion, String correo,String contraseña,String rol) {
        if (nombre.isEmpty() || numero.isEmpty()) {
            mostrarAlerta("Todos los campos deben estar llenos.");
        } else {
            int bus = getBuscarCor(correo);
            if (bus != -1) {
                mostrarAlerta("El Usuario ya está registrado.");
            } else {
                Usuario usuarios = new Usuario( nombre, numero, direccion, correo,contraseña,rol);
                MisClientes.add(usuarios);
                mostrarAlerta("Usuario agregado correctamente.");
            }
        }
    }

    // Método para obtener los productos como lista
    public List<Usuario> getMisUsuarios() {
        return MisClientes;
    }

    // Método para convertir los productos en un ObservableList
    public ObservableList<Usuario> getProductosObservable() {
        return FXCollections.observableArrayList(MisClientes);
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
    