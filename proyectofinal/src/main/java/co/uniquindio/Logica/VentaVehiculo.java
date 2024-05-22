package co.uniquindio.Logica;

public abstract class VentaVehiculo implements Venta {
    @Override
    public double venta(VehiculoBuilder<?> vehiculo) {
        double venta = CalcularPrecio(vehiculo);
        return venta;

    }

    abstract double CalcularPrecio(VehiculoBuilder<?> vehiculo);

}
