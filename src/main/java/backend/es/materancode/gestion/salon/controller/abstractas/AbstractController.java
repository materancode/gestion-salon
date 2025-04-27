package backend.es.materancode.gestion.salon.controller.abstractas;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public abstract class AbstractController {

    private Properties propertiesIdioma;
    
    public void setPropertiesIdioma(Properties properties) {
        propertiesIdioma = properties;
    }

    public Properties  getPropertiesIdioma(){
        return propertiesIdioma;
    }

    public Properties loadIdioma(String nombreFichero, String idioma) {
        Properties properties = new Properties();

        if (nombreFichero == null || idioma == null) {
            return properties;
        }

        String path = "src/main/resources/" + nombreFichero + "-" + ".properties";

        File file = new File(path);

        if (!file.exists() || !file.isFile()) {
            System.out.println("Path:" + file.getAbsolutePath());
            return properties;
    }

    try {
        FileInputStream input = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(input, "UtF-8");
        properties.load(isr);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return properties;
}

}