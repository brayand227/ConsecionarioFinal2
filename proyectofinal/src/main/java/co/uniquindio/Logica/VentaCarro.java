package co.uniquindio.Logica;

public class VentaCarro extends VentaVehiculo {
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    double CalcularPrecio(VehiculoBuilder<?> vehiculo) {
        double ganacia;
        ganacia = vehiculo.getValor() * 0.10;
        return ganacia;

    }

}
