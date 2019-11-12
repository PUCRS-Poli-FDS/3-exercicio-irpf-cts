package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIrpfSimplificadoTest {

    /* Cálculo SIMPLIFICADO */
    @Test
    public void validaCalculoSimplificadoImpostoFaixa1() {
        /*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 5% sobre 9.000,00 = 450,00
        Base Líquida = 9.000,00 - 450,00 = 8.550,00
        Imposto = ZERO, pois 8.550,00 <= 12.000,00
        */

        Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);
        Contribuinte contribuinte = qualquerContribuinte(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.ZERO, imposto);
    }

    @Test
    public void validaCalculoSimplificadoImpostoFaixa2() {
        /*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 5% sobre 18.000,00 = 900,00
        Base Liquida = 18.000,00 - 900,00 = 17.100,00
        Imposto = (17.100,00 - 12.000,00) * 0,15 = 5.100,00 * 0,15 = 765,00
        */

        Currency totalRendimentos = Currency.valueOf(20000.00);
        Currency contribuicao = Currency.valueOf(2000.00);
        Contribuinte contribuinte = qualquerContribuinte(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(765.00), imposto);
    }

    @Test
    public void validaCalculoSimplificadoImpostoFaixa3() {
        /*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 5% sobre 27.000,00 = 1.350,00
        Base Liquida = 27.000,00 - 1.350,00 = 25.650,00
        Imposto = Imposto máximo Faixa 2 (1.800,00) + [(25.650,00 - 24.000,00) * 0,275]
                = 1.800,00 + (1.650,00 * 0,275)
                = 1.800,00 + 453,75
                = 2.253,75
        */

        Currency totalRendimentos = Currency.valueOf(30000.00);
        Currency contribuicao = Currency.valueOf(3000.00);
        Contribuinte contribuinte = qualquerContribuinte(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(2253.75), imposto);

    }

    private Contribuinte qualquerContribuinte(Currency totalRendimentos, Currency contribuicao) {
        return new Contribuinte("Maria Silva", "00011122233", 40, totalRendimentos, contribuicao);
    }

    private CalculadoraIrpf calculadora = new CalculadoraIrpfSimplificado();
}
