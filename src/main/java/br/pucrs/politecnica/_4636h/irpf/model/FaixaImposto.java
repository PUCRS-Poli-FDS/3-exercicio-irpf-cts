package br.pucrs.politecnica._4636h.irpf.model;

public enum FaixaImposto {
    FAIXA_1(null, Currency.valueOf(12000.00)),
    FAIXA_2(Currency.valueOf(12000.01), Currency.valueOf(23999.99)),
    FAIXA_3(Currency.valueOf(24000.00), null);

    private final Currency min;
    private final Currency max;

    FaixaImposto(Currency min, Currency max) {
        this.min = min;
        this.max = max;
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
}
