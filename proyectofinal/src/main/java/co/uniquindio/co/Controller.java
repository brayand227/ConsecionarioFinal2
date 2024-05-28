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
                    double pre = Double.parseDouble(precio);
                    comprarButton.setOnAction(e -> {
                        RegistrarseController registrarseController = RegistrarseController.getRegistrarseController();
                        Cliente cliente = registrarseController.getCliente();
                        VehiculoFactory vehiculoFactory = new VehiculoFactory();
                        Vehiculo vehiculo = vehiculoFactory.crearVehiculoBuilder("camioneta")
                                .Marca(marca)
                                .Modelo(modelo)
                                .Valor(pre)
                                .build();
                        cliente.AgregarvVehiculo(vehiculo);

                        System.out.print(cliente.getVehiculoBuilders().size());

                    });

                    ImageData imageData = new ImageData(file.toURI().toString(), marca, modelo, precio);
                    imageData.setComprarButton(comprarButton);

                    VBox imageBox = new VBox(imageView, marcaLabel, modeloLabel, precioLabel, comprarButton);
                    imagenesContainer.getChildren().add(imageBox);
                    AppStateCarro.getInstance().addImageData(imageData);

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
            Button comprarButton = data.getComprarButton();
            if (comprarButton == null) {
                comprarButton = new Button("Comprar");
                data.setComprarButton(comprarButton);
            }
            comprarButton.setOnAction(e -> {
                RegistrarseController registrarseController = RegistrarseController.getRegistrarseController();
                Cliente cliente = registrarseController.getCliente();
                System.out.print(cliente.getNombre());
                VehiculoFactory vehiculoFactory = new VehiculoFactory();
                Vehiculo vehiculo = vehiculoFactory.crearVehiculoBuilder("camioneta")
                        .Marca(data.getMarca())
                        .Modelo(data.getModelo())
                        .Valor(Double.parseDouble(data.getPrecio()))
                        .build();
                cliente.AgregarvVehiculo(vehiculo);

                System.out.print(cliente.getNombre());
                System.out.println(cliente.getVehiculoBuilders().size());
            });

            VBox imageBox = new VBox(imageView, marcaLabel, modeloLabel, precioLabel, comprarButton);
            imagenesContainer.getChildren().add(imageBox);
        }
    }
}
