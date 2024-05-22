package co.uniquindio.Logica;

import java.time.LocalDate;

public class AdministradorBuilder {
    private String nombre;
    private String apellido;
    private LocalDate date;
    private User user;
    private String id;

    public AdministradorBuilder() {

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

    public AdministradorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public AdministradorBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public AdministradorBuilder date(LocalDate date) {
        this.date = date;
        return this;
    }

    public AdministradorBuilder user(User user) {
        this.user = user;
        return this;
    }

    public AdministradorBuilder id(String id) {
        this.id = id;
        return this;
    }

    public Administrador build() {
        return new Administrador(nombre, apellido, date, user, id);
    }
}
