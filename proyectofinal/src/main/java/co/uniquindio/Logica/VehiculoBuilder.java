package co.uniquindio.Logica;

public abstract class VehiculoBuilder<T extends VehiculoBuilder<T>> {

    protected double valor;
    protected String tipo;
    protected String marca;
    protected String modelo;

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValor() {
        return valor;
    }

    public T Valor(double valor) {
        this.valor = valor;
        return self();
    }

    public T Modelo(String modelo) {
        this.modelo = modelo;
        return self();
    }

    public T Marca(String marca) {
        this.marca = marca;
        return self();
    }

    protected abstract T self();

    public abstract Vehiculo build();
}
