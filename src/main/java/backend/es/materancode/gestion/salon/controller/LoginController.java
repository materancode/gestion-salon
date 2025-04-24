package backend.es.materancode.gestion.salon.controller;
import backend.es.materancode.gestion.salon.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginController {
    private final String usuario = "primer usuario";
    private final String contrasenia = "1234";

    /**Text Usuario */
    @FXML
    Text textUsuario;

    /*Text Contrasenia */
    @FXML
    Text textContrasenia;

    /**TextField Usuario */
    @FXML
    TextField textFieldUsuario;

    /**TextFiel Contrasenia */
    @FXML
    PasswordField texFieldContrasenia;

    /*Button Aceptar login */
    @FXML
    Button onButtonClickAceptar;

    /** Text Cambiante */
    @FXML
    Text textCambiante;

    /**Text Registro */
    @FXML
    Text textRegistro;

    /**Button Acceso a pantalla de Registro */



    /**Text Olvidaste Password */
    @FXML
    Text texOlvidastePassword;

    /**Button Acceso a pantalla de Recuperar password */
    @FXML
    Button onClickButtonRecoverPassword;



    @FXML
    protected void openButtonClickAceptar() {
        if (textFieldUsuario== null || textFieldUsuario.getText().isEmpty() || 
        texFieldContrasenia == null || texFieldContrasenia.getText().isEmpty() ) {
            textCambiante.setText("Credenciales null o vacias");
            return;
    }

    if (!textFieldUsuario.getText().equals(usuario) || !texFieldContrasenia.getText().equals(contrasenia)) {
        textCambiante.setText("Credenciales invalidas");
        return;
    }
    textCambiante.setText("Usuario validado correctamente");
    }



    @FXML
    protected void openClickButtonRecoverPassword(){
        try {
            Stage stage = (Stage) onClickButtonRecoverPassword.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/recoverPassword.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle("Pantalla Recuperacion Password");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
