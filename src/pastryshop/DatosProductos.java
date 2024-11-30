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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    
    public void setAddProductos(
    
    int id,
    String nombre,
    String descrip,
    double precio,
    int cantidad,
    String foto
         
    ) {
       if (nombre.isEmpty() || descrip.isEmpty()) { JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos."); } else
 
        {
            int bus = getBuscarCor(id);
            if (bus != -1) {
                JOptionPane.showMessageDialog(null, "El Cliente ya se encuentra registrado! Intente con un valor diferente.");
            } else {
                Productos infoF = new Productos(
                        id,
                        nombre,
                        descrip,
                        precio,
                        cantidad,
                        foto
                        
                );
                MisProductos.add(infoF);
                JOptionPane.showMessageDialog(null, "Nuevo Cliente  registrado a la lista!");

    }
        }
    } 

    

    public void setDataJTable(JTable jTable1) {
        //Se definen el título de las columnas
        Vector columnas = new Vector();
        columnas.add("Id");
        columnas.add("Nombre");
        columnas.add("Descripcion");
        columnas.add("precio");
        columnas.add("cantidad");
        columnas.add("foto");


        Vector fila = null;
        Vector tuplas = new Vector();
        int i;
        Productos aux = null;
        Productos CLI = null;
      

        for (i = 0; i < MisProductos.size(); i++) {
            aux = (Productos) MisProductos.get(i);
            fila = new Vector();
           
                CLI = (Productos) MisProductos.get(i);
                fila.add("" + CLI.id);
                fila.add("" + CLI.nombre);
                fila.add("" + CLI.descrip);
                fila.add("" + CLI.precio);
                fila.add("" + CLI.cantidad);
                 fila.add("" + CLI.foto);
              

                fila.add(" ");
            
            tuplas.add(fila);
        }

        DefaultTableModel miModelo = new DefaultTableModel(tuplas, columnas);
        jTable1.setModel(miModelo);
    }

    public Productos getProductos(int idx) {
        Productos aux = null;
        aux = (Productos) MisProductos.get(idx);
        return aux;
    }
    
    
     
     
     
     
     
     
     
     
}
