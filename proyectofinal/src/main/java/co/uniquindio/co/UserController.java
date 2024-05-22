package co.uniquindio.co;

import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField Password;

    @FXML
    private Button btSesion;

    @FXML
    private Button btVolver;

    @FXML
    private TextField txUser;

    @FXML
    void Iniciar(ActionEvent event) {

    }

    @FXML
    void Volver(ActionEvent event) throws IOException {
        /* App.setRoot("registrarUsuario"); */
        Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("REGISTRAR USUARIO");

        stage.show();

    }

    @FXML
    void initialize() {
    }

}
