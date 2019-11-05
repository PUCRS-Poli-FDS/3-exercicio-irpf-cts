package br.pucrs.politecnica._4636h.irpf.application;

public class CalculoIrpfSimplificado extends CalculoIrpfBase {

    public CalculoIrpfSimplificado() {
        super(calculoDescontoSimplificado());
    }

    private static CalculoDesconto calculoDescontoSimplificado() {
        return new CalculoDescontoSimplificado();
    }
}
