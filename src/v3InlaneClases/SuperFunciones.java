package v3InlaneClases;

import java.util.*;

import v3InlaneClases.interfaces.*;

public class SuperFunciones {
    public static <T> List<T> filtrar(List<T> valores, Predicado<T> predicado) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            if (predicado.text(valor)) {
                resultado.add(valor);
            }
        }
        return resultado;
    }

    public static <T> List<T> proveer(int tamanio, Provedor<T> provedor) {
        List<T> resultado = new ArrayList<>();
        for (int i = 0; i < tamanio; i++) {
            resultado.add(provedor.obtener());
        }
        return resultado;
    }

    public static <T, R> List<R> transformar(List<T> lista, Funcion<T, R> funcion) {
        List<R> resultado = new ArrayList<>();
        for (T valor : lista) {
            resultado.add(funcion.aplicar(valor));
        }
        return resultado;
    }

    public static <T> List<T> actuar(List<T> valores, Consumidor<T> consumidor) {
        for (T valor : valores) {
            consumidor.aceptar(valor);
        }
        return valores;
    }

    public static <T> void consumir(List<T> trasformados, Consumidor<T> consumidor) {
        for (T T : trasformados) {
            consumidor.aceptar(T);
        }
    }

    public static <T> T reducir(List<T> valores, T identidad, OperdorBinario<T> funcionBinaria) {
        T total = identidad;
        for (T valor : valores) {
            total = funcionBinaria.aplicar(total, valor);
        }
        return total;
    }
}
