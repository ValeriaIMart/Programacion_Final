package pastryshop;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pccas
 */
public class DatosUsuario {

    public ArrayList <Usuario >MisClientes;

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
    
     // Método para agregar un producto
    public void setAddUsuarioss( String nombre, String numero, String direccion, String correo,String contraseña,String rol) {
    
            int bus = getBuscarCor(correo);
            if (bus != -1) {
                mostrarAlerta("El Usuario ya está registrado.");
            } else {
                Usuario usuarios = new Usuario( nombre, numero, direccion, correo,contraseña,rol);
                MisClientes.add(usuarios);
               
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
    
    
    public Usuario getCliente(int idx) {
        Usuario aux = null;
        aux = (Usuario) MisClientes.get(idx);
        return aux;
    }
    


     // Método para cargar usuarios desde un archivo
    public void cargarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader("c:/Prueba/usuarios.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 6) {
                    Usuario usuario = new Usuario(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
                    MisClientes.add(usuario);
                }
            }
            mostrarAlerta("Usuarios cargados correctamente.");
        } catch (IOException e) {
            mostrarAlerta("Error al cargar los usuarios: " + e.getMessage());
        }
    }

    // Método para guardar usuarios en un archivo
    public void guardarUsuarios() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("c:/Prueba/usuarios.txt"))) {
            if (MisClientes.isEmpty()) {
                pw.println("Lista de usuarios vacía.");
            } else {
                for (Usuario usuario : MisClientes) {
                    pw.println(usuario.nombre + "," +
                            usuario.numero + "," +
                            usuario.direccion + "," +
                            usuario.correo + "," +
                            usuario.contraseña + "," +
                            usuario.Rol);
                }
            }
            mostrarAlerta("Usuarios guardados correctamente.");
        } catch (IOException e) {
            mostrarAlerta("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    // Método para mostrar todos los usuarios
    public void mostrarUsuarios() {
        if (MisClientes.isEmpty()) {
            mostrarAlerta("No hay usuarios registrados.");
            return;
        }

        StringBuilder mensaje = new StringBuilder();
        for (Usuario usuario : MisClientes) {
            mensaje.append("Nombre: ").append(usuario.nombre).append("\n");
            mensaje.append("Número: ").append(usuario.numero).append("\n");
            mensaje.append("Dirección: ").append(usuario.direccion).append("\n");
            mensaje.append("Correo: ").append(usuario.correo).append("\n");
            mensaje.append("Rol: ").append(usuario.Rol).append("\n");
            mensaje.append("=================================\n");
        }
        mostrarAlerta(mensaje.toString());
    }
}
    