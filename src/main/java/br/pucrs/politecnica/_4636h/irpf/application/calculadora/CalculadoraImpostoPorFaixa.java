package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.model.Currency;
import br.pucrs.politecnica._4636h.irpf.model.FaixaImposto;

public class CalculadoraImpostoPorFaixa implements CalculadoraImposto {

    private static final double PERCENTUAL_IMPOSTO_FAIXA2 = 0.15;
    private static final double PERCENTUAL_IMPOSTO_FAIXA3 = 0.275;

    @Override
    public Currency calcular(Currency baseCalculo) {
        return getCalculadora(baseCalculo).calcular(baseCalculo);
    }

    private CalculadoraImposto getCalculadora(Currency baseCalculo) {
        CalculadoraImposto calculadoraImposto;

        if (isBaseCalculoWithinFaixa1(baseCalculo)) {
            calculadoraImposto = calculadoraImpostoFaixa1();
        } else if (isBaseCalculoWithinFaixa2(baseCalculo)) {
            calculadoraImposto = calculadoraImpostoFaixa2();
        } else {
            calculadoraImposto = calculadoraImpostoFaixa3();
        }

        return calculadoraImposto;
    }

    private boolean isBaseCalculoWithinFaixa1(Currency baseCalculo) {
        return FaixaImposto.FAIXA_1.isValueWithinFaixa(baseCalculo);
    }

    private boolean isBaseCalculoWithinFaixa2(Currency baseCalculo) {
        return FaixaImposto.FAIXA_2.isValueWithinFaixa(baseCalculo);
    }

    private CalculadoraImposto calculadoraImpostoFaixa1() {
        return baseCalculo -> Currency.ZERO;
    }

    private CalculadoraImposto calculadoraImpostoFaixa2() {
        return baseCalculo -> baseCalculo.subtract(FaixaImposto.FAIXA_1.max()).multiply(PERCENTUAL_IMPOSTO_FAIXA2);
    }

    private CalculadoraImposto calculadoraImpostoFaixa3() {
        final Currency TETO_FAIXA2 = Currency.valueOf(1800.00);

        return new CalculadoraImposto() {
            @Override
            public Currency calcular(Currency baseCalculo) {
                return TETO_FAIXA2.add(impostoFaixa3(baseCalculo));
            }

            private Currency impostoFaixa3(Currency baseCalculo) {
                return baseCalculo.subtract(FaixaImposto.FAIXA_3.min()).multiply(PERCENTUAL_IMPOSTO_FAIXA3);
            }
        };
    }
}
