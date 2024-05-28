package co.uniquindio.Logica;

;

public interface Sujeto {
    void registrarObservador(Observador o, String categoria);

    void eliminarObservador(Observador o, String categoria);

    void notificarObservadores(String categoria, String mensaje);
}
