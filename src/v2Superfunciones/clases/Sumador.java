package v2Superfunciones.clases;

import v2Superfunciones.interfaces.FuncionBinaria;

public class Sumador
        implements FuncionBinaria {
    @Override
    public int aplicar(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }
}
