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
    
    private String Iddetalle;
    private int idpedido;
    private int idproducto;
    private int cantidad;
    private double valorunitario;
    private double valortotal;

    public DetallePedido(String Iddetalle, int idpedido, int idproducto, int cantidad, double valorunitario, double valortotal) {
        this.Iddetalle = Iddetalle;
        this.idpedido = idpedido;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
    }

    public String getIddetalle() {
        return Iddetalle;
    }

    public void setIddetalle(String Iddetalle) {
        this.Iddetalle = Iddetalle;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(double valorunitario) {
        this.valorunitario = valorunitario;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
    
    
    
}
