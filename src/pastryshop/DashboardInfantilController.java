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
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author eveli
 */
public class DashboardInfantilController implements Initializable {
@FXML
    private Button btn_aceptar;
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
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Dashboard");
        stage.show();

        /*Cerrar la ventana*/
      Node source2 = (Node) event.getSource();
      Stage stage2 = (Stage) source2.getScene().getWindow();
      stage2.close();
          
    }
    
    
        @FXML
    private void Open_Pasteltemporada(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("Dashboardtemporada.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Dashboardtemporada");
        stage.show();
        
        /*Cerrar la ventana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }
    @FXML
    private void Open_PastelBoda(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("DashboardBoda.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("DashboardBoda");
        stage.show();
        
        /*Cerrar la ventana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }
    @FXML
    private void Open_PastelInfantil(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("DashboardInfantil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("DashboardInfantil");
        stage.show();
        
        /*Cerrar la ventana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }
      @FXML
    private void Open_PastelCumple(ActionEvent event) throws IOException {
        /*Abrir una ventana*/    
        Stage stage=new Stage();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("DashboardCumple.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("DashboardCumple");
        stage.show();
        
        /*Cerrar la ventana*/
        Node source2 = (Node) event.getSource();
        Stage stage2 = (Stage) source2.getScene().getWindow();
        stage2.close();        
        
    }
    
        @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }
}
