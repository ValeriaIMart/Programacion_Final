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
    
    private String correo;
    private String contrasena;
    private int ID;
    private boolean activo;

    public Usuario(String correo, String contrasena, int ID, boolean activo) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.ID = ID;
        this.activo = activo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
