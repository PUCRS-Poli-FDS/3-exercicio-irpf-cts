package br.pucrs.politecnica._4636h.irpf.application;

public class CalculadoraIrpfCompleto extends CalculadoraIrpfBase {

    public CalculadoraIrpfCompleto() {
        super(calculoDescontoCompleto());
    }

    private static CalculadoraDesconto calculoDescontoCompleto() {
        return new CalculadoraDescontoCompleto();
    }
}
