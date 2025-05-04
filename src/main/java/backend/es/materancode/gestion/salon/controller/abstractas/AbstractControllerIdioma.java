package backend.es.materancode.gestion.salon.controller.abstractas;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;
/**
 * @author materancode
 * @version 1.0.0
 */
public abstract class AbstractControllerIdioma {

    /*Declaramos Properties con la variable */
    private Properties propertiesIdioma;
    
    /*Declaramos set para modificar */
    public void setPropertiesIdioma(Properties properties) {
        propertiesIdioma = properties;
    }

    /*Declaramos get para obtener */
    public Properties  getPropertiesIdioma(){
        return propertiesIdioma;
    }

    /*Cargamos el idioma y verificamos si existe en el fichero */
    public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();

        if (nombreFichero == null || idioma == null) {
            return properties;
        }

        String path = "src/main/resources/" + nombreFichero +"-"+ idioma + ".properties";

        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Path:" + file.getAbsolutePath());
            return properties;
    }

    try {
        FileInputStream input = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(input,"UtF-8");
        properties.load(isr);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return properties;
}

}