package co.uniquindio.Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Persona {
    private String id;

    private Map<String, Vehiculo> vehiculoBuilders;

    public Map<String, Vehiculo> getVehiculoBuilders() {
        return vehiculoBuilders;
    }

    public Cliente(String nombre, String apellido, LocalDate date, String id) {
        super(nombre, apellido, date);

        this.id = id;
        vehiculoBuilders = new HashMap<>();
    }

    public void AgregarvVehiculo(Vehiculo vehiculoBuilder) {

    }

    public boolean validarVehiculo(String placa) {
        boolean centinela = false;

        if (vehiculoBuilders.containsKey(placa)) {
            centinela = true;
        }

        return centinela;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }

    @Override
    public String toString() {
        return super.toString() + "Cliente [cargo=" + "ID=" + id + "]";
    }

}
