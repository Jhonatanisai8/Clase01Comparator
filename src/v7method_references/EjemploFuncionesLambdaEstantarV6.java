package v7method_references;

import java.util.Random;
import static v7method_references.NumberUtils.*;

public class EjemploFuncionesLambdaEstantarV6 {
    Random r = new Random();

    public static void main(String[] args) {
        new EjemploFuncionesLambdaEstantarV6();
    }

    public EjemploFuncionesLambdaEstantarV6() {

        // codigo mas legible
        Integer total = Flujo.proveer(10, () -> generarNumero())
                .filtrar(NumberUtils::esPrimo)
                .transformar(NumberUtils::elevarCuadrado)
                .actuar(valor -> System.out.println("Valor: " + valor))
                .reducir(0, Integer::sum);

        System.out.println("SUMA => " + total);
    }

    // para generar el numero aleatorio
    private int generarNumero() {
        return r.nextInt(10);
    }

    public void ejemploSinReferencia() {
        Integer total = Flujo.proveer(10, () -> generarNumero())
                .filtrar(valor -> esPrimo(valor))
                .transformar(valor -> elevarCuadrado(valor))
                .actuar(valor -> System.out.println("Valor: " + valor))
                .reducir(0, (a, b) -> Integer.sum(a, b));

        System.out.println("SUMA => " + total);
    }
}
