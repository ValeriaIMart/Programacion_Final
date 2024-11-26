/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SARIC
 */
public class ListaProducto {
    

    Nodo<Productos> cab;

    ListaProducto() {
        cab = null;
    }

    public boolean getEsVacia() {
        return cab == null ? true : false;
    }

    public int getLonglista() {
        if (getEsVacia()) {
            return 0;
        } else {
            Nodo<Productos> p = cab;
            int cont = 0;
            do {
                cont++;
                p = p.sig;
            } while (p != cab);
            return cont;
        }
    }

    public Nodo<Productos> getBuscarProductoporId(int id) {
        if (getEsVacia()) {
            return null;
        } else {
            Nodo<Productos> p = cab;
            do {
                if (p.dato.id == (id)) {
                    return p;
                } else {
                    p = p.sig;
                }
            } while (p != cab);
            return null;
        }
    }
 
 
    public Productos getCrearcupo(
            JTextField jtfid,
            JTextField jtfnom,
            JTextField jtfcant,
             JTextField jtfdescripcion,
               JTextField jtfcat,
             
              JTextField jtfprecio
            
    ) {

        Productos pr = null;
        Nodo<Productos> buscar = null;

        try {
           
            buscar = getBuscarProductoporId(Integer.parseInt(jtfid.getText()));
            if (buscar != null) {
                JOptionPane.showMessageDialog(null,
                        "El ID ya existe, intente nuevamente!");
                return null;
            } else {
              
                pr = new Productos(
                        Integer.parseInt(jtfid.getText()),
                        jtfnom.getText(),
                        Integer.parseInt(jtfcant.getText()),
                       jtfdescripcion.getText(),
                          jtfcat.getText(),
                        Double.parseDouble(jtfprecio.getText())
                ); 

                return pr; 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }
    }

   
    
 

    public Nodo<Productos> getUltimo() {
       if(cab==null)
            return null;
         else {
            Nodo<Productos> p = cab;
            while (p.sig != cab) {
                p = p.sig;
            }
            return p;
        }
    }
    
    public void setADD(
          JTextField jtfid,
            JTextField jtfnom,
            JTextField jtfcant,
             JTextField jtfdescripcion,
               JTextField jtfcat,
             
              JTextField jtfprecio
    ) {
        Productos pr = getCrearcupo(jtfid, jtfnom, jtfcant, jtfdescripcion, jtfcat, jtfprecio);
        if (pr != null) {
            Nodo<Productos> info = new Nodo(pr);
            if (cab == null) {
                cab = info;
                cab.sig = cab;
            } else {
                Nodo<Productos> base = getUltimo();
                info.sig = cab;
                cab = info;
                base.sig = cab;
            }
        }
    }

    public void setPop() {
        if (getEsVacia()) {
            JOptionPane.showMessageDialog(null,
                    "La pila esta vacía!");
        } else {
            if (cab.sig == cab) {
                cab = null;
            } else {
                Nodo<Productos> base = getUltimo();
                Nodo<Productos> e = cab;
                cab = cab.sig;
                base.sig = cab;
                e.sig = null;
                e = null;
                JOptionPane.showMessageDialog(null,
                        "Elemento atendido de la Lista!");
            }
        }
    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int pFila, Nodo<Productos> p) {

        miModelo.setValueAt(p.dato.id, pFila, 0);
        miModelo.setValueAt(p.dato.nombre, pFila, 1);
        miModelo.setValueAt(p.dato.cantidad, pFila, 2);
        miModelo.setValueAt(p.dato.descripcion, pFila, 3);
        miModelo.setValueAt(p.dato.categoria, pFila, 4);
        miModelo.setValueAt(p.dato.precio, pFila, 5);

    }


    public void setLlenarJTable(JTable tab) {
    if (cab == null) { 
        JOptionPane.showMessageDialog(null, "No hay productos en la lista.");
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("Id");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Cantidad");
        miModelo.addColumn("Descripcion");
        miModelo.addColumn("Categoria");
        miModelo.addColumn("Precio");
        tab.setModel(miModelo); 
        return;
    }

    int posFilaT = 0; 
    Nodo<Productos> p = cab; 
    DefaultTableModel miModelo = new DefaultTableModel();

    miModelo.addColumn("Id");
    miModelo.addColumn("Nombre");
    miModelo.addColumn("Cantidad");
    miModelo.addColumn("Descripcion");
    miModelo.addColumn("Categoria");
    miModelo.addColumn("Precio");

    do {
        miModelo.addRow(new Object[]{"", "", "", "", "",""}); 
        setRegistrarFilaJTable(miModelo, posFilaT, p); 
        p = p.sig; 
        posFilaT++; 
    } while (p != cab); 

    tab.setModel(miModelo); 
}
    
    public void setRegistrarArchivo() {
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter("c:/Prueba/listaProductos.txt");
            pw = new PrintWriter(fichero);

            if (cab == null) {
                pw.println("Lista vacía!");
            } else {
                Nodo<Productos> p = cab;
                do {
                    Productos pro = p.dato;
                    pw.println("ID : " + pro.id);
                    pw.println("Nombre Producto: " + pro.nombre);
                    pw.println("Cantidad: " + pro.cantidad );
                    pw.println("Descripcion: " + pro.descripcion);
                    pw.println("Categoria: " + pro.categoria);
                      pw.println("Precio: " + pro.precio);
                    pw.println("=================================");
                    p = p.sig;
                } while (p != cab);
            }

            JOptionPane.showMessageDialog(null,
                    "Datos guardados en el archivo!",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al guardar el archivo: \n" + e.getMessage(),
                    "Error!",
                    JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error al cerrar el archivo: \n" + e.getMessage(),
                        "Error!",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void getInfoArchivo(JTextArea textArea) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader("c:/Prueba/listaProducto.txt");
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            textArea.setText(contenido.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }

    public void getInfoAll() {
        try {
            if (cab == null) {
                JOptionPane.showMessageDialog(null, "Lista Vacía!... ", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Nodo<Productos> p = cab;
                int op = 0;

                do {
                    StringBuilder aux = new StringBuilder();
                    aux.append("ID : ").append(p.dato.id).append("\n");
                    aux.append("Nombre Producto: ").append(p.dato.nombre).append("\n");
                    aux.append("cantidad: ").append(p.dato.cantidad).append("\n");
                    aux.append("Descripcion: ").append(p.dato.descripcion).append("\n");
                    aux.append("Categoria: ").append(p.dato.categoria).append("\n");
                       aux.append("Precio: ").append(p.dato.precio).append("\n");
                    JOptionPane.showMessageDialog(null, aux.toString());

                    op = JOptionPane.showConfirmDialog(null,
                            "¿Desea continuar recorriendo la lista?",
                            "Continuar",
                            JOptionPane.YES_NO_OPTION);

                    p = p.sig;

                } while (p != cab && op == 0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   
  
 public void getBuscarID(JTextField idI, JTextArea textArea) {
    try {
        int id = Integer.parseInt(idI.getText()); 
        Nodo<Productos> ProductoEncontrado = getBuscarProductoporId(id);

        if (ProductoEncontrado != null) {
            Productos pro = ProductoEncontrado.dato; 
            String mensaje = "ID: " + pro.id + "\n"
                    + "Nombre producto: " + pro.nombre+ "\n"
                    + "Cantidad: " + pro.cantidad + " años\n"
                    + "Descripcion: " + pro.descripcion + "\n"
                    + "Cantegoria: " + pro.categoria +"\n"
                    + "Precio:"+ pro.precio;

            textArea.setText(mensaje); 
        } else {
            textArea.setText("Producto no encontrado."); 
        }
    } catch (NumberFormatException e) {
        textArea.setText("ID no válido. Por favor, ingrese un número."); 
    }
}
}    
    

