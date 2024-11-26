/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author SARIC
 */
public class Nodo <N> {
    

    N dato;
    Nodo<N> sig;

    public Nodo(N dato) {
        this.dato = dato;
        sig = null;
    }
    
}
