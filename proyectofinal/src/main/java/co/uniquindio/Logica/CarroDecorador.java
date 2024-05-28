package co.uniquindio.Logica;

public class CarroDecorador extends VehiculoDecorador {

    public CarroDecorador(Vehiculo vehiculo) {
        super(vehiculo);
    }

    @Override
    public void start() {
        super.start();
        mejorarStar();
    }

    public void mejorarStar() {
        System.out.println("SISTEMA DE INICIO MEJORADO");
    }

    @Override
    public void stop() {
        mejorStop();
        super.stop();
    }

    public void mejorStop() {
        System.out.println("MEJORANDO FRENOS");
    }

}
