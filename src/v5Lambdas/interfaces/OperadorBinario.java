package v5Lambdas.interfaces;
@FunctionalInterface
public interface OperadorBinario<T> {

    T aplicar(T total, T valor);

}
