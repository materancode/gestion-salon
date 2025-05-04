package backend.es.materancode.gestion.salon.controller.abstractas;

import backend.es.materancode.gestion.salon.model.User;
import backend.es.materancode.gestion.salon.model.servicios.UsuarioServiceModel;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * @author materancode
 * @version 1.0.0
 */
public abstract class AbstractController {
    private String direccion = "";
    static final String PATH_DB ="src/main/resources/usuariosSalon.db";
    private UsuarioServiceModel usuarioServiceModel;
    static User usuarioActual;
        /**
     * Funcion para obtener la direccion guardada
     * @return direccion guardada
     */
    public String getDireccion(){
        return this.direccion;
    }

    /**
     * Metodo para modificar la direccion guardada
     * @param direccion nueva direccion
     */
    public void setDireccion(String direccion){
        this.direccion =  direccion;
    }

    /**
     * Constructor
     */
    protected AbstractController() {
        try {
            usuarioServiceModel = new UsuarioServiceModel(PATH_DB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * retorna el usuarioservicemodel para poder trabajar con el
     * @return UsuarioServiceModel
     */
    public UsuarioServiceModel getUsuarioServiceModel() {
        return this.usuarioServiceModel;
    }

    /**
     * setea al usuario actual
     * 
     * @param usuario a ser el actual
     */
    public void setUsuarioActual(User usuario){
        this.usuarioActual = usuario;
    }

    /**
     * retorna el usuario actual
     * @return User
     */
    public User getUsuarioActual(){
        return usuarioActual;
    }
    
    /**
     * comprueba que los textField sean correctos
     * @param campo
     * @return true/false
     */
    @FXML
    public boolean comprobarTextField( TextField campo){
        if (campo.getText() == null || campo.getText().isEmpty()) {
            return false;
        }
        return true;
    }
}
