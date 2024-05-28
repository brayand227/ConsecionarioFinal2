package co.uniquindio.Logica;

import java.util.ArrayList;
import java.util.List;

public class ConcretoSujeto implements Sujeto {
    private List<Observador> observadoresCarro;
    private List<Observador> observadoresCamioneta;

    public ConcretoSujeto() {
        observadoresCarro = new ArrayList<>();
        observadoresCamioneta = new ArrayList<>();
    }

    @Override
    public void registrarObservador(Observador o, String tipo) {
        if (tipo.equalsIgnoreCase("carro")) {
            observadoresCarro.add(o);
        } else if (tipo.equalsIgnoreCase("camioneta")) {
            observadoresCamioneta.add(o);
        }
    }

    @Override
    public void eliminarObservador(Observador o, String tipo) {
        if (tipo.equalsIgnoreCase("carro")) {
            observadoresCarro.remove(o);
        } else if (tipo.equalsIgnoreCase("camioneta")) {
            observadoresCamioneta.remove(o);
        }
    }

    @Override
    public void notificarObservadores(String tipo, String mensaje) {
        List<Observador> observadores;
        if (tipo.equalsIgnoreCase("carro")) {
            observadores = observadoresCarro;
        } else if (tipo.equalsIgnoreCase("camioneta")) {
            observadores = observadoresCamioneta;
        } else {
            return;
        }
        for (Observador observador : observadores) {
            observador.actualizar(tipo, mensaje);
        }
    }

    public void establecerEstado(String tipo, String mensaje) {
        notificarObservadores(tipo, mensaje);
    }
}
