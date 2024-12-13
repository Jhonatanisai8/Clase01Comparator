package v2Superfunciones.clases;

import v2Superfunciones.interfaces.Funcion;

public class AlCubo
        implements Funcion {
    @Override
    public Integer aplicar(Integer valor) {
        return valor * valor * valor;
    }
}
