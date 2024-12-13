package v2Superfunciones.clases;

import v2Superfunciones.interfaces.Consumidor;

public class Impresor
        implements Consumidor {

    public void aceptar(Integer valor) {
        System.out.print(valor + " - ");
    };
}