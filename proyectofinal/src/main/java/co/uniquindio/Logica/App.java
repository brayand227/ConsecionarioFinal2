package co.uniquindio.Logica;

public class App {
    public static void main(String[] args) {
        VehiculoFactory factory = new VehiculoFactory();

        Vehiculo carro = factory.crearVehiculoBuilder("carro")
                .Valor(25000).Marca("TOYOTA").Modelo("TXT")
                .build();

        Vehiculo camioneta = factory.crearVehiculoBuilder("camioneta")
                .Valor(35000)
                .build();

        carro.start();
        carro.stop();

        camioneta.start();
        camioneta.stop();

        Cliente cliente = Cliente.builder().Apellido("brayan").nombre("Cordoba").build();

        cliente.AgregarvVehiculo(carro);

        System.out.println(cliente.getVehiculoBuilders().size());
        System.out.println(", valor: " + carro.getValor() + "Marca" + carro.getMarca());
        System.out.println(", valor: " + camioneta.getValor());
    }
}
