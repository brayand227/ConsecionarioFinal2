package co.uniquindio.Logica;

public class Contexto {
    private Venta venta;

    public Contexto(Venta venta) {
        this.venta = venta;

    }

    public void Ejecutar(VehiculoBuilder<?> vehiculo) {
        this.venta.venta(vehiculo);
        Double n = venta.venta(vehiculo);
        System.out.println("GANACIA " + n);

    }

}
