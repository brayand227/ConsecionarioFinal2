package co.uniquindio.Logica;

public class CarroBuilder extends VehiculoBuilder<CarroBuilder> {

    @Override
    protected CarroBuilder self() {
        return this;
    }

    @Override
    public Carro build() {
        Carro carro = new Carro();
        carro.setModelo(modelo);
        carro.setMarca(marca);
        carro.setPlaca(marca);
        carro.setValor(valor);
        return carro;
    }
}
