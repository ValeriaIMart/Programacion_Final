/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author pccas
 */
public class DetallePedido {
    
     String Iddetalle;
     int idpedido;
     int idproducto;
     int cantidad;
     double valorunitario;
     double valortotal;

    public DetallePedido(String Iddetalle, int idpedido, int idproducto, int cantidad, double valorunitario, double valortotal) {
        this.Iddetalle = Iddetalle;
        this.idpedido = idpedido;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
    }

   
    
    
}
