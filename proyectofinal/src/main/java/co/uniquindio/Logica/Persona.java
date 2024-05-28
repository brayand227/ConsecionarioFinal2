package co.uniquindio.Logica;

import java.time.LocalDate;

public abstract class Persona {

    private String nombre;
    private String apellido;
    private LocalDate date;
    private User user;

    public Persona(String nombre, String apellido, LocalDate date, User user) {

        this.user = user;
        this.nombre = nombre;
        this.apellido = apellido;
        this.date = date;
    }

    public User getUser() {
        return user;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", date=" + date + "]";
    }
}
