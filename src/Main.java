import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import funciones.SuperFunciones;
import funciones.clases.AlCuadrado;
import funciones.clases.AlCubo;
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
        List<Integer> listaNumeros = SuperFunciones.proveer(10, new Naturales());
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
        List<Integer> trasformados = SuperFunciones.transformar(filtrados, new AlCubo());
        // mostramos
        System.out.println("Numeros elevados al cuadrado");
        List<Integer> mostrarLista = mostrarLista(trasformados);
        System.out.println("----------------------------------");
    }

    private List<Integer> mostrarLista(List<Integer> listaNumerosCuadros) {
        for (int i = 0; i < listaNumerosCuadros.size(); i++) {
            System.out.println(listaNumerosCuadros.get(i));
        }
        return listaNumerosCuadros;
    }

}
