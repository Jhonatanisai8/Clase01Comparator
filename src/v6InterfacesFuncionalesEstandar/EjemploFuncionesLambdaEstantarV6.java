package v6InterfacesFuncionalesEstandar;

import java.util.Random;

public class EjemploFuncionesLambdaEstantarV6 {
    Random r = new Random();
    public static void main(String[] args) {
        new EjemploFuncionesLambdaEstantarV6();
    }

    public EjemploFuncionesLambdaEstantarV6() {
        Integer total = Flujo.proveer(10, () -> r.nextInt(10))
                .filtrar(numero -> numero % 2 == 0)
                .transformar(valor -> valor * valor)
                .actuar(valor -> System.out.println("Valor: " + valor))
                .reducir(0, (a, b) -> a + b);

        System.out.println("TOTAL => " + total);

    }
}
