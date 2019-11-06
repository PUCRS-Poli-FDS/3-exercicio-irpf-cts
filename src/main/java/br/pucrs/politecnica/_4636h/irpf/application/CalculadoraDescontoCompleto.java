package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculadoraDescontoCompleto implements CalculadoraDesconto {

    private static final Integer IDADE_IDOSO = 65;

    @Override
    public Currency calcular(Contribuinte contribuinte, Currency baseCalculo) {
        CalculadoraDesconto calculadoraDesconto;

        if (isIdoso(contribuinte)) {
            calculadoraDesconto = new CalculadoraDescontoCompletoIdoso();
        } else {
            calculadoraDesconto = new CalculadoraDescontoCompletoNaoIdoso();
        }

        return calculadoraDesconto.calcular(contribuinte, baseCalculo);
    }

    private static boolean isIdoso(Contribuinte contribuinte) {
        return contribuinte.getIdade() >= IDADE_IDOSO;
    }
}
