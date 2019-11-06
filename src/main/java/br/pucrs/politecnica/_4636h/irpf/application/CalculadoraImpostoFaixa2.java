package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Currency;
import br.pucrs.politecnica._4636h.irpf.model.FaixaImposto;

public class CalculadoraImpostoFaixa2 implements CalculadoraImposto {

    private static final double PERCENTUAL_IMPOSTO = 0.15; // 15%

    @Override
    public Currency calcular(Currency baseCalculo) {
        return excedente(baseCalculo).multiply(PERCENTUAL_IMPOSTO);
    }

    private Currency excedente(Currency baseCalculo) {
        return baseCalculo.subtract(FaixaImposto.FAIXA_1.max());
    }
}
