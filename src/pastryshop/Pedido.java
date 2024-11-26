/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

import java.util.Date;

/**
 *
 * @author pccas
 */
public class Pedido {
     int id;
     Date fecha;
     int idpersona;
     double subtotal;

    public Pedido(int id, Date fecha, int idpersona, double subtotal) {
        this.id = id;
        this.fecha = fecha;
        this.idpersona = idpersona;
        this.subtotal = subtotal;
    }
    
}
