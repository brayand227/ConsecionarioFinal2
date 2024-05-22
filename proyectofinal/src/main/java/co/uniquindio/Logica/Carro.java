package co.uniquindio.Logica;

public class Carro extends Vehiculo {

    public Carro() {
        this.tipo = "CARRO";
    }

    @Override
    public void start() {
        System.out.println("INICIANDO MOTOR DE CARRO");
    }

    @Override
    public void stop() {
        System.out.println("APAGANDO MOTOR DE CARRO");
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }
}
