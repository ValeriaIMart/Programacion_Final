/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pastryshop;

import java.util.Vector;
import static pastryshop.Usuario.mostrar;

/**
 *
 * @author pccas
 */
public class Registro {
    public String correo;
    public String contraseña;

    public Registro(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    
    public static int Verificar(String correo){
    
    Vector lista = mostrar();
    Registro ob;
    for(int i =0;1<lista.size();i++){
    ob=(Registro)lista.elementAt(i);
    if(ob.correo.equals(correo)){
    return i;
    }
      
    }
     
    return -1;
    
    
    }
    
      public static int Ingresar (String correo, String contraseña){
    
    Vector l = mostrar();
    Registro p;
    for(int i =0;1<l.size();i++){
    p=(Registro)l.elementAt(i);
    if(p.correo.equals(correo)){
    return i;
    }
      
    }
     
    return -1;
    
    
    }
    
}
