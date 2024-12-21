package v10Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EjemploV10Stream {

    public static void main(String[] args) {
        new EjemploV10Stream();
    }

    public EjemploV10Stream() {
        List<String> nombres = new ArrayList<>(List.of("Manolo", "Pedro", "Baldomero"));
        // iteramos
        nombres.forEach(System.out::println);

        // para filtar
        System.out.println("Filtramos");
        // 1. funcion generadora del stream
        nombres.stream()
                // 2. 1 o mas operaciones intermedias
                .filter(t -> t.contains("p"))
                // 3. Operacion terminal
                .forEach(System.out::println);
    }

}
