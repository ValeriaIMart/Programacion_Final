package pastryshop;


import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*

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
            if (auxE.correo.equals(Cor)) { // Cambio de getId() a getCor() 
                return i; }
        } return -1;}

    public void setAddCliente(
            int idcliente,
            String nombre,
            int numero,
             String direccion,
            String Correo,
            String contraseña
         
    ) {
 
        {
            int bus = getBuscarCor(Correo);
            if (bus != -1) {
                JOptionPane.showMessageDialog(null, "El Cliente ya se encuentra registrado! Intente con un valor diferente.");
            } else {
                Cliente infoF = new Cliente(
                        idcliente,
                        nombre,
                        numero,
                        direccion,
                        Correo,
                        contraseña
                );
                MisClientes.add(infoF);
                JOptionPane.showMessageDialog(null, "Nuevo Cliente  registrado a la lista!");

    }
        }
    } 

    public void setAddAdministrativo(
            int idadministrativo,
            String nombre,
            int numero,
             String direccion,
            String Correo,
            String contraseña) {

        int bus = getBuscarCor(Correo);
            if (bus != -1) {
            JOptionPane.showMessageDialog(null,
                    "El idCliente ya se encuentra registrado! "
                    + "Intente con un valor diferente.");
        } else {
            Administrativo infoF = new Administrativo(
                      idadministrativo,
                        nombre,
                        numero,
                        direccion,
                        Correo,
                        contraseña
            );
            MisClientes.add(infoF);
            JOptionPane.showMessageDialog(null,
                    "Nuevo Cliente de tipo personal registrado a la lista!");
        }

    }

    public void setDataJTable(JTable jTable1) {
        //Se definen el título de las columnas
        Vector columnas = new Vector();
        columnas.add("idEmpleado");
        columnas.add("Nombres");
        columnas.add("Apellido");
        columnas.add("Direccion");
        columnas.add("Ciudad");
        columnas.add("Telefonos");
        columnas.add("TipoCliente");
        columnas.add("Contrato");
        columnas.add("LimiteCredito");
        columnas.add("NumTaejeta");

        Vector fila = null;
        Vector tuplas = new Vector();
        int i;
        Usuario aux = null;
        Cliente CLI = null;
        Administrativo AD = null;

        for (i = 0; i < MisClientes.size(); i++) {
            aux = (Cliente) MisClientes.get(i);
            fila = new Vector();
            if (aux.tipo.equals("Cliente")) {
                CLI = (Cliente) MisClientes.get(i);
                fila.add("" + CLI.nombre);
                fila.add("" + CLI.contraseña);
                fila.add("" + CLI.numero);
                fila.add("" + CLI.direccion);
                fila.add("" + CLI.correo);
                fila.add("" + CLI.idcliente);
                fila.add("" + CLI.tipo);

                fila.add(" ");
            } else {
                AD = (Administrativo) MisClientes.get(i);
                fila.add("" + AD.nombre);
                fila.add("" + AD.contraseña);
                fila.add("" + AD.numero);
                fila.add("" + AD.direccion);
                fila.add("" + AD.correo);
                fila.add("" + AD.idadministrativo);
                fila.add("" + AD.tipo);
                fila.add(" ");
                fila.add(" ");

            }
            tuplas.add(fila);
        }

        DefaultTableModel miModelo = new DefaultTableModel(tuplas, columnas);
        jTable1.setModel(miModelo);
    }

    public Cliente getCliente(int idx) {
        Cliente aux = null;
        aux = (Cliente) MisClientes.get(idx);
        return aux;
    }

}
