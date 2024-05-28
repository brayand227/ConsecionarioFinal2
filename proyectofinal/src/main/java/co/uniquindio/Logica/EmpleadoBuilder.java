package co.uniquindio.Logica;

import java.time.LocalDate;

public class EmpleadoBuilder {
    private String nombre;
    private String apellido;
    private LocalDate date;
    private User user;
    private String id;

    public EmpleadoBuilder() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmpleadoBuilder user(User user) {
        this.user = user;
        return this;
    }

    public EmpleadoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpleadoBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public EmpleadoBuilder date(LocalDate date) {
        this.date = date;
        return this;
    }

    public EmpleadoBuilder id(String id) {
        this.id = id;
        return this;
    }

    public Empleado build() {
        return new Empleado(nombre, apellido, date, user, id);
    }

}
