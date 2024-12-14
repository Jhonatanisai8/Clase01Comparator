package v5Lambdas.interfaces;

@FunctionalInterface
public interface Funcion<T1, T2> {

    T2 aplicar(T1 valor);

}
