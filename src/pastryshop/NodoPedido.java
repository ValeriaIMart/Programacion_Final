/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author eveli
 */
public class NodoPedido<N> {

    N dato;
    NodoPedido<N> sig;

    public NodoPedido(N dato) {
        this.dato = dato;
        sig = null;
    }

}
