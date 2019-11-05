package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculoDescontoCompleto implements CalculoDesconto {

    private static final Integer IDADE_IDOSO = 65;

    @Override
    public Currency calcular(Contribuinte contribuinte, Currency baseCalculo) {
        CalculoDesconto calculoDesconto;

        if (isIdoso(contribuinte)) {
            calculoDesconto = new CalculoDescontoCompletoIdoso();
        } else {
            calculoDesconto = new CalculoDescontoCompletoNaoIdoso();
        }

        return calculoDesconto.calcular(contribuinte, baseCalculo);
    }

    private static boolean isIdoso(Contribuinte contribuinte) {
        return contribuinte.getIdade() >= IDADE_IDOSO;
    }
}
