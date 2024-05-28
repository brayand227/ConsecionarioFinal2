package co.uniquindio.Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Persona {
    private String id;

    private ArrayList<Vehiculo> vehiculoBuilders;

    public ArrayList<Vehiculo> getVehiculoBuilders() {
        return vehiculoBuilders;
    }

    public Cliente(String nombre, String apellido, LocalDate date, User user, String id) {
        super(nombre, apellido, date, user);

        this.id = id;
        vehiculoBuilders = new ArrayList<>();
    }

    public void AgregarvVehiculo(Vehiculo vehiculoBuilder) {
        vehiculoBuilders.add(vehiculoBuilder);

    }

    public boolean validarVehiculo(String placa) {
        boolean centinela = false;

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

}
