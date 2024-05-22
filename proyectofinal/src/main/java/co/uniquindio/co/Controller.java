/*package co.uniquindio.co;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.File;
import java.util.Optional;

public class Controller {

    @FXML
    private Button cargarImagenButton;

    @FXML
    private VBox imagenesContainer;

    @FXML
    void cargarImagenButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("carro.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.setTitle("INFORMACION VEHICULO");
            CarrosController carrosController = loader.getController();

            String marca=carrosController.getMarca();
            String modelo=carrosController.getModelo();
            String precio=carrosController.getPrecio();



            stage.show();
            Optional<String> result = marca;
            result.ifPresent(description -> {
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(200);
                imageView.setPreserveRatio(true);

                Label descriptionLabel = new Label(description);

                VBox imageBox = new VBox(imageView, descriptionLabel);
                imagenesContainer.getChildren().add(imageBox);
            });
        }
    }

    @FXML
    private void initialize() {

    }
}
*/
package co.uniquindio.co;

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
import javafx.scene.Node;

import java.io.File;
import java.io.IOException;

import co.uniquindio.Logica.Cliente;
import co.uniquindio.Logica.ImageData;
import co.uniquindio.Logica.Vehiculo;
import co.uniquindio.Logica.VehiculoFactory;

public class Controller {

    @FXML
    private Button cargarImagenButton;

    @FXML
    private VBox imagenesContainer;

    @FXML

    void cargarImagenButton(ActionEvent event) throws IOException {
        PrincipalVentanaController principalVentana = PrincipalVentanaController.getInstance();
        String tipo = principalVentana.getOpcion();

        // Verificar el tipo de usuario y mostrar el mensaje de error si es necesario
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
                        RegistrarseController registrarseController = RegistrarseController.getRegistrarseController();

                        System.out.println(registrarseController.getNonmbre());

                    });

                    VBox imageBox = new VBox(imageView, marcaLabel, modeloLabel, precioLabel, comprarButton);
                    imagenesContainer.getChildren().add(imageBox);
                    AppStateCarro.getInstance()
                            .addImageData(new ImageData(file.toURI().toString(), marca, modelo, precio));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @FXML
    private void initialize() {
        for (ImageData data : AppStateCarro.getInstance().getImageList()) {
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
