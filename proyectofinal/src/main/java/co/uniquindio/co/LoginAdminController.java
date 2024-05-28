package co.uniquindio.co;

import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Administrador;
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

public class LoginAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtRegistrarse;

    @FXML
    private Button BtVolver;

    @FXML
    private PasswordField TxContraseña;

    @FXML
    private PasswordField TxContraseña1;

    @FXML
    private TextField TxUser;

    @FXML
    void registrarse(ActionEvent event) throws IOException {
        String usuario = TxUser.getText();
        String contraseña = TxContraseña.getText();
        String contraseña1 = TxContraseña1.getText();
        if (contraseña.equals(contraseña1)) {

            AdminController adminController = AdminController.getInstance();
            String id = adminController.getId();
            Administrador administrador = Consecionario.getAdministradores().get(id);
            User user = new User(usuario, contraseña1);
            administrador.setUser(user);

            RegistrarseController.Imprimir("REGISTRO DE ADMINISTRADOR",
                    Consecionario.getAdministradores().size() + "ID" + id + " " + " Usuario:"
                            + administrador.getUser().getUsuario() + " CONTRASEÑA: "
                            + administrador.getUser().getContraseña());

        } else {
            RegistrarseController.Imprimir("CONTRASEÑA ERRADA", "LAS CONTRASEÑAS NO COINCIDEN ");
        }

    }

    @FXML
    void volver(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("principalVentana.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("VENTANA PRINCIPAL");
        stage.show();

    }

    @FXML
    void initialize() {

    }

}
