package backend.es.materancode.gestion.salon.controller;

import backend.es.materancode.gestion.salon.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdministradorGestion {

    /*Button volver a perfil de administrador */
    @FXML
    Button onButtonClickVolver;
    

    /*Funcion para volver al perfil del administrador */
    @FXML
    protected void openButtonClickVolverAtras(){
           try {
            Stage stage = (Stage) onButtonClickVolver.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/view/administradorPerfil.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 646, 919);
            stage.setTitle("Pantalla perfil administrador");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    }

