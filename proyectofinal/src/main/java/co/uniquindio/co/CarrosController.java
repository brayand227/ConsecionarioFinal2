package co.uniquindio.co;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CarrosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btSiguiente;

    @FXML
    private TextField txMarca;

    @FXML
    private TextField txModelo;

    @FXML
    private TextField txPrecio;

    @FXML
    void Siguiente(ActionEvent event) {
        Stage stage = (Stage) btSiguiente.getScene().getWindow();
        stage.close();

    }

    public String getMarca() {
        return txMarca.getText();
    }

    public String getModelo() {
        return txModelo.getText();
    }

    public String getPrecio() {
        return txPrecio.getText();
    }

    @FXML
    void initialize() {

    }

}
