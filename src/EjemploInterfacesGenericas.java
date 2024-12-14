import java.util.List;
import java.util.Random;

import v3InlaneClases.interfaces.*;
import v3InlaneClases.SuperFunciones;

public class EjemploInterfacesGenericas {
    public static void main(String[] args) {
        new EjemploInterfacesGenericas();
    }

    public EjemploInterfacesGenericas() {
        System.out.println("Programacion funcional");

        // 1. Generar elementos de la lista
        System.out.println("Numeros generados.");
        List<Integer> listaNumeros = SuperFunciones.proveer(10, new Provedor<>() {
            Random r = new Random();

            @Override
            public Integer obtener() {
                return r.nextInt(10);
            }
        });
        System.out.println(listaNumeros);
        System.out.println("----------------------------------");

        // 2. Filtrar solo los numeros pares
        List<Integer> filtrados = SuperFunciones.filtrar(listaNumeros, new Predicado<>() {
            @Override
            public boolean text(Integer valor) {
                return valor % 2 == 0;
            }
        });
        // mostrar
        System.out.println("Numeros filtrados.");
        System.out.println(filtrados);
        System.out.println("----------------------------------");

        // 3.A => Obtener el cuadrado de cada numero
        System.out.println("Mostrando la lista de Integer ");
        List<Integer> trasformados = SuperFunciones.transformar(filtrados, new OperadorUnario<Integer>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        });
        System.out.println(trasformados);
        System.out.println("----------------------------------");

        // 3.B => Obtener cada numero convertido en cadena
        System.out.println("Mostrando la lista de String");
        List<String> convertidosCadena = SuperFunciones.transformar(filtrados, new Funcion<Integer, String>() {
            @Override
            public String aplicar(Integer valor) {
                return "Valor: " + valor;
            }
        });
        convertidosCadena.forEach(System.out::println);
        System.out.println("----------------------------------");

        // / 4A. mostrar cada cuadrado por pantalla y retornar lista
        Consumidor<Integer> impresor = new Consumidor<>() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        };
        System.out.println("Numeros elevados al cuadrado");
        List<Integer> actuados = SuperFunciones.actuar(trasformados, impresor);
        System.out.println();

        // 4B. mostrar cada cuadrado por pantalla y no retornar lista
        System.out.println("Numeros elevados al cuadrado sin retorno.");
        SuperFunciones.consumir(trasformados, impresor);
        System.out.println("\n----------------------------------");

        // 5. obtener la suma
        Integer total = SuperFunciones.reducir(actuados, 0, new OperdorBinario<>() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        });
        System.out.println("Suma de los cuadrados es: " + total);
        System.out.println("\n----------------------------------");

    }
}
