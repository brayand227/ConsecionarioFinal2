package co.uniquindio.Logica;

import java.time.LocalDate;

public class Administrador extends Persona {
    private String id;
    private User user;

    public Administrador(String nombre, String apellido, LocalDate date, User user, String id) {
        super(nombre, apellido, date);
        this.user = user;
        this.id = id;

    }

    public User getUser() {
        return user;
    }

    public AdministradorBuilder builder() {
        return new AdministradorBuilder();

    }

    public String getId() {
        return id;
    }

}
