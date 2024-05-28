
package co.uniquindio.Logica;

import java.time.LocalDate;

public class Empleado extends Persona implements PersonaComponent {
    private String id;

    public Empleado(String nombre, String apellido, LocalDate date, User user, String id) {
        super(nombre, apellido, date, user);
        this.id = id;
    }

    public static EmpleadoBuilder builder() {
        return new EmpleadoBuilder();

    }

    public String getId() {
        return id;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado: " + getNombre() + " " + getApellido());
    }

    public void agregarCliente(Cliente cliente) {
        Consecionario.getClientes().add(cliente);
    }

    public void eliminiarCliente(Cliente cliente) {
        Consecionario.getClientes().remove(cliente);
    }
}
