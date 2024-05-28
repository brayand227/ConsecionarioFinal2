package co.uniquindio.Logica;

import java.io.Serializable;

import javafx.scene.control.Button;

public class ImageData implements Serializable {
    private String imagePath;
    private String marca;
    private String modelo;
    private String precio;
    private transient Button comprarButton;

    public ImageData(String imagePath, String marca, String modelo, String precio) {
        this.imagePath = imagePath;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.comprarButton = new Button("Comprar");
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPrecio() {
        return precio;
    }

    public Button getComprarButton() {
        return comprarButton;
    }

    public void setComprarButton(Button comprarButton) {
        this.comprarButton = comprarButton;
    }
}
