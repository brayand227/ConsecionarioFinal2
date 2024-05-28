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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EliminarAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TxContraseña;

    @FXML
    private TextField TxId;

    @FXML
    private TextField TxUser;

    @FXML
    void Regresar(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("principalVentana.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("VENTANA PRINCIPAL");

        stage.show();

    }

    @FXML
    void eliminar(ActionEvent event) {

        String user = TxUser.getText();
        String contraseña = TxContraseña.getText();
        User usuario = new User(user, contraseña);

        String id = TxId.getText();

        if (Consecionario.getAdministradores().containsKey(id)) {
            Administrador administrador = Consecionario.getAdministradores().get(id);

            if (administrador.getUser().getUsuario().equals(user)
                    && administrador.getUser().getContraseña().equals(contraseña)) {

                Consecionario.getAdministradores().remove(id);

                RegistrarseController.Imprimir("ADMINISTRADOR ELIMINADO",
                        Consecionario.getAdministradores().size() + "");

            } else {
                RegistrarseController.Imprimir("ERROR",
                        "EL USUARIO O CONTRASEÑA NO ES VALIDA");

            }

        } else {
            RegistrarseController.Imprimir("ERROR", "NO SE HA ENCONTRADO A NINGUN ADMINISTRADOR CON ESA ID");
        }

    }

    @FXML
    void initialize() {

    }

}