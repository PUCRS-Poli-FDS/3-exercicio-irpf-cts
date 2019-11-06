package br.pucrs.politecnica._4636h.irpf.application;

public class CalculadoraIrpfSimplificado extends CalculadoraIrpfBase {

    public CalculadoraIrpfSimplificado() {
        super(calculoDescontoSimplificado());
    }

    private static CalculadoraDesconto calculoDescontoSimplificado() {
        return new CalculadoraDescontoSimplificado();
    }
}
