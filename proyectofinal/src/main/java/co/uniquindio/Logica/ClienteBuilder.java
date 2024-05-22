package co.uniquindio.Logica;

import java.time.LocalDate;

public class ClienteBuilder {
    private String nombre;
    private String apellido;
    private LocalDate date;

    private String id;

    public ClienteBuilder() {
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
        return new Cliente(nombre, apellido, date, id);

    }

    public String getId() {
        return id;
    }
}
