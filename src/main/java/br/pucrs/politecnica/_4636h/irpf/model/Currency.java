package br.pucrs.politecnica._4636h.irpf.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Currency {

    public static final Currency ZERO = Currency.valueOf(0);

    private final BigDecimal value;

    public Currency(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency add(Currency value) { return valueOf(this.value.add(value.getValue())); }

    public Currency subtract(Currency value) { return valueOf(this.value.subtract(value.getValue())); }

    public Currency multiply(double value) { return valueOf(this.value.multiply(BigDecimal.valueOf(value))); }

    public int compareTo(Currency value) { return this.value.compareTo(value.getValue()); }

    public static Currency valueOf(long value) { return valueOf(BigDecimal.valueOf(value)); }

    public static Currency valueOf(double value) { return valueOf(BigDecimal.valueOf(value)); }

    public static Currency valueOf(BigDecimal value) {
        BigDecimal newone = value.setScale(2, RoundingMode.HALF_EVEN);
        return new Currency(newone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(value, currency.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "value=" + value +
                '}';
    }
}
