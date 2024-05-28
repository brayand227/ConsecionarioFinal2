package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import co.uniquindio.Logica.Consecionario;
import co.uniquindio.Logica.User;
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

    private String user;
    private String contraseña;
    private User usuario;

    @FXML
    void Iniciar(ActionEvent event) throws IOException {
        user = txUser.getText();
        contraseña = Password.getText();
        usuario = new User(user, contraseña);
        if (Consecionario.validarUser(usuario)) {
            Parent root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("MENU");
            stage.show();
        }

    }

    @FXML
    void Volver(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
