package backend.es.materancode.gestion.salon.controller;

import backend.es.materancode.gestion.salon.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdministradorPerfil {
    
    /*Texto cambiante en userName administrador */
    @FXML
    Text textAdministradorCambiante;

    /*Button gestion productos del salon enviar a pantalla */
    @FXML
    Button buttonGestionarProductos;

    @FXML
    protected void openButtonGestionarProductos(){

           try {
            Stage stage = (Stage) buttonGestionarProductos.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/administradorGestProductos.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 919);
            stage.setTitle("Pantalla de gestión productos del salon");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
