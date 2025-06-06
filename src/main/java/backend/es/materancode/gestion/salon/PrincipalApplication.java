package backend.es.materancode.gestion.salon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * @author materancode
 * @version 1.0.0
 */
public class PrincipalApplication extends Application {
        @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 646, 919);
        stage.setTitle("Pantalla Principal");
        stage.setScene(scene);
        stage.show(); 
    }

    public static void main(String[] args) {
        launch();
    }
}
