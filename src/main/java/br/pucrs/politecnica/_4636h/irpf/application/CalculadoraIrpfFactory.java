package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.TipoCalculo;

public class CalculadoraIrpfFactory {

    public CalculadoraIrpf getCalculadora(TipoCalculo tipoCalculo) {
        return tipoCalculo.calculadora();
    }
}
