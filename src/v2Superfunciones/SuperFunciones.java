package v2Superfunciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import v2Superfunciones.interfaces.Funcion;
import v2Superfunciones.interfaces.Predicado;
import v2Superfunciones.interfaces.Provedor;
import v3InlaneClases.interfaces.FuncionBinaria;
import v2Superfunciones.interfaces.Consumidor;

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

    public static List<Integer> transformar(List<Integer> lista, Funcion funcion) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer valor : lista) {
            resultado.add(funcion.aplicar(valor));
        }
        return resultado;
    }

    public static List<Integer> actuar(List<Integer> valores, Consumidor consumidor) {
        for (Integer valor : valores) {
            consumidor.aceptar(valor);
        }
        return valores;
    }

    public static void consumir(List<Integer> trasformados, Consumidor consumidor) {
        for (Integer integer : trasformados) {
            consumidor.aceptar(integer);
        }
    }

    public static Integer reducir(List<Integer> valores,Integer identidad, FuncionBinaria funcionBinaria) {
        int total = identidad;
        for (Integer valor : valores) {
            total = funcionBinaria.aplicar(total,valor);
        }
        return total;
    }
}
