/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author pccas
 */
public class Usuario {
    
     String correo;
     String contrasena;
     int ID;
     boolean activo;

    public Usuario(String correo, String contrasena, int ID, boolean activo) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.ID = ID;
        this.activo = activo;
    }
  
}
