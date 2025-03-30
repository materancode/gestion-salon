package backend.es.materancode.gestion.salon.model;
import java.util.Objects;
/**
 * @author materancode
 * @version 1.0.0
 */
public class User {
    String usuario;
    String contrasenia;
    String nombre;
    String apellido;
    String  direccion;
    String telefono;
    String email;

    /**Constructor vacio */
    public User() {
    }

    /**
     * Constructor con todos los elementos
     * @param usuario nombre de usuario
     * @param contrasenia contrasenia para acceder a la cuenta
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param direccion direccion del usuario
     * @param telefono telefono del usuario
     * @param email correo electronico del usuario
     */
    public User(String usuario, String contrasenia, String nombre, String apellido, String direccion, String telefono, String email) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     *  Getters and Setters
     * @return elementos
     */
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User usuario(String usuario) {
        setUsuario(usuario);
        return this;
    }

    public User contrasenia(String contrasenia) {
        setContrasenia(contrasenia);
        return this;
    }

    public User nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public User apellido(String apellido) {
        setApellido(apellido);
        return this;
    }

    public User direccion(String direccion) {
        setDireccion(direccion);
        return this;
    }

    public User telefono(String telefono) {
        setTelefono(telefono);
        return this;
    }

    public User email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return getUsuario() + "," + getContrasenia() + "," + getNombre() + "," + getApellido() + "," + getDireccion() + "," + getTelefono() + "," + getEmail();
    }

}
