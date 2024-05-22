package co.uniquindio.co;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;
import javafx.scene.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btAgregar;

    @FXML
    private Button btCamioneta;
    @FXML
    private BorderPane bp;
    @FXML
    private Button btCargarImagen;

    @FXML
    private Button btCarro;

    @FXML
    private Button btFavoritos;

    @FXML
    private Button btSiguiente;

    @FXML
    private Button btVolver;

    @FXML
    private AnchorPane centro;

    @FXML
    private Label lbCant;

    @FXML
    private ImageView user;

    @FXML
    void Agregar(ActionEvent event) {

    }

    @FXML
    void Camioneta(MouseEvent event) throws IOException {

        loadPage("camioneta");

    }

    @FXML
    void Carro(MouseEvent event) throws IOException {

        loadPage("prueba");

    }

    @FXML
    void Favorito(MouseEvent event) throws IOException {
        loadPage("inicio");
    }

    @FXML
    void Siguiente(ActionEvent event) throws IOException {

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
    void Subir(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        Stage primaryStage = (Stage) btCargarImagen.getScene().getWindow();
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            user.setImage(image);
        }

    }

    private void loadPage(String page) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
        bp.setCenter(root);

    }

    @FXML
    void initialize() {

    }

}
