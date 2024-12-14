package v4Flujo.interfaces;
// R PARA EL TIPO DE RETORNO
// T PARA EL TIPO DE VALOR QUE RICIBI COMO PARAMETRO
public interface Funcion <T, R> {

    R aplicar(T valor);

}