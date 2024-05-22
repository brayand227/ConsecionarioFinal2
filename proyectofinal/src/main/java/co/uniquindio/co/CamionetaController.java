package co.uniquindio.co;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Cliente;
import co.uniquindio.Logica.ImageData;
import co.uniquindio.Logica.Vehiculo;
import co.uniquindio.Logica.VehiculoFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CamionetaController {
    private static PrincipalVentanaController principalVentanaController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cargarImagenButton;

    @FXML
    private VBox imagenesContainer;

    @FXML
    void cargarImagenButton(ActionEvent event) throws IOException {
        PrincipalVentanaController principalVentana = PrincipalVentanaController.getInstance();
        String tipo = principalVentana.getOpcion();

        if (tipo.equals("USUARIO")) {
            RegistrarseController.Imprimir("ERROR", "ESTA OPCION SOLO ES PARA EMPLEADOS");
        } else {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg", "*.gif"));

            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("carro.fxml"));
                    Parent root = loader.load();

                    Scene scene = new Scene(root);

                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("INFORMACION VEHICULO");
                    stage.showAndWait();

                    CarrosController carroController = loader.getController();
                    String marca = carroController.getMarca();
                    String modelo = carroController.getModelo();
                    String precio = carroController.getPrecio();

                    Image image = new Image(file.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(200);
                    imageView.setPreserveRatio(true);

                    Label marcaLabel = new Label("Marca: " + marca);
                    Label modeloLabel = new Label("Modelo: " + modelo);
                    Label precioLabel = new Label("Precio: " + precio);
                    Button comprarButton = new Button("Comprar");

                    comprarButton.setOnAction(e -> {
                        // Acción al presionar el botón de comprar
                        System.out.println("Compra realizada para el vehículo: " + marca + " " + modelo);
                    });

                    VBox imageBox = new VBox(imageView, marcaLabel, modeloLabel, precioLabel, comprarButton);
                    imagenesContainer.getChildren().add(imageBox);

                    // Añadir la imagen y su información al estado de la aplicación
                    AppState.getInstance()
                            .addImageData(new ImageData(file.toURI().toString(), marca, modelo, precio));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @FXML
    void initialize() {
        // Recargar las imágenes del estado de la aplicación cuando se inicializa la
        // ventana
        for (ImageData data : AppState.getInstance().getImageList()) {
            Image image = new Image(data.getImagePath());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);

            Label marcaLabel = new Label("Marca: " + data.getMarca());
            Label modeloLabel = new Label("Modelo: " + data.getModelo());
            Label precioLabel = new Label("Precio: " + data.getPrecio());

            VBox imageBox = new VBox(imageView, marcaLabel, modeloLabel, precioLabel);
            imagenesContainer.getChildren().add(imageBox);
        }
    }
}
