/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pastryshop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pccas
 */
public class LoginadmController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void Open_DashboardAdmin(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("DashboardAdmin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("DashboardAdmin");
        stage.show();
        
        /*Cerrar la centana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }
    
       @FXML
    private void closeAction(ActionEvent event) {
        System.exit(0);
    }
    
    
}
