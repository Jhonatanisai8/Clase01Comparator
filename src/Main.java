import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import funciones.SuperFunciones;
import funciones.clases.Aleatorio;
import funciones.clases.Naturales;
import funciones.clases.SoloImpares;
import funciones.clases.SoloPares;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        System.out.println("Programacion funcional");
        // crear la lista de enteros
        List<Integer> listaNumeros = SuperFunciones.proveer(8, new Naturales());
        System.out.println("Numeros generados.");
        listaNumeros.forEach(System.out::println);
        System.out.println("----------------------------------");
        // quedarme con solo los pares
        List<Integer> filtrados = SuperFunciones.filtrar(listaNumeros, new SoloPares());
        // mostrar
        System.out.println("Numeros filtrados.");
        filtrados.forEach(System.out::println);
        System.out.println("----------------------------------");

        // pasar cada numero al cuadrado
        List<Integer> listaNumerosCuadros = pasarListaCuadrado(filtrados);
        // mostramos
        System.out.println("CUADRADO");
        List<Integer> mostrarLista = mostrarLista(listaNumerosCuadros);
        // obtenemos la suma de los cuadros
        int suma = obtenerSumaCuadrados(listaNumerosCuadros);
        System.out.println("SUMA DE LOS CUADRADOS: " + suma);
    }

    private List<Integer> mostrarLista(List<Integer> listaNumerosCuadros) {
        for (int i = 0; i < listaNumerosCuadros.size(); i++) {
            System.out.println(listaNumerosCuadros.get(i));
        }
        return listaNumerosCuadros;
    }

    private int obtenerSumaCuadrados(List<Integer> listaNumerosCuadros) {
        int suma = 0;
        for (int i = 0; i < listaNumerosCuadros.size(); i++) {
            suma += listaNumerosCuadros.get(i);
        }
        return suma;
    }

    private List<Integer> pasarListaCuadrado(List<Integer> listaPares) {
        int resultadoCuadrado;
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < listaPares.size(); i++) {
            resultadoCuadrado = (int) Math.pow(listaPares.get(i), 2);
            lista.add(resultadoCuadrado);
        }
        return lista;
    }

}
