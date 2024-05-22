package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DatePicker;

    @FXML
    private TextField TxApellido;

    @FXML
    private TextField TxNombre;

    @FXML
    private Button btSiguiente;

    @FXML
    private Button btVolver;

    @FXML
    void Siguiente(ActionEvent event) {

    }

    @FXML
    void Volver(ActionEvent event) throws IOException {
        /* App.setRoot("registrarUsuario"); */
        Parent root = FXMLLoader.load(getClass().getResource("principalVentana.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("REGISTRAR ADMINISTRADOR");

        stage.show();

    }

    @FXML
    void initialize() {

    }

}
