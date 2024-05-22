package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btAcceso;

    @FXML
    private Button btVolver;

    @FXML
    void Acceso(ActionEvent event) {

    }

    @FXML
    void Volver(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }

    @FXML
    void initialize() {

    }

}
