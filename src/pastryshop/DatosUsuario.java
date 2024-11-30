package pastryshop;


import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    
    
    public void setAddUsuario(
     String nombre,
     String numero,
     String direccion,
     String correo,
     String contraseña,
     String Rol
         
    ) 
    {
//        if (nombre.isEmpty() || numero.isEmpty() || direccion.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || Rol.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
//        } else
// 
//        {
//            int bus = getBuscarCor(correo);
//            if (bus != -1) {
//                JOptionPane.showMessageDialog(null, "El Cliente ya se encuentra registrado! Intente con un valor diferente.");
//            } else {
                Usuario infoF = new Usuario(
                        nombre,
                        numero,
                        direccion,
                        correo,
                        contraseña,
                        Rol
                );
                MisClientes.add(infoF);
                //JOptionPane.showMessageDialog(null, "Nuevo Cliente  registrado a la lista!");

  //  }
   //     }
    } 

    

    public void setDataJTable(JTable jTable1) {
        //Se definen el título de las columnas
        Vector columnas = new Vector();
        columnas.add("Nombres");
        columnas.add("Numero de telefono");
        columnas.add("Direccion");
        columnas.add("Correo");
        columnas.add("Contraseña");
        columnas.add("Rol");

        Vector fila = null;
        Vector tuplas = new Vector();
        int i;
        Usuario aux = null;
        Usuario CLI = null;
      

        for (i = 0; i < MisClientes.size(); i++) {
            aux = (Usuario) MisClientes.get(i);
            fila = new Vector();
           
                CLI = (Usuario) MisClientes.get(i);
                fila.add("" + CLI.nombre);
                fila.add("" + CLI.numero);
                fila.add("" + CLI.direccion);
                fila.add("" + CLI.correo);
                fila.add("" + CLI.contraseña);
                fila.add("" + CLI.Rol);
              

                fila.add(" ");
            
            tuplas.add(fila);
        }

        DefaultTableModel miModelo = new DefaultTableModel(tuplas, columnas);
        jTable1.setModel(miModelo);
    }

    public Usuario getCliente(int idx) {
        Usuario aux = null;
        aux = (Usuario) MisClientes.get(idx);
        return aux;
    }
    



} 
    