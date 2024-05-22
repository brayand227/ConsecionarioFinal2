package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegistrarUsuarioCrontoller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AGREGAR;

    @FXML
    private Button BtiIniciarSesio;

    @FXML
    private TextField TxNombre;

    @FXML
    private DatePicker date;

    @FXML
    private TextField txAepllido;

    @FXML
    private Button btVolver;

    @FXML
    private TextField txCodigo;

    @FXML
    void AGREGAR(ActionEvent event) {

    }

    @FXML
    void Volver(ActionEvent event) throws IOException {
        App.setRoot("venta");

    }

    @FXML
    void Iniciar(ActionEvent event) throws IOException {
        App.setRoot("user");

    }

    @FXML
    void Registrar(MouseEvent event) {

    }

    @FXML
    void initialize() {
    }

}
