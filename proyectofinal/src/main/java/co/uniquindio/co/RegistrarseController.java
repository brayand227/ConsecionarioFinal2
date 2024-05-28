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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import co.uniquindio.Logica.Consecionario;
import co.uniquindio.Logica.User;
import javafx.scene.control.Alert.AlertType;

public class RegistrarseController implements Initializable {

    private Consecionario consecionario;
    private static RegistrarseController registrarseController;

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
    private PasswordField TxContraseña;

    @FXML
    private PasswordField TxContraseña1;

    @FXML
    private TextField TxUser;

    @FXML
    private Button btregresar;

    @FXML
    private Button btsiguiente;
    private String user;
    private String contraseña;
    private String contraseña1;
    private User usuario;
    private String nombre;
    private String apellido;
    private LocalDate localDate;
    private String id;
    private Cliente cliente1;

    public String getNombre() {
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

    public Cliente getCliente() {
        return cliente1;
    }

    @FXML
    void Regresar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("INICIO USUARIO");
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
        user = TxUser.getText();
        contraseña = TxContraseña.getText();
        contraseña1 = TxContraseña1.getText();
        usuario = new User(user, contraseña);

        if (nombre.isEmpty() || apellido.isEmpty() || localDate == null || id.isEmpty() || user.isEmpty()
                || contraseña.isEmpty() || contraseña1.isEmpty()) {
            Imprimir("TEXTOS VACIOS", "LOS ESPACIOS SON OBLIGATORIOS");
        } else {
            if (consecionario.validarCliente(cliente1)) {
                Imprimir("USUARIO REGISTRADO", "EL USUARIO YA EXISTE");
            } else if (contraseña.equals(contraseña1)) {
                consecionario.agregarCliente(nombre, apellido, localDate, id, usuario);

                Parent root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("MENU");
                stage.show();
            } else {
                Imprimir("ERROR", "CONTRASEÑAS NO SON IGUALES");
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
