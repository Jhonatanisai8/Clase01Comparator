package funciones.clases;

import funciones.interfaces.Provedor;

public class Naturales
        implements Provedor {
    private static int next = 0;

    @Override
    public Integer obtener() {
        return next++;
    };
}
