package co.uniquindio.Logica;

public class Camioneta extends Vehiculo {

    public Camioneta() {
        this.tipo = "CAMIONETA";
    }

    @Override
    public void start() {
        System.out.println("Camioneta Encendida");
    }

    @Override
    public void stop() {
        System.out.println("Camioneta Apagada");
    }

    public static CamionetaBuilder builder() {
        return new CamionetaBuilder();
    }
}
