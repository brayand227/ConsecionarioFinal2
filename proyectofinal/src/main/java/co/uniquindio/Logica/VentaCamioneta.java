package co.uniquindio.Logica;

public class VentaCamioneta extends VentaVehiculo {
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    double CalcularPrecio(VehiculoBuilder<?> vehiculo) {
        double ganancia;
        ganancia = vehiculo.getValor() * 0.2;

        return ganancia;
    }

}
