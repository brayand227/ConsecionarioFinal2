package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Cliente;

import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import co.uniquindio.Logica.Consecionario;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class RegistrarseController implements Initializable {

    private Consecionario consecionario;
    static RegistrarseController registrarseController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker Calendar;

    @FXML
    private TextField Txapellido;

    @FXML
    private TextField Txcodigo;

    @FXML
    private TextField Txnombre;

    @FXML
    private Button btregresar;

    @FXML
    private Button btsiguiente;

    private String nombre;
    private String apellido;
    private LocalDate localDate;
    private String id;

    public String getNonmbre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return localDate;
    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("INICIO  USUARIO");

        stage.show();

    }

    public static RegistrarseController getRegistrarseController() {
        return registrarseController;
    }

    @FXML
    public void Siguiente(ActionEvent event) throws IOException {
        consecionario = Consecionario.getConsecionario();
        nombre = Txnombre.getText();
        apellido = Txapellido.getText();
        localDate = Calendar.getValue();
        id = Txcodigo.getText();
        if (nombre.isEmpty() | apellido.isEmpty() | localDate == null | id.isEmpty()) {
            Imprimir("TEXTOS VACIOS", "LOS ESPACIOS SON OBLIGATORIOS");
        } else {
            Cliente cliente = Cliente.builder().Apellido(apellido).Date(localDate).Id(id).nombre(nombre).build();
            if (consecionario.validarCliente(cliente)) {

                Imprimir("USUARIO REGISTRADO", "EL USUARIO YA EXISTE");
            } else {

                consecionario.agregarCliente(nombre, apellido, localDate, id);

                Parent root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);

                stage.setTitle("INICIO  USUARIO");

                stage.show();
            }
        }

    }

    public static void Imprimir(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        registrarseController = this;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registrarseController = this;

    }
}
