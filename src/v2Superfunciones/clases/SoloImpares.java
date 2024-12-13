package v2Superfunciones.clases;

import v2Superfunciones.interfaces.Predicado;

public class SoloImpares
        implements Predicado {

    @Override
    public boolean text(Integer valor) {
        return valor % 2 != 0;
    }

}