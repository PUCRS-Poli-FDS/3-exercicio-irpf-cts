package br.pucrs.politecnica._4636h.irpf.application;

import br.pucrs.politecnica._4636h.irpf.model.TipoCalculo;

public class CalculoIrpfFactory {

    public CalculoIrpf getCalculo(TipoCalculo tipoCalculo) {
        CalculoIrpf calculoIrpf = null;

        switch (tipoCalculo) {
            case COMPLETO:
                calculoIrpf = new CalculoIrpfCompleto();
            case SIMPLIFICADO:
                calculoIrpf = new CalculoIrpfSimplificado();
        }

        return calculoIrpf;
    }
}
