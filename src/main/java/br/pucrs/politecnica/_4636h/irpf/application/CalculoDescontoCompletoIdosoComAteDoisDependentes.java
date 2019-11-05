package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculoDescontoCompletoIdosoComAteDoisDependentes implements CalculoDesconto {

    private static final Double PERCENTUAL_DESCONTO = 0.02; // 2%

    @Override
    public Currency calcular(Contribuinte contribuinte, Currency baseCalculo) {
        return baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }
}
