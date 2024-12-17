package v9Optional;

import java.util.Comparator;
import java.util.Random;
import static v7method_references.NumberUtils.*;

public class EjemploV9Optional {
    Random r = new Random();

    public static void main(String[] args) {
        new EjemploV9Optional();
    }

    public EjemploV9Optional() {
        // codigo mas legible
        /* Optional<Integer> maximo = */ Flujo.proveer(10, this::generarNumero)
                .filtrar(valor -> valor >= 0)
                .ordenar(Integer::compareTo) // => ordena de menor a mayor
                .transformar(NumberUtils::elevarCuadrado)
                // .transformar(valor -> new Descripcion(valor))
                .transformar(Descripcion::new)
                .actuar(System.out::println)
                // .transformar( desc -> desc.getvalue())
                .transformar(Descripcion::getValue)
                .max(Comparator.naturalOrder())
                // .ifPresent(valor -> System.out.println("Maximo Valor: " +
                // valor.doubleValue()));
                .ifPresentOrElse(
                        t -> System.out.println("Maximo Valor: " + t),
                        () -> System.out.println("No hay maximo por que el flujo esta vacio."));
    }

    // para generar el numero aleatorio
    private int generarNumero() {
        return r.nextInt(10);
    }

    public void ejemplo() {
        Integer total = Flujo.proveer(10, this::generarNumero)
                .filtrar(NumberUtils::esPrimo)
                .ordenar(Integer::compareTo) // => ordena de menor a mayor
                .transformar(NumberUtils::elevarCuadrado)
                // .transformar(valor -> new Descripcion(valor))
                .transformar(Descripcion::new)
                .actuar(System.out::println)
                // .transformar( desc -> desc.getvalue())
                .transformar(Descripcion::getValue)
                .reducir(0, Integer::sum);
        System.out.println("SUMA => " + total);
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
