package v8metodos_references_avanzados;

import java.util.Random;
import static v7method_references.NumberUtils.*;

public class EjemploMetodosReferenciaAvanzados {
    Random r = new Random();

    public static void main(String[] args) {
        new EjemploMetodosReferenciaAvanzados();
    }

    public EjemploMetodosReferenciaAvanzados() {
        // codigo mas legible
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
