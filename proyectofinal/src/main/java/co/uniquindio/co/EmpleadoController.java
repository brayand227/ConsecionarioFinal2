package co.uniquindio.co;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class EmpleadoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtRegistrarse;

    @FXML
    private PasswordField Password;

    @FXML
    private Button btRegistrarse;

    @FXML
    private Button btVolver;

    @FXML
    void registrarse(ActionEvent event) {

    }

    @FXML
    void siguiente(ActionEvent event) {

    }

    @FXML
    void volver(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert BtRegistrarse != null
                : "fx:id=\"BtRegistrarse\" was not injected: check your FXML file 'empleado.fxml'.";
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'empleado.fxml'.";
        assert btRegistrarse != null
                : "fx:id=\"btRegistrarse\" was not injected: check your FXML file 'empleado.fxml'.";
        assert btVolver != null : "fx:id=\"btVolver\" was not injected: check your FXML file 'empleado.fxml'.";

    }

}
