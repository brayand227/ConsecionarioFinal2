/**
 * Sample Skeleton for 'inicio.fxml' Controller Class
 */

package co.uniquindio.co;

import java.io.IOException;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class InicioController {

    @FXML // fx:id="btregistrado"
    private Button btregistrado; // Value injected by FXMLLoader

    @FXML // fx:id="btregistrarse"
    private Button btregistrarse; // Value injected by FXMLLoader
    @FXML
    private Button btRegresar;

    @FXML
    void Regresar(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("principalVentana.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("INICIO  USUARIO");

        stage.show();

    }

    @FXML
    void Registrar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("registrarse.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("REGISTRO USUARIO");
        stage.show();

    }

    @FXML
    void Registrado(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("INICIAR SESION");

    }

}
