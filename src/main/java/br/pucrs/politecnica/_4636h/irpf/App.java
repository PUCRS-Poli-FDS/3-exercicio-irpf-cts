package br.pucrs.politecnica._4636h.irpf;

import br.pucrs.politecnica._4636h.irpf.application.calculadora.CalculadoraIrpf;
import br.pucrs.politecnica._4636h.irpf.application.calculadora.CalculadoraIrpfFactory;
import br.pucrs.politecnica._4636h.irpf.model.TipoCalculo;
import br.pucrs.politecnica._4636h.irpf.view.Menu;

public class App {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.exibir();

        CalculadoraIrpf calculo = new CalculadoraIrpfFactory().getCalculadora(TipoCalculo.COMPLETO);
    }

}
