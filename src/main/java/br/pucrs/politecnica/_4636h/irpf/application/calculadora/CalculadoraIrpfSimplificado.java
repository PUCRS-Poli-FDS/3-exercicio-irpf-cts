package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.application.calculadora.desconto.CalculadoraDesconto;

public class CalculadoraIrpfSimplificado extends CalculadoraIrpfBase {

    private static final double PERCENTUAL_DESCONTO = 0.05;

    public CalculadoraIrpfSimplificado() {
        super(calculadoraDesconto());
    }

    private static CalculadoraDesconto calculadoraDesconto() {
        return (contribuinte, baseCalculo) -> baseCalculo.multiply(PERCENTUAL_DESCONTO);
    }
}
