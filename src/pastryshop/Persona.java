/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author pccas
 */
public class Persona {
    private int idpersona;
    private String nombre;
    private String direccion;
    private String correo;

    public Persona(int idpersona, String nombre, String direccion, String correo) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
    
}
