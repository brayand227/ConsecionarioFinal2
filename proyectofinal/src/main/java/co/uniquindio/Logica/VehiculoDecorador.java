package co.uniquindio.Logica;

public abstract class VehiculoDecorador extends Vehiculo {

    protected Vehiculo vehiculo;

    public VehiculoDecorador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void start() {
        vehiculo.start();

    }

    @Override
    public void stop() {
        vehiculo.stop();

    }

}
