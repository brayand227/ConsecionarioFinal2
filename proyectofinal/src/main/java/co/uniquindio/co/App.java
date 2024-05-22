package co.uniquindio.co;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import co.uniquindio.Logica.Consecionario;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    Consecionario consecionario;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("principalVentana"), 700, 400);
        stage.setScene(scene);

        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}