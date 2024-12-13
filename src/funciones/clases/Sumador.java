package funciones.clases;

import funciones.interfaces.FuncionBinaria;

public class Sumador
        implements FuncionBinaria {
    @Override
    public int aplicar(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }
}
