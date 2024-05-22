package co.uniquindio.co;

import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PrincipalVentanaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    static PrincipalVentanaController principalVentanaController;

    @FXML
    private URL location;

    @FXML
    private Button btCerrar;

    @FXML
    private Button btSiguiente;

    @FXML
    private ComboBox<String> cxOpciones;

    public String getOpcion() {
        return cxOpciones.getValue();
    }

    @FXML
    void Cerrar(ActionEvent event) {
        Stage stage = (Stage) btCerrar.getScene().getWindow();
        stage.close();
    }

    @FXML
    void Siguiente(ActionEvent event) throws IOException {
        String opcion = cxOpciones.getValue();
        if (opcion != null) {
            if (opcion.equals("USUARIO")) {
                Parent root = FXMLLoader.load(getClass().getResource("inicio.fxml"));
                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);

                stage.setTitle("INICIO  USUARIO");

                stage.show();

            } else if (opcion.equals("ADMINISTRADOR")) {
                Parent roo = FXMLLoader.load(getClass().getResource("admin.fxml"));
                Scene scene = new Scene(roo);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("ADMINISTRADOR");
                stage.show();

            } else if (opcion.equals("EMPLEADO")) {
                Parent root = FXMLLoader.load(getClass().getResource("menuUser.fxml"));
                Scene scene = new Scene(root);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(scene);

                stage.setTitle("MENU");

                stage.show();

            }
        } else {
            RegistrarseController.Imprimir("ERROR", "SELECCIONE UNA OPCION");

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        principalVentanaController = this;
        cxOpciones.getItems().addAll("USUARIO", "ADMINISTRADOR", "EMPLEADO");
    }

    public static PrincipalVentanaController getInstance() {
        return principalVentanaController;
    }

    @FXML
    void initialize() {
        principalVentanaController = this;

    }

}
