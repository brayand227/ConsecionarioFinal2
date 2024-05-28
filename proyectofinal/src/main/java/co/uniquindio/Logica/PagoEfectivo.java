package co.uniquindio.Logica;

public class PagoEfectivo implements MetodoPago{
    
    @Override
    public void realizarPago(double valor) {
        System.out.println("Pago realizado en efectivo por valor de: " + valor);
    }

    
}
