/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author pccas
 */
 
public class Cliente extends Usuario {

int idcliente;

   
    public Cliente(int idcliente, String nombre, int numero, String direccion, String correo, String contraseña) {
        super(nombre, numero, direccion, correo, contraseña, "Cliente");
        this.idcliente = idcliente;
    }



    

    

   
}