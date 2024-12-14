package v1Emperativa;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        new App();
    }

    public App() {
        // crear la lista de enteros
        List<Integer> listaNumeros = crearLista();
        listaNumeros.forEach(System.out::println);
        System.out.println("===");
        // quedarme con solo los pares
        List<Integer> listaPares = soloPares(listaNumeros);
        // mostrar
        listaPares.forEach(System.out::println);
        // pasar cada numero al cuadrado
        List<Integer> listaNumerosCuadros = pasarListaCuadrado(listaPares);
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

    private List<Integer> soloPares(List<Integer> listaNumeros) {
        for (int i = 0; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i) / 2 != 0) {
                listaNumeros.remove(i);
            }
        }
        return listaNumeros;
    }

    private List<Integer> crearLista() {
        List<Integer> listaNumeros = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int numeroGenerado = random.nextInt(10) + 1;
            listaNumeros.add(numeroGenerado);
        }
        return listaNumeros;
    }

}
