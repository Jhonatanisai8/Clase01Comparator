import java.util.List;

import v2Superfunciones.clases.AlCuadrado;
import v2Superfunciones.clases.AlCubo;
import v2Superfunciones.clases.Aleatorio;
import v2Superfunciones.clases.Impresor;
import v2Superfunciones.clases.Naturales;
import v2Superfunciones.clases.SoloImpares;
import v2Superfunciones.clases.SoloPares;
import v2Superfunciones.clases.Sumador;
import v2Superfunciones.SuperFunciones;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        System.out.println("Programacion funcional");

        // 1. Generar elementos de la lista
        List<Integer> listaNumeros = SuperFunciones.proveer(5, new Naturales());
        System.out.println("Numeros generados.");
        listaNumeros.forEach(System.out::println);
        System.out.println("----------------------------------");

        // 2. Filtrar solo los numeros pares
        List<Integer> filtrados = SuperFunciones.filtrar(listaNumeros, new SoloPares());
        // mostrar
        System.out.println("Numeros filtrados.");
        filtrados.forEach(System.out::println);
        System.out.println("----------------------------------");

        // 3. Obtener el cuadrado de cada numero
        System.out.println("Mostrando la lista: ");
        List<Integer> trasformados = SuperFunciones.transformar(filtrados, new AlCubo());
        System.out.println(trasformados);
        System.out.println("----------------------------------");

        // 4A. mostrar cada cuadrado por pantalla y retornar lista
        System.out.println("Numeros elevados al cuadrado");
        List<Integer> actuados = SuperFunciones.actuar(trasformados, new Impresor());

        // 4B. mostrar cada cuadrado por pantalla y no retornar lista
        // SuperFunciones.consumir(trasformados, new Impresor());
        System.out.println("\n----------------------------------");

        // 5. obtener la suma
        int suma = SuperFunciones.reducir(actuados, 0, new Sumador());
        System.out.println("Suma de los cuadrados es: " + suma);
        System.out.println("\n----------------------------------");

    }

}
