package backend.es.materancode.gestion.salon.controller;

import java.util.ArrayList;

import backend.es.materancode.gestion.salon.PrincipalApplication;
import backend.es.materancode.gestion.salon.controller.abstractas.AbstractController;
import backend.es.materancode.gestion.salon.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author materancode
 * @version 1.0.0
 */
public class RegistroController extends AbstractController {
    /*Botton para volver */
    @FXML
    Button botonVolver;

    /**texto usuario */
    @FXML
    Text textUsuario;

    /*TexField de usuario */
    @FXML
    TextField textFieldUsuario;

    /*Text Email */
    @FXML
    Text textEmail;

    /*Texfield email */
    @FXML
    TextField textFieldEmail;

    /*Text repearEmail */
    @FXML
    Text textEmailRepeat;

    /*textField repeat email */
    @FXML
    TextField textFieldEmailRepeat;

    /*Text contrasenia */
    @FXML
    Text textContrasenia;

    /*TextField contrasenia */
    @FXML
    TextField texFieldContrasenia;

    /*Tex contrasenia repeat */
    @FXML
    Text textContraseniaRepeat;

    /*TextField contrasenia repeat */
    @FXML
    TextField textFieldContraseniaRepeat;

    /*Text nombre */
    @FXML
    Text textNombre;

    /*TextField nombre */
    @FXML
    TextField texFieldtNombre;

    /*Text apellidos */
    @FXML
    Text textApellidos;

    /*TextField apellidos */
    @FXML
    TextField textFieldApellidos;

    /*Text direccion */
    @FXML
    Text textDireccion;

    /*TextField direccion */
    @FXML
    TextField textFieldDireccion;

    /*Text telefono */
    @FXML
    Text textTelefono;

    /*Texfield Telefono */
    @FXML
    TextField textFieldTelefono;

    //@FXML
    //Button onButtonRegistrar;

    /*Botton de registrar usuarios */
    @FXML
    private Button onButtonRegistrar;

    /*Text Cambiante */
    @FXML
    Text textCambiante;


    /*Metodo para volver al loggin */
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

    /*Metodo para agregar usuarios */
    @FXML
    protected void abrirButtonClickRegistrar(){
        if (!comprobarRegistrar()) {
            return;
        }
        User nuevoUser = new User(textFieldUsuario.getText(), texFieldContrasenia.getText(),
        textFieldContraseniaRepeat.getText(), texFieldtNombre.getText(), textFieldDireccion.getText(),
        textFieldTelefono.getText(), textFieldEmail.getText());

        ArrayList<User> usuarioList;
        usuarioList = getUsuarioServiceModel().obtenerTodosLosUsuarios();

        if (usuarioList.contains(nuevoUser)) {
            textCambiante.setText("Ya existe una cuenta registrada");
            return;
        }

        if (getUsuarioServiceModel().obtenerUsuariosPorEmail(textFieldEmail.getText())!= null) {
            textCambiante.setText("Ya existe una cuenta registrada con ese nombre de usuario");
        }

        getUsuarioServiceModel().aniadirUsuario(nuevoUser);

    }

    /*Metodo para comprobar textFields */
    protected boolean comprobarRegistrar() {

        //Contrasenia y repeatContrasenia no puede ser null o vacia
        if (texFieldContrasenia == null || texFieldContrasenia.getText().isEmpty()
        || textFieldContraseniaRepeat == null || textFieldContraseniaRepeat.getText().isEmpty()){
            textCambiante.setText("La contraseña no puede ser nula o vacía");
            return true;
        }
       
        //contrasenias deben ser iguales
        if (!texFieldContrasenia.getText().equals(textFieldContraseniaRepeat.getText())) {
            textCambiante.setText("La contraseña debe coincidir");
            return true;
        }

        //usuario no puede ser nulo o vacio
        if (textFieldUsuario == null || textFieldUsuario.getText().isEmpty()) {
            textCambiante.setText("Usuario no puede ser nulo ni vacío");
            return true;
        }
        
        //nombre no puede ser nulo o vacio
        if (texFieldtNombre == null || texFieldtNombre.getText().isEmpty()) {
            textCambiante.setText("Nombre no puede ser nulo o vacío");
        }
        
        //email y repeatEmail no pueden ser nulo o vacio
        if (textFieldEmail == null || textFieldEmail.getText().isEmpty()
        ||textFieldEmailRepeat == null || textFieldEmailRepeat.getText().isEmpty()) {
            textCambiante.setText("Email no puede ser nulo ni vacío");
        }
        
        //los emails deben coincidir
        if (!textFieldEmailRepeat.getText().equals(textFieldEmail.getText())) {
            textCambiante.setText("Email debe coincidir con el Repetir Email");
        }

        //Apellidos no pueden ser nulos ni vacios
        if (textFieldApellidos == null || textFieldApellidos.getText().isEmpty()) {
            textCambiante.setText("Apellidos no pueden ser nulos o vacíos");
        }

        //Telefono no puede ser nulo o vacio
        if (textFieldTelefono == null || textFieldTelefono.getText().isEmpty()) {
            textCambiante.setText("El teléfono no puede ser nulo o vaCÍO");
        }
        return true;
    }

}
