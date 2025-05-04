package backend.es.materancode.gestion.salon.controller;

import backend.es.materancode.gestion.salon.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author materancode
 * @version 1.0.0
 */
public class RecoverPasswordController {
        /**Botton para volver a la pantalla inicial */
    @FXML
    Button onButtonClickVolver;

    /*Texto inicial para escribir el correo de recuperacion**/
    @FXML
    Text textEscribeEmail;

    /**Text Email */
    @FXML
    Text textEmailRecover;

    /**TextField email */
    @FXML
    TextField textFieldEmailRecover;

    /**Texto Cambiante segun datos ingresados  */
    @FXML Text textCambiante;


    /*Funcion para volver a la pantalla de loggin */
    @FXML
    protected void openButtonClickVolver(){
          try {
            Stage stage = (Stage) onButtonClickVolver.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/view/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 646, 919);
            stage.setTitle("Pantalla Principal");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
