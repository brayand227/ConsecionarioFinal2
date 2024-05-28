package co.uniquindio.Logica;

class Transaccion {
    private String codigo;
    private double monto;
    private PagoFacade pagoFacade;

    public Transaccion(String codigo, double monto) {
        this.codigo = codigo;
        this.monto = monto;
        this.pagoFacade = new PagoFacade();
    }

    public void pagarConTarjetaCredito() {
        pagoFacade.pagarConTarjetaCredito(monto);
    }

    public void pagarEnEfectivo() {
        pagoFacade.pagarEnEfectivo(monto);
    }

}




    

