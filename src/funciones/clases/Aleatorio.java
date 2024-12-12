package funciones.clases;

import java.util.Random;

import funciones.interfaces.Provedor;

public class Aleatorio
        implements Provedor {
    Random random = new Random();

    @Override
    public Integer obtener() {
        return random.nextInt(100) + 1;
    }
}
