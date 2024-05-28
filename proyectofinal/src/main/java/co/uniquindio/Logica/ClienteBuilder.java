package co.uniquindio.Logica;

import java.time.LocalDate;

public class ClienteBuilder {
    private String nombre;
    private String apellido;
    private LocalDate date;
    private User user;

    private String id;

    public ClienteBuilder() {
    }

    public ClienteBuilder user(User user) {
        this.user = user;
        return this;
    }

    public ClienteBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteBuilder Apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public ClienteBuilder Date(LocalDate date) {
        this.date = date;
        return this;
    }

    public ClienteBuilder Id(String id) {
        this.id = id;
        return this;
    }

    public Cliente build() {
        return new Cliente(nombre, apellido, date, user, id);

    }

    public String getId() {
        return id;
    }
}
