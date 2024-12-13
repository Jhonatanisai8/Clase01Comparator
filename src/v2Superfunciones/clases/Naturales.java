package v2Superfunciones.clases;

import v2Superfunciones.interfaces.Provedor;

public class Naturales
        implements Provedor {
    private static int next = 0;

    @Override
    public Integer obtener() {
        return next++;
    };
}
