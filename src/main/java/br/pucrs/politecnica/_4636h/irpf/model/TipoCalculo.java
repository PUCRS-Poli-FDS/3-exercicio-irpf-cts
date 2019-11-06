package br.pucrs.politecnica._4636h.irpf.model;

import br.pucrs.politecnica._4636h.irpf.application.CalculadoraIrpf;
import br.pucrs.politecnica._4636h.irpf.application.CalculadoraIrpfCompleto;
import br.pucrs.politecnica._4636h.irpf.application.CalculadoraIrpfSimplificado;

public enum TipoCalculo {

    COMPLETO(new CalculadoraIrpfCompleto()),
    SIMPLIFICADO(new CalculadoraIrpfSimplificado());

    private final CalculadoraIrpf calculadora;

    TipoCalculo(CalculadoraIrpf calculadora) {
        this.calculadora = calculadora;
    }

    public CalculadoraIrpf calculadora() {
        return calculadora;
    }
}
