package v10Streams;

public class Descripcion {
    private final Integer value;

    public Descripcion(Integer valor) {
        this.value = valor;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "V(" + value + ")";
    }
}
