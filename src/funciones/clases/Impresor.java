package funciones.clases;

import funciones.interfaces.Consumidor;

public class Impresor
        implements Consumidor {

    public void aceptar(Integer valor) {
        System.out.print(valor + " - ");
    };
}