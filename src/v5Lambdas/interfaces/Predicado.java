package v5Lambdas.interfaces;

@FunctionalInterface
public interface Predicado<T> {

    boolean text(T valor);
}
