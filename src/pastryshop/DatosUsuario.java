import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import javafx.scene.control.Alert;
import pastryshop.Usuario;

public class DatosUsuario {

    // Usamos LinkedList para la lista de clientes
    public LinkedList<Usuario> MisClientes;

    // Usamos una pila para gestionar la adición de usuarios
    public Stack<Usuario> pilaUsuarios;

    DatosUsuario() {
        MisClientes = new LinkedList<>();
        pilaUsuarios = new Stack<>();
    }

    public int getBuscarCor(String Cor) {
        int i;
        Usuario auxE = null;
        // Recorremos la LinkedList para buscar el correo
        for (i = 0; i < MisClientes.size(); i++) {
            auxE = MisClientes.get(i);
            if (auxE.correo.equals(Cor)) {
                return i; // Devuelve la posición en la lista
            }
        }
        return -1; // Si no lo encuentra, devuelve -1
    }

    // Método para agregar un usuario
    public void setAddUsuarios(String nombre, String numero, String direccion, String correo, String contraseña, String rol) {
        if (nombre.isEmpty() || numero.isEmpty()) {
            mostrarAlerta("Todos los campos deben estar llenos.");
        } else {
            int bus = getBuscarCor(correo);
            if (bus != -1) {
                mostrarAlerta("El Usuario ya está registrado.");
            } else {
                Usuario usuarios = new Usuario(nombre, numero, direccion, correo, contraseña, rol);
                MisClientes.add(usuarios); // Agregar al final de la LinkedList
                mostrarAlerta("Usuario agregado correctamente.");
            }
        }
    }

    // Método para agregar un usuario a la pila
    public void setAddUsuarioss(String nombre, String numero, String direccion, String correo, String contraseña, String rol) {
        int bus = getBuscarCor(correo);
        if (bus != -1) {
            mostrarAlerta("El Usuario ya está registrado.");
        } else {
            Usuario usuarios = new Usuario(nombre, numero, direccion, correo, contraseña, rol);
            MisClientes.add(usuarios);  // Agregar al final de la LinkedList
            pilaUsuarios.push(usuarios); // También agregamos a la pila
        }
    }

    // Método para obtener los usuarios como lista
    public List<Usuario> getMisUsuarios() {
        return MisClientes;
    }

    // Método para convertir los usuarios en un ObservableList (para uso en JavaFX)
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

    // Método para obtener un cliente por su índice
    public Usuario getCliente(int idx) {
        return MisClientes.get(idx);
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