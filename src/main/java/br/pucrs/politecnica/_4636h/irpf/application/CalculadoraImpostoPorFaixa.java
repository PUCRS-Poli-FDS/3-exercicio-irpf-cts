package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class CalculadoraImpostoPorFaixa implements CalculadoraImposto {

    private static final Currency MARGEM_FAIXA1 = Currency.valueOf(12000.00); // R$12.000,00
    private static final Currency MARGEM_FAIXA2 = Currency.valueOf(24000.00); // R$24.000,00

    @Override
    public Currency calcular(Currency baseCalculo) {
        CalculadoraImposto calculadoraImposto;

        if (isBaseCalculoLessEqualsFaixa1(baseCalculo)) {
            calculadoraImposto = calculoImpostoFaixa1();
        } else if (isBaseCalculoLessThanFaixa2(baseCalculo)) {
            calculadoraImposto = calculoImpostoFaixa2();
        } else {
            calculadoraImposto = calculoImpostoFaixa3();
        }

        return calculadoraImposto.calcular(baseCalculo);
    }

    private boolean isBaseCalculoLessEqualsFaixa1(Currency baseCalculo) {
        return baseCalculo.compareTo(MARGEM_FAIXA1) <= 0;
    }

    private boolean isBaseCalculoLessThanFaixa2(Currency baseCalculo) {
        return baseCalculo.compareTo(MARGEM_FAIXA2) < 0;
    }

    private CalculadoraImposto calculoImpostoFaixa1() {
        return new CalculadoraImpostoFaixa1();
    }

    private CalculadoraImposto calculoImpostoFaixa2() {
        return new CalculadoraImpostoFaixa2();
    }

    private CalculadoraImposto calculoImpostoFaixa3() {
        return new CalculadoraImpostoFaixa3();
    }
}
