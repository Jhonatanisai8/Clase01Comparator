package v6InterfacesFuncionalesEstandar;
import java.util.*;
import java.util.function.*;

public class Flujo<T> {
    private final List<T> valores;

    public Flujo(List<T> valores) {
        this.valores = valores;
    }

    public static <T> Flujo<T> proveer(int tamanio, Supplier<T> provedor) {
        List<T> resultado = new ArrayList<>();
        for (int i = 0; i < tamanio; i++) {
            resultado.add(provedor.get());
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> filtrar(Predicate<T> predicado) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            if (predicado.test(valor)) {
                resultado.add(valor);
            }
        }
        return new Flujo<>(resultado);
    }

    public <R> Flujo<R> transformar(Function<T, R> funcion) {
        List<R> resultado = new ArrayList<>();
        for (T valor : valores) {
            resultado.add(funcion.apply(valor));
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> actuar(Consumer<T> consumidor) {
        for (T valor : valores) {
            consumidor.accept(valor);
        }
        return new Flujo<>(valores);
    }

    public void consumir(Consumer<T> consumidor) {
        for (T T : valores) {
            consumidor.accept(T);
        }

    }

    public T reducir(T identidad, BinaryOperator<T> funcionBinaria) {
        T total = identidad;
        for (T valor : valores) {
            total = funcionBinaria.apply(total, valor);
        }
        return total;
    }

    @Override
    public String toString() {
        return valores.toString();
    }
}
