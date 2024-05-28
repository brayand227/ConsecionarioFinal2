package co.uniquindio.Logica;

import java.time.LocalDate;

public class Administrador extends Persona implements PersonaComponent {
    private String id;

    public Administrador(String nombre, String apellido, LocalDate date, User user, String id) {
        super(nombre, apellido, date, user);

        this.id = id;

    }

    public static AdministradorBuilder builder() {
        return new AdministradorBuilder();

    }

    public String getId() {
        return id;
    }

    public void agregarEmpleado(PersonaComponent empleado) {

        Consecionario.getEmpleados().put(empleado.getId(), empleado);

    }

    public void removerEmploye(PersonaComponent componente) {
        Consecionario.getEmpleados().remove(componente);

    }

    @Override
    public void mostrarDetalles() {

        System.out.println("Administrador: " + getNombre() + " " + getApellido());
        for (PersonaComponent componente : Consecionario.getEmpleados().values()) {
            componente.mostrarDetalles();
        }

    }

}
