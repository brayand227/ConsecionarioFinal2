package co.uniquindio.co;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.uniquindio.Logica.Contexto;
import co.uniquindio.Logica.Vehiculo;
import co.uniquindio.Logica.VehiculoBuilder;
import co.uniquindio.Logica.VehiculoFactory;
import co.uniquindio.Logica.Venta;
import co.uniquindio.Logica.VentaCamioneta;
import co.uniquindio.Logica.VentaCarro;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class VentaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btRegresar;

    @FXML
    private Button btSiguiente;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private TextField txPlaca;

    @FXML
    private TextField txPrecio;

    @FXML
    void Regresar(ActionEvent event) {

    }

    @FXML
    void Siguiente(ActionEvent event) throws IOException {
        String tipo = cbTipo.getValue();

        if (txPlaca.getText().isEmpty() | txPrecio.getText().isEmpty() | tipo == null) {
            RegistrarseController.Imprimir("ESPACIOS EN BLANCO", "LLENAR LOS CAMPOS EN BLANCO POR FAVOR");
        } else {

            if (tipo.equals("CARRO")) {

                VehiculoFactory vehiculoFactory = new VehiculoFactory();
                VehiculoBuilder<?> carro = vehiculoFactory.crearVehiculoBuilder(tipo);
                carro.Valor(Integer.parseInt(txPrecio.getText())).build();

                Venta venta = new VentaCarro();
                Contexto contexto = new Contexto(venta);
                contexto.Ejecutar(carro);

                App.setRoot("registrarUsuario");

            } else {
                VehiculoFactory vehiculoFactory = new VehiculoFactory();
                VehiculoBuilder<?> carro = vehiculoFactory.crearVehiculoBuilder(tipo);
                carro.Valor(Integer.parseInt(txPrecio.getText())).build();

                Venta venta = new VentaCamioneta();
                Contexto contexto = new Contexto(venta);
                contexto.Ejecutar(carro);

                App.setRoot("registrarUsuario");
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cbTipo.getItems().addAll("CARRO", "CAMIONETA");
    }

}
