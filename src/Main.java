import java.util.List;
import funciones.SuperFunciones;
import funciones.clases.AlCuadrado;
import funciones.clases.AlCubo;
import funciones.clases.Aleatorio;
import funciones.clases.Impresor;
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
        List<Integer> listaNumeros = SuperFunciones.proveer(10, new Aleatorio());
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
        System.out.println("Mostrando la lista: ");
        List<Integer> trasformados = SuperFunciones.transformar(filtrados, new AlCubo());
        // mostramos
        System.out.println("----------------------------------");
        
        //para mostrar la lista 
        System.out.println("Numeros elevados al cuadrado");
        List<Integer> mostrados = SuperFunciones.actuar(trasformados, new Impresor());
        System.out.println("\n----------------------------------");
        
    }

}
