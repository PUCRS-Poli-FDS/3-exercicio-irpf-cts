package br.pucrs.politecnica._4636h.irpf.model;

import br.pucrs.politecnica._4636h.irpf.application.CalculadoraImposto;
import br.pucrs.politecnica._4636h.irpf.application.CalculadoraImpostoFaixa2;
import br.pucrs.politecnica._4636h.irpf.application.CalculadoraImpostoFaixa3;
import com.sun.istack.internal.Nullable;

public enum FaixaImposto {
    FAIXA_1(baseCalculo -> Currency.ZERO, null, Currency.valueOf(12000.00)),
    FAIXA_2(new CalculadoraImpostoFaixa2(), Currency.valueOf(12000.01), Currency.valueOf(23999.99)),
    FAIXA_3(new CalculadoraImpostoFaixa3(), Currency.valueOf(24000.00), null);

    private final CalculadoraImposto calculadora;
    private final Currency min;
    private final Currency max;

    FaixaImposto(CalculadoraImposto calculadora, @Nullable Currency min, @Nullable Currency max) {
        this.calculadora = calculadora;
        this.min = min;
        this.max = max;
    }

    public CalculadoraImposto getCalculadora() {
        return calculadora;
    }

    public Currency min() {
        return min;
    }

    public Currency max() {
        return max;
    }

    public boolean isValueWithinFaixa(Currency value) {
        boolean greatEqualsMin = (min == null) || (value.compareTo(min) >= 0);
        boolean lessEqualsMax = (max == null) || (value.compareTo(max) <= 0);
        return greatEqualsMin && lessEqualsMax;
    }

    public static FaixaImposto getFaixa(Currency value) {
        for (FaixaImposto faixa : FaixaImposto.values()) {
            if (faixa.isValueWithinFaixa(value)) {
                return faixa;
            }
        }

        throw new IllegalArgumentException("Invalid value");
    }
}
