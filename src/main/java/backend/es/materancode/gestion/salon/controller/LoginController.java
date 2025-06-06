package backend.es.materancode.gestion.salon.controller;
import java.util.ArrayList;
import java.util.List;

import backend.es.materancode.gestion.salon.PrincipalApplication;
import backend.es.materancode.gestion.salon.controller.abstractas.AbstractControllerIdioma;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author materancode
 * @version 1.0.0
 */
public class LoginController extends AbstractControllerIdioma {
    private final String usuario = "primer usuario";
    private final String contrasenia = "1234";

    /**Text Usuario */
    @FXML
    private  Text textUsuario;

    /*Text Contrasenia */
    @FXML
    private Text textContrasenia;

    /**TextField Usuario */
    @FXML
    private  TextField textFieldUsuario;

    /**TextFiel Contrasenia */
    @FXML
    private PasswordField texFieldContrasenia;

    /*Button Aceptar login */
    @FXML
    private Button onButtonClickAceptar;

    /** Text Cambiante */
    @FXML
    private Text textCambiante;

    /**Text Registro */
    @FXML
    private Text textRegistro;

    /**Button Acceso a pantalla de Registro */
    @FXML
    private Button bottonPantallaRegistro;

    /**Text Olvidaste Password */
    @FXML
    private Text texOlvidastePassword;

    /**Button Acceso a pantalla de Recuperar password */
    @FXML
    private Button onClickButtonRecoverPassword;

    /*Button para cambiar idioma */
    @FXML
    private ComboBox comboIdioma;

    /*Inicializamos idiomas para agregar a la lista */
    @FXML
    private void initialize(){
        List<String> idiomas = new ArrayList<>();
        idiomas.add("en");
        idiomas.add("es");
        comboIdioma.getItems().addAll(idiomas);
    }

    /*Funcion que cambia el idioma de login */
    @FXML
    protected void cambiarIdiomaCombo(){
        setPropertiesIdioma(loadIdioma("idioma",comboIdioma.getValue().toString()));
        textUsuario.setText(getPropertiesIdioma().getProperty("textUsuario"));
        textContrasenia.setText(getPropertiesIdioma().getProperty("textContrasenia"));
        onButtonClickAceptar.setText(getPropertiesIdioma().getProperty("onButtonClickAceptar"));
        textCambiante.setText(getPropertiesIdioma().getProperty("textCambiante"));
        textRegistro.setText(getPropertiesIdioma().getProperty("textRegistro"));
        bottonPantallaRegistro.setText(getPropertiesIdioma().getProperty("bottonPantallaRegistro"));
        texOlvidastePassword.setText(getPropertiesIdioma().getProperty("texOlvidastePassword"));
        onClickButtonRecoverPassword.setText(getPropertiesIdioma().getProperty("onClickButtonRecoverPassword"));
        
    }

    /*Boton de aceptar para acceder a perfil personal si ya se ha registrado el usuario */
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

    /*Funcion Botton de acceso a pantalla de registro si no se tiene cuenta aun */
    @FXML
    protected void accionBottonPantallaRegistro(){
        try {
            Stage stage = (Stage) bottonPantallaRegistro.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/view/registro.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 919);
            stage.setTitle("Pantalla de Registro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Funcion Botton para recuperar contrasenia de usuario ya registrado, nos envia a la pantalla de recoverPassword*/
    @FXML
    protected void openClickButtonRecoverPassword(){
        try {
            Stage stage = (Stage) onClickButtonRecoverPassword.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/view/recoverPassword.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 646, 919);
            stage.setTitle("Pantalla Recuperacion Password");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
