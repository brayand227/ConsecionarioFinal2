package co.uniquindio.Logica;

public class PagoTarjetaCredito implements MetodoPago{

    @Override
    public void realizarPago(double valor) {
        System.out.println("Pago realizado con tarjeta de credito por valor de: " + valor);
    }
    
    
}
