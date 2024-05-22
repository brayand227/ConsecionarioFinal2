package co.uniquindio.co;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Cliente;
import co.uniquindio.Logica.ClienteBuilder;
import co.uniquindio.Logica.Consecionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AsignarClienteController {
    Consecionario consecionario = Consecionario.getConsecionario();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BtAsignar;

    @FXML
    private Button BtRegistrar;

    @FXML
    private Button BtVolver;

    @FXML
    private DatePicker Date;

    @FXML
    private TextField txApellido;

    @FXML
    private TextField txCodigo;

    @FXML
    private TextField txNombre;

    @FXML
    void Asignar(ActionEvent event) {
        String nombre = txNombre.getText();
        String apellido = txApellido.getText();
        String codigo = txCodigo.getText();
        LocalDate date = Date.getValue();
        Cliente cliente = Cliente.builder().Apellido(apellido).Date(date).Id(codigo).nombre(nombre).build();
        if (consecionario.validarCliente(cliente)) {

            RegistrarseController.Imprimir("", consecionario.getClientes().size() + "");
        } else {
            RegistrarseController.Imprimir("error", "ERROR");

        }

    }

    @FXML
    void Registro(ActionEvent event) {

    }

    @FXML
    void Volver(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
