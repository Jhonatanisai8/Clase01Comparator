package v4Flujo.interfaces;

/*
 * T => TIPO DEL PRIMER VALOR 
 * U => SEGUNDO VALOR 
 * R => TIPO DE RETORNO
 */
public interface FuncionBinaria<T, U, R> {

    R aplicar(T valor1, U valor2);

}
