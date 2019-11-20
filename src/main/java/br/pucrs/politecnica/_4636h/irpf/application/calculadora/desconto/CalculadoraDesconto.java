package br.pucrs.politecnica._4636h.irpf.application.calculadora.desconto;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public interface CalculadoraDesconto {

    Currency calcular(Contribuinte contribuinte, Currency baseCalculo);

}
