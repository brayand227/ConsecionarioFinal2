package co.uniquindio.Logica;

public class PagoFacade {
    private MetodoPago pagoTarjetaCredito;
    private MetodoPago pagoEfectivo;

    public PagoFacade() {
        this.pagoTarjetaCredito = new PagoTarjetaCredito();
        this.pagoEfectivo = new PagoEfectivo();
    }

    public void pagarConTarjetaCredito(double monto) {
        pagoTarjetaCredito.realizarPago(monto);
    }

    public void pagarEnEfectivo(double monto) {
        pagoEfectivo.realizarPago(monto);
    }

}

