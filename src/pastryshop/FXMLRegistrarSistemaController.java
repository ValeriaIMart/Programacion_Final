/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author pccas
 */
public class FXMLRegistrarSistemaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    public ArrayList MisClientes;

    DatosUsuario listausuario;
    Usuario auxven; 
    
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_direccion;
    @FXML
    private TextField txt_telefono;
    @FXML
    private TextField txt_correo;
    @FXML
    private TextField txt_password;




    @FXML
    private Button btn_add;

    @FXML
    private void Add_Registro(ActionEvent event) {
                         Usuario infoF = new Usuario(
                        this.txt_nombre.getText(),
                        this.txt_telefono.getText(),
                        this.txt_direccion.getText(),
                        this.txt_correo.getText(),
                        this.txt_password.getText(),
                        "Cliente"
                );
                MisClientes.add(infoF);
                
                
 this.txt_nombre.setText("");
 this.txt_telefono.setText("");
 this.txt_direccion.setText("");
 this.txt_correo.setText("");
 this.txt_password.setText("");
        
       
    }
    
    @FXML
    private void Open_Login(ActionEvent event) throws IOException {
        /*Abrir una ventana*/
        Stage stage3 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage3.setScene(scene2);
         stage3.initStyle(StageStyle.UNDECORATED);
        stage3.setTitle("Login");
        stage3.show();

        /*Cerrar la ventana*/
      Node source2 = (Node) event.getSource();
      Stage stage = (Stage) source2.getScene().getWindow();
      stage.close();

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          MisClientes = new ArrayList();
    }    
    
}
