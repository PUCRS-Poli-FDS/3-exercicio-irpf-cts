package br.pucrs.politecnica._4636h.irpf.model;

import br.pucrs.politecnica._4636h.irpf.application.CalculadoraDesconto;
import br.pucrs.politecnica._4636h.irpf.application.CalculadoraDescontoCompleto;
import br.pucrs.politecnica._4636h.irpf.application.CalculadoraDescontoSimplificado;

public enum TipoDesconto {

    COMPLETO(new CalculadoraDescontoCompleto()),
    SIMPLIFICADO(new CalculadoraDescontoSimplificado());

    private final CalculadoraDesconto calculadora;

    TipoDesconto(CalculadoraDesconto calculadora) {
        this.calculadora = calculadora;
    }

    public CalculadoraDesconto calculadora() {
        return calculadora;
    }
}
