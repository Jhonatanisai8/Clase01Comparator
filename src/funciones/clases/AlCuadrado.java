package funciones.clases;

import funciones.interfaces.Funcion;

public class AlCuadrado
        implements Funcion {
    @Override
    public Integer aplicar(Integer valor) {
        return valor * valor;
    }
}
