package funciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import funciones.interfaces.Predicado;
import funciones.interfaces.Provedor;

public class SuperFunciones {
    public static List<Integer> filtrar(List<Integer> valores, Predicado predicado) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer valor : valores) {
            if (predicado.text(valor)) {
                resultado.add(valor);
            }
        }
        return resultado;
    }

    public static List<Integer> proveer(int tamanio, Provedor provedor) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 0; i < tamanio; i++) {
            resultado.add(provedor.obtener());
        }
        return resultado;
    }
}
