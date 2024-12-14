package v4Flujo;

import java.util.*;

import v4Flujo.interfaces.*;

public class Flujo <T> {
    private final List<T> valores;

    public Flujo(List<T> valores) {
        this.valores = valores;
    }

    public static <T> Flujo<T> proveer(int tamanio, Provedor<T> provedor) {
        List<T> resultado = new ArrayList<>();
        for (int i = 0; i < tamanio; i++) {
            resultado.add(provedor.obtener());
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> filtrar(Predicado<T> predicado) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            if (predicado.text(valor)) {
                resultado.add(valor);
            }
        }
        return new Flujo<>(resultado);
    }

    public <R> Flujo<R> transformar(Funcion<T, R> funcion) {
        List<R> resultado = new ArrayList<>();
        for (T valor : valores) {
            resultado.add(funcion.aplicar(valor));
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> actuar(Consumidor<T> consumidor) {
        for (T valor : valores) {
            consumidor.aceptar(valor);
        }
        return new Flujo<>(valores);
    }

    public void consumir(Consumidor<T> consumidor) {
        for (T T : valores) {
            consumidor.aceptar(T);
        }

    }

    public T reducir(T identidad, OperadorBinario<T> funcionBinaria) {
        T total = identidad;
        for (T valor : valores) {
            total = funcionBinaria.aplicar(total, valor);
        }
        return total;
    }

    @Override
    public String toString() {
        return valores.toString();
    }
}
