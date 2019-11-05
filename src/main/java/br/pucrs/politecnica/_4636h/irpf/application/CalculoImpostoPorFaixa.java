package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculoImpostoPorFaixa implements CalculoImposto {

    private static final Currency MARGEM_FAIXA1 = Currency.valueOf(12000.00); // R$12.000,00
    private static final Currency MARGEM_FAIXA2 = Currency.valueOf(24000.00); // R$24.000,00

    @Override
    public Currency calcular(Currency baseCalculo) {
        CalculoImposto calculoImposto;

        if (isBaseCalculoLessEqualsFaixa1(baseCalculo)) {
            calculoImposto = calculoImpostoFaixa1();
        } else if (isBaseCalculoLessThanFaixa2(baseCalculo)) {
            calculoImposto = calculoImpostoFaixa2();
        } else {
            calculoImposto = calculoImpostoFaixa3();
        }

        return calculoImposto.calcular(baseCalculo);
    }

    private boolean isBaseCalculoLessEqualsFaixa1(Currency baseCalculo) {
        return baseCalculo.compareTo(MARGEM_FAIXA1) <= 0;
    }

    private boolean isBaseCalculoLessThanFaixa2(Currency baseCalculo) {
        return baseCalculo.compareTo(MARGEM_FAIXA2) < 0;
    }

    private CalculoImposto calculoImpostoFaixa1() {
        return new CalculoImpostoFaixa1();
    }

    private CalculoImposto calculoImpostoFaixa2() {
        return new CalculoImpostoFaixa2();
    }

    private CalculoImposto calculoImpostoFaixa3() {
        return new CalculoImpostoFaixa3();
    }
}
