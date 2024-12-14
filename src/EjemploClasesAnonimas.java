import java.util.List;
import java.util.Random;

import v2Superfunciones.interfaces.*;
import v2Superfunciones.SuperFunciones;

public class EjemploClasesAnonimas {
    public static void main(String[] args) {
        new EjemploClasesAnonimas();
    }

    public EjemploClasesAnonimas() {
        System.out.println("Programacion funcional");

        // 1. Generar elementos de la lista
        System.out.println("Numeros generados.");
        List<Integer> listaNumeros = SuperFunciones.proveer(5, new Provedor() {
            Random r = new Random();
            @Override
            public Integer obtener() {
                return r.nextInt(10);
            }
        });
        listaNumeros.forEach(System.out::println);
        System.out.println("----------------------------------");

        // 2. Filtrar solo los numeros pares
        List<Integer> filtrados = SuperFunciones.filtrar(listaNumeros, new Predicado() {
            @Override
            public boolean text(Integer valor) {
                return valor % 2 == 0;
            }
        });
        // mostrar
        System.out.println("Numeros filtrados.");
        filtrados.forEach(System.out::println);
        System.out.println("----------------------------------");

        // 3. Obtener el cuadrado de cada numero
        System.out.println("Mostrando la lista: ");
        List<Integer> trasformados = SuperFunciones.transformar(filtrados, new Funcion() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        });
        System.out.println(trasformados);
        System.out.println("----------------------------------");

        Consumidor impresor = new Consumidor() {
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        };
        // 4A. mostrar cada cuadrado por pantalla y retornar lista
        System.out.println("Numeros elevados al cuadrado");
        List<Integer> actuados = SuperFunciones.actuar(trasformados, impresor);

        // 4B. mostrar cada cuadrado por pantalla y no retornar lista

        //SuperFunciones.consumir(trasformados, impresor);

        System.out.println("\n----------------------------------");

        // 5. obtener la suma
        int total = SuperFunciones.reducir( actuados , 0, new FuncionBinaria() {
            @Override
            public int aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        });
        System.out.println("Suma de los cuadrados es: " + total);
        System.out.println("\n----------------------------------");

    }

}
