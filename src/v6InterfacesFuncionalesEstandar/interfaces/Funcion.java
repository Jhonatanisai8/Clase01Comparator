package v6InterfacesFuncionalesEstandar.interfaces;
// R PARA EL TIPO DE RETORNO
// T PARA EL TIPO DE VALOR QUE RICIBI COMO PARAMETRO
@FunctionalInterface
public interface Funcion <T, R> {

    R aplicar(T valor);

}