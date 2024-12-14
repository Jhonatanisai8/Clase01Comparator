import java.util.*;

import v4Flujo.Flujo;
import v4Flujo.interfaces.*;

public class EjemploFlujoV4 {
    public static void main(String[] args) {
        new EjemploFlujoV4();
    }

    public EjemploFlujoV4() {

        // proveer().filtrar().transformar().actuar().reducir();

        System.out.println("Programacion funcional");

        // 1. Generar elementos de la lista
        System.out.println("Numeros generados.");
        Flujo<Integer> numeros = Flujo.proveer(10, new Provedor<>() {
            Random r = new Random();

            @Override
            public Integer obtener() {
                return r.nextInt(10);
            }
        });
        System.out.println(numeros);
        System.out.println("----------------------------------");

        // 2. Filtrar solo los numeros pares
        Flujo<Integer> filtrados = numeros.filtrar(new Predicado<>() {
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
        Flujo<Integer> trasformados = filtrados.transformar(new OperadorUnario<Integer>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        });
        System.out.println(trasformados);
        System.out.println("----------------------------------");

        // 3.B => Obtener cada numero convertido en cadena
        System.out.println("Mostrando la lista de String");
        Flujo<String> convertidosCadena = filtrados.transformar(new Funcion<Integer, String>() {
            @Override
            public String aplicar(Integer valor) {
                return "Valor: " + valor;
            }
        });
        System.out.println(convertidosCadena);
        System.out.println("----------------------------------");

        // / 4A. mostrar cada cuadrado por pantalla y retornar lista
        Consumidor<Integer> impresor = new Consumidor<>() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        };
        System.out.println("Numeros elevados al cuadrado");
        Flujo<Integer> actuados = trasformados.actuar(impresor);
        System.out.println();

        // 4B. mostrar cada cuadrado por pantalla y no retornar lista
        System.out.println("Numeros elevados al cuadrado sin retorno.");
        trasformados.consumir(impresor);
        System.out.println("\n----------------------------------");

        // 5. obtener la suma
        Integer total = actuados.reducir(0, new OperadorBinario<>() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        });
        System.out.println("Suma de los cuadrados es: " + total);
        System.out.println("\n----------------------------------");
    }
}
