package v6InterfacesFuncionalesEstandar;

import java.util.Random;

public class EjemploLambdaV5 {
    Random r = new Random();
    public static void main(String[] args) {
        new EjemploLambdaV5();
    }

    public EjemploLambdaV5() {
        Integer total = Flujo.proveer(10, () -> r.nextInt(10))
                .filtrar(numero -> numero % 2 == 0)
                .transformar(valor -> valor * valor)
                .actuar(valor -> System.out.println("Valor: " + valor))
                .reducir(0, (a, b) -> a + b);

        System.out.println("TOTAL => " + total);

    }
}
