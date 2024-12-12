package funciones.clases;

import funciones.interfaces.Funcion;

public class AlCubo
        implements Funcion {
    @Override
    public Integer aplicar(Integer valor) {
        return valor * valor * valor;
    }
}
