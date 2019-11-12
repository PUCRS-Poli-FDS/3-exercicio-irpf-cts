package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.application.calculadora.desconto.CalculadoraDesconto;
import br.pucrs.politecnica._4636h.irpf.application.calculadora.desconto.CalculadoraDescontoCompleto;

public class CalculadoraIrpfCompleto extends CalculadoraIrpfBase {

    public CalculadoraIrpfCompleto() {
        super(calculadoraDesconto());
    }

    private static CalculadoraDesconto calculadoraDesconto() {
        return new CalculadoraDescontoCompleto();
    }
}
