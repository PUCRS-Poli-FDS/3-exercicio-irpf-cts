package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculoDescontoSimplificado implements CalculoDesconto {

    private static final double PERCENTUAL_DESCONTO = 0.05; // 5%

    @Override
    public Currency calcular(Contribuinte contribuinte, Currency baseCalculo) {
        return baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }
}
