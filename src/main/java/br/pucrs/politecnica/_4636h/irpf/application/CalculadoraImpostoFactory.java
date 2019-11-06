package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Currency;
import br.pucrs.politecnica._4636h.irpf.model.FaixaImposto;

public class CalculadoraImpostoFactory {

    public CalculadoraImposto getCalculadora(Currency baseCalculo) {
        return FaixaImposto.getFaixa(baseCalculo).getCalculadora();
    }
}
