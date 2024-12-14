package v5Lambdas.interfaces;

@FunctionalInterface
public interface Consumidor <T> {

	void aceptar(T valor);

}
