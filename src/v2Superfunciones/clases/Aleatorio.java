package v2Superfunciones.clases;

import java.util.Random;

import v2Superfunciones.interfaces.Provedor;

public class Aleatorio
        implements Provedor {
    Random random = new Random();

    @Override
    public Integer obtener() {
        return random.nextInt(100) + 1;
    }
}
