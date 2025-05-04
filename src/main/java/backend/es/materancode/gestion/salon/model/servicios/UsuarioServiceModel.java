package backend.es.materancode.gestion.salon.model.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.es.materancode.gestion.salon.model.User;
import backend.es.materancode.gestion.salon.model.abstractas.Conexion;
/**
 * @author materancode
 * @version 1.0.0
 */
public class UsuarioServiceModel extends Conexion {
        /**
     * Constructor vacio
     */
    public UsuarioServiceModel() {
    }
    
    /**
     * Constructor con la ruta de la bbdd
     * @param unaRutaArchivoBD ruta de la bbdd
     */
    public UsuarioServiceModel(String unaRutaArchivoBD) {
        super(unaRutaArchivoBD);
    }

    /**
     * Funcion que ejecuta la sentencia introducida
     * @param sql sentencia a ejecutar
     * @return lista de usuarios de la sentencia introducida
     */
    public ArrayList<User> leerSentencia(String sql){
        ArrayList<User> usuarios = new ArrayList<>();
    try (PreparedStatement sentencia = conectar().prepareStatement(sql);
         ResultSet resultado = sentencia.executeQuery()) {

        while (resultado.next()) {
            String userStr = resultado.getString("user");
            String contraseniaStr = resultado.getString("contrasenia");
            String nombreSrt = resultado.getString("nombre");
            String apellidoSrt = resultado.getString("apellido");
            String  direccionSrt = resultado.getString("direccion");
            String telefonoSrt = resultado.getString("telefono");
            String emailStr = resultado.getString("email");

            User usuario = new User(userStr, contraseniaStr,nombreSrt,apellidoSrt,direccionSrt,telefonoSrt,emailStr);
            usuarios.add(usuario);
        }
    } catch (Exception e) { 
        e.printStackTrace();
    } finally {
        cerrar();
    }
    return usuarios;
    }

    /**
     * Funcion que actualiza los datos segun la secuencia introducida
     * @param sql sentencia a realizar
     * @param usuario datos para actualizar
     * @return true/false
     */
    public boolean actualizarDatos(String sql, User usuario){
        try {
            PreparedStatement sentencia = conectar().prepareStatement(sql);
            sentencia.setString(1, usuario.getUsuario());
            sentencia.setString(2, usuario.getContrasenia());
            sentencia.setString(3, usuario.getNombre());
            sentencia.setString(4, usuario.getApellido());
            sentencia.setString(5, usuario.getDireccion());
            sentencia.setString(6, usuario.getTelefono());
            sentencia.setString(7, usuario.getEmail());

            sentencia.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            cerrar();
        }
    }

    /**
     * Funcion para aniadir un usuario a la app
     * @param usuario a aniadir
     * @return true/false
     */
    public boolean aniadirUsuario(User usuario){
        if (usuario == null) {
            return false;
        }
        String sql = "INSERT INTO usuarios (user, contrasenia, nombre, apellido, direccion, telefono, email) Values (?,?,?,?,?,?,?)";
        return actualizarDatos(sql, usuario);
    }

    /**
     * Metodo para obtener los datos de un usuario por el nombre de usuario
     * @param user nombre de usuario
     * @return Usuario buscado
     */
    public User obtenerUsuariosPorUser(String user){
        String sql = "SELECT * FROM usuarios WHERE user = '" + user + "'";
        ArrayList<User> usuarios = leerSentencia(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }

    /**
     * Metodo para obtener los datos de un usuario por el email
     * @param email email del usuario buscado
     * @return usuario buscado
     */
    public User obtenerUsuariosPorEmail(String email){
        String sql = "SELECT * FROM usuarios WHERE email = '" + email + "'";
        ArrayList<User> usuarios = leerSentencia(sql);
        if (usuarios.isEmpty()) {
            return null;
        }
        return usuarios.get(0);
    }

    /**
     * Funcion que te devuleve todos los usuarios de la base de datos
     * @return lista de usuarios
     */
    public ArrayList<User> obtenerTodosLosUsuarios(){
        String sql = "SELECT * FROM usuarios";
        return leerSentencia(sql);
    }

}
