package co.uniquindio.Logica;

public class ImageData {
    private String imagePath;
    private String marca;
    private String modelo;
    private String precio;

    public ImageData(String imagePath, String marca, String modelo, String precio) {
        this.imagePath = imagePath;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
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
}
