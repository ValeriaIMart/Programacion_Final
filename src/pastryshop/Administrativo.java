package pastryshop;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pccas
 */
public class Administrativo extends Usuario {

    public int idadministrativo;


    public Administrativo(int idadministrativo, String nombre, int numero, String direccion, String correo, String contraseña) {
        super(nombre, numero, direccion, correo, contraseña, "Administrativo");
        this.idadministrativo = idadministrativo;
    }




  

}
