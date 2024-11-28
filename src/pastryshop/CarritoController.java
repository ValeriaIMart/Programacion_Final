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
public class CarritoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       @FXML
    private void Open_Dashboard(ActionEvent event) throws IOException {
                 /*Abrir una ventana*/
        Stage stage4 = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage4.setScene(scene2);
        stage4.setTitle("Dashboard");
        stage4.show();

        /*Cerrar la ventana*/
      Node source2 = (Node) event.getSource();
      Stage stage = (Stage) source2.getScene().getWindow();
      stage.close();
          
    } 
}
