import java.util.*;

import v4Flujo.Flujo;
import v4Flujo.interfaces.*;

public class EjemploFlujoV4 {
    public static void main(String[] args) {
        new EjemploFlujoV4();
    }

    public EjemploFlujoV4() {
        Integer total = new Flujo<Integer>(List.of(1,2,3,4,5,6,7,8))
        .filtrar(new Predicado<>() {
            @Override
            public boolean text(Integer valor) {
                return valor % 2 == 0;
            }
        }).transformar(new OperadorUnario<Integer>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        }).actuar(new Consumidor<>() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println("Valor : "+valor);
            }
        }).reducir(0, new OperadorBinario<>() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        });

        System.out.println("TOTAL => "+total);

    }
}
