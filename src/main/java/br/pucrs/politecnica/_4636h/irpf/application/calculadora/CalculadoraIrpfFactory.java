package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.model.TipoCalculo;

public class CalculadoraIrpfFactory {

    private static final CalculadoraIrpf CALCULADORA_COMPLETO = new CalculadoraIrpfCompleto();
    private static final CalculadoraIrpf CALCULADORA_SIMPLIFICADO = new CalculadoraIrpfSimplificado();

    public CalculadoraIrpf getCalculadora(TipoCalculo tipoCalculo) {
        switch (tipoCalculo) {
            case COMPLETO: return CALCULADORA_COMPLETO;
            case SIMPLIFICADO: return CALCULADORA_SIMPLIFICADO;
            default: throw new IllegalArgumentException("TipoCalculo inválido: " + tipoCalculo);
        }
    }
}
