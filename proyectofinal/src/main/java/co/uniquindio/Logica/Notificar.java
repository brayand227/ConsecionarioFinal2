package co.uniquindio.Logica;

public class Notificar {
    public static void main(String[] args) {
        ConcretoSujeto sujeto = new ConcretoSujeto();

        EmailObservar observador = new EmailObservar("felipedraza830@gmail.com");
        EmailObservar observador2 = new EmailObservar("brayancalle227@gmail.com");
        sujeto.registrarObservador(observador, "carro");
        sujeto.registrarObservador(observador2, "camioneta");

        sujeto.establecerEstado("carro", "Oferta especial para carros!");
        sujeto.establecerEstado("camioneta", "Descuento exclusivo para camionetas!");

    }
}
