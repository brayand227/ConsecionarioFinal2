package co.uniquindio.Logica;

public class CamionetaBuilder extends VehiculoBuilder<CamionetaBuilder> {

    @Override
    protected CamionetaBuilder self() {
        return this;
    }

    @Override
    public Camioneta build() {
        Camioneta camioneta = new Camioneta();
        camioneta.setModelo(modelo);
        camioneta.setMarca(marca);
        camioneta.setValor(valor);
        camioneta.setPlaca(marca);
        return camioneta;
    }
}
