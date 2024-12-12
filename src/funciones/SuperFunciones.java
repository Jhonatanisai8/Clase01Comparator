package funciones;

import java.util.ArrayList;
import java.util.List;

import funciones.interfaces.Predicado;

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
}
