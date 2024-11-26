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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author eveli
 */
public class ListaPedido {

    Nodo<Pedido> cab;

    ListaPedido() {
        cab = null;
    }

    public boolean getEsVacia() {
        return cab == null ? true : false;
    }

    public int getLonglista() {
        if (getEsVacia()) {
            return 0;
        } else {
            Nodo<Pedido> p = cab;
            int cont = 0;
            do {
                cont++;
                p = p.sig;
            } while (p != cab);
            return cont;
        }
    }

    public Nodo<Pedido> getBuscarPedidoporId(int id) {
        if (getEsVacia()) {
            return null;
        } else {
            Nodo<Pedido> p = cab;
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

    public Pedido getCrearPedido(
            JTextField jtfid,
            JTextField jtffecha,
            JTextField jtfidpedido,
            JTextField jtfsubtotal
    ) {

        Pedido pr = null;
        Nodo<Pedido> buscar = null;

        try {

            buscar = getBuscarPedidoporId(Integer.parseInt(jtfid.getText()));
            if (buscar != null) {
                JOptionPane.showMessageDialog(null,
                        "El ID ya existe, intente nuevamente!");
                return null;
            } else {

                pr = new Pedido(
                        Integer.parseInt(jtfid.getText()),
                        jtffecha.getText(),
                        Integer.parseInt(jtfidpedido.getText()),
                        Float.parseFloat(jtfsubtotal.getText())
                );

                return pr;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
            return null;
        }
    }

    public Nodo<Pedido> getUltimo() {
        if (cab == null) {
            return null;
        } else {
            Nodo<Pedido> p = cab;
            while (p.sig != cab) {
                p = p.sig;
            }
            return p;
        }
    }

    public void setADD(
            JTextField jtfid,
            JTextField jtffecha,
            JTextField jtfidpedido,
            JTextField jtfsubtotal
    ) {
        Pedido pr = getCrearPedido(jtfid, jtffecha, jtfidpedido, jtfsubtotal);
        if (pr != null) {
            Nodo<Pedido> info = new Nodo(pr);
            if (cab == null) {
                cab = info;
                cab.sig = cab;
            } else {
                Nodo<Pedido> base = getUltimo();
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
                Nodo<Pedido> base = getUltimo();
                Nodo<Pedido> e = cab;
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
            int pFila, Nodo<Pedido> p) {

        miModelo.setValueAt(p.dato.id, pFila, 0);
        miModelo.setValueAt(p.dato.fecha, pFila, 1);
        miModelo.setValueAt(p.dato.idpersona, pFila, 2);
        miModelo.setValueAt(p.dato.subtotal, pFila, 3);

    }

    public void setLlenarJTable(JTable tab) {
        if (cab == null) {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista.");
            DefaultTableModel miModelo = new DefaultTableModel();
            miModelo.addColumn("Id");
            miModelo.addColumn("Fecha");
            miModelo.addColumn("Id persona");
            miModelo.addColumn("Subtotal");
            tab.setModel(miModelo);
            return;
        }

        int posFilaT = 0;
        Nodo<Pedido> p = cab;
        DefaultTableModel miModelo = new DefaultTableModel();

        miModelo.addColumn("Id");
        miModelo.addColumn("Fechas");
        miModelo.addColumn("Id persona");
        miModelo.addColumn("Subtotal");

        do {
            miModelo.addRow(new Object[]{"", "", "", ""});
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
            fichero = new FileWriter("c:/Prueba/listaPedido.txt");
            pw = new PrintWriter(fichero);

            if (cab == null) {
                pw.println("Lista vacía!");
            } else {
                Nodo<Pedido> p = cab;
                do {
                    Pedido ped = p.dato;
                    pw.println("ID : " + ped.id);
                    pw.println("Fecha: " + ped.fecha);
                    pw.println("ID persona: " + ped.idpersona);
                    pw.println("Sub total: " + ped.subtotal);
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
            fileReader = new FileReader("c:/Prueba/listaPedido.txt");
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
                Nodo<Pedido> p = cab;
                int op = 0;

                do {
                    StringBuilder aux = new StringBuilder();
                    aux.append("ID : ").append(p.dato.id).append("\n");
                    aux.append("Fecha: ").append(p.dato.fecha).append("\n");
                    aux.append("Id persona: ").append(p.dato.idpersona).append("\n");
                    aux.append("Sub total: ").append(p.dato.subtotal).append("\n");
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
            Nodo<Pedido> PedidoEncontrado = getBuscarPedidoporId(id);

            if (PedidoEncontrado != null) {
                Pedido pro = PedidoEncontrado.dato;
                String mensaje = "ID: " + pro.id + "\n"
                        + "Fecha: " + pro.fecha + "\n"
                        + "Id persona: " + pro.idpersona + "\n"
                        + "Sub total: " + pro.subtotal + "\n";

                textArea.setText(mensaje);
            } else {
                textArea.setText("Pedido no encontrado.");
            }
        } catch (NumberFormatException e) {
            textArea.setText("ID no válido. Por favor, ingrese un número.");
        }
    }

}
