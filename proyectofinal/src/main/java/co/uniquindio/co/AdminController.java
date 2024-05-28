package co.uniquindio.co;

import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Consecionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {

    static AdminController adminController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btEliminarAdmin;
    @FXML
    private DatePicker DatePicker;

    @FXML
    private TextField TxApellido;

    @FXML
    private TextField TxCedula;

    @FXML
    private TextField TxNombre;

    @FXML
    private Button btSiguiente;

    @FXML
    private Button btVolver;

    private Consecionario consecionario = Consecionario.getConsecionario();

    public String getId() {
        return TxCedula.getText();
    }

    @FXML
    void Siguiente(ActionEvent event) throws IOException {

        String nombre = TxNombre.getText();
        String apellido = TxApellido.getText();
        String id = TxCedula.getText();
        LocalDate date = DatePicker.getValue();
        if (nombre.isEmpty() || apellido.isEmpty() || date == null || id.isEmpty()) {
            RegistrarseController.Imprimir("TEXTOS VACIOS", "LOS ESPACIOS SON OBLIGATORIOS");
        } else {
            if (consecionario.getAdministradores().size() > 0) {
                RegistrarseController.Imprimir("ADMINISTRADOR YA REGISTRADO",
                        "YA SE ENCUENTRA UN ADMINISTRADOR REGISTRADO");
            } else {

                consecionario.agergarAdmin(nombre, apellido, date, id);

                Parent root = FXMLLoader.load(getClass().getResource("loginAdmin.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("LOGIN ADMINISTRADOR");
                stage.show();
            }

        }
    }

    @FXML
    void Volver(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("principalVentana.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.setTitle("VENTANA PRINCIPAL");

        stage.show();

    }

    @FXML
    void eliminarAdmin(ActionEvent event) throws IOException {

        if (consecionario.getAdministradores().size() > 0) {

            Parent root1 = FXMLLoader.load(getClass().getResource("eliminarAdmin.fxml"));
            Scene scene1 = new Scene(root1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene1);

            stage.setTitle("ELIMINAR ADMINISTRADOR");

            stage.show();
        } else {
            RegistrarseController.Imprimir("ERROR", "NO HAY NINGUN ADMINISTRADOR REGISTRADO");
        }

    }

    public static AdminController getInstance() {
        return adminController;
    }

    @FXML
    void initialize() {

        adminController = this;

    }

}
