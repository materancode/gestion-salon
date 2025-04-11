package backend.es.materancode.gestion.salon.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


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
}
