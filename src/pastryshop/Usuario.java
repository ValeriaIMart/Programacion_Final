/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

/**
 *
 * @author pccas
 */
import java.util.Vector;


public class Usuario {
    private static Vector <Registro> datos = new Vector <Registro>();

    public static void agrgar (Registro obj) {
    datos.addElement(obj);
    }
    public static Vector mostrar(){
    return datos;
    }
  
}
