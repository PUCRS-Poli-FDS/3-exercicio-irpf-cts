package br.pucrs.politecnica._4636h.irpf.application;

public class CalculoIrpfCompleto extends CalculoIrpfBase {

    public CalculoIrpfCompleto() {
        super(calculoDescontoCompleto());
    }

    private static CalculoDesconto calculoDescontoCompleto() {
        return new CalculoDescontoCompleto();
    }
}
