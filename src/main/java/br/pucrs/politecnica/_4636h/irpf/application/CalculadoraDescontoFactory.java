package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.TipoDesconto;

public class CalculadoraDescontoFactory {

    public CalculadoraDesconto getCalculadora(TipoDesconto tipoDesconto) {
        return tipoDesconto.calculadora();
    }
}
