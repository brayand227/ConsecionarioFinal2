package co.uniquindio.Logica;

public class VehiculoFactory {

    public VehiculoBuilder<?> crearVehiculoBuilder(String tipo) {
        switch (tipo.toLowerCase()) {
            case "carro":
                return Carro.builder();
            case "camioneta":
                return Camioneta.builder();
            default:
                throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo);
        }
    }
}
