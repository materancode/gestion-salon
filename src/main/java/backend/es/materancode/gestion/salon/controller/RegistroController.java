package backend.es.materancode.gestion.salon.controller;

import backend.es.materancode.gestion.salon.PrincipalApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistroController {
    
    @FXML
    Button botonVolver;

    @FXML
    Text textUsuario;

    @FXML
    TextField textFieldUsuario;

    @FXML
    Text textEmail;

    @FXML
    TextField textFieldEmail;

    @FXML
    Text textEmailRepeat;

    @FXML
    TextField textFieldEmailRepeat;

    @FXML
    Text textContrasenia;

    @FXML
    TextField texFieldContrasenia;

    @FXML
    Text textContraseniaRepeat;

    @FXML
    TextField textFieldContraseniaRepeat;

    @FXML
    Text textNombre;

    @FXML
    TextField texFieldtNombre;

    @FXML
    Text textApellidos;

    @FXML
    TextField textFieldApellidos;

    @FXML
    Text textDireccion;

    @FXML
    TextField textFieldDireccion;

    @FXML
    Text textTelefono;

    @FXML
    TextField textFieldTelefono;

    //@FXML
    //Button onButtonRegistrar;

    @FXML
    Text textCambiante;


    @FXML
    protected void accionBotonVolver(){
          try {
            Stage stage = (Stage) botonVolver.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/view/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 646, 919);
            stage.setTitle("Pantalla Principal");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void abrirButtonClickRegistrar() {

        if (texFieldContrasenia == null || texFieldContrasenia.getText().isEmpty() 
        || textFieldContraseniaRepeat == null || textFieldContraseniaRepeat.getText().isEmpty()){
            textCambiante.setText("La contraseña no puede ser nula o vacía");
            return;
        }
        if (!texFieldContrasenia.getText().equals(textFieldContraseniaRepeat.getText())) {
            textCambiante.setText("La contraseña es incorrecta");
            return;
        }
        
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textCambiante.setText("Usuario no puede ser nulo ni vacío");
            return;
        }
        
        if (texFieldtNombre == null || texFieldtNombre.getText().isEmpty()) {
            textCambiante.setText("Nombre no puede ser nulo o vacío");
        }
        
        if (textFieldEmail == null || textFieldEmail.getText().isEmpty() 
        ||textFieldEmailRepeat == null || textFieldEmailRepeat.getText().isEmpty()) {
            textCambiante.setText("Email no puede ser nulo ni vacío");
        }
        
        if (textFieldEmailRepeat.getText().equals(textFieldEmail.getText())) {
            textCambiante.setText("Email debe coincidir con el Repetir Email");
        }
        if (textFieldApellidos == null || textFieldApellidos.getText().isEmpty()) {
            textCambiante.setText("Apellidos no pueden ser nulos o vacíos");
        }

        if (textFieldTelefono == null || textFieldTelefono.getText().isEmpty()) {
            textCambiante.setText("El teléfono no puede ser nulo o vaCÍO");
        }
    }

}
