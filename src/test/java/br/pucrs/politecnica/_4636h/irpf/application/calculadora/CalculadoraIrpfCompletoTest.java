package br.pucrs.politecnica._4636h.irpf.application.calculadora;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.Currency;
import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIrpfCompletoTest {

    /* Cálculo COMPLETO - Contribuinte NÃO-IDOSO com ATÉ DOIS DEPENDENTES */
    @Test
    public void validaCalculoContribuinteNaoIdosoComAteDoisDependentesImpostoFaixa1() {
        /*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 2% sobre 9.000,00 = 180,00
        Base Líquida = 9.000,00 - 180,00 = 8.820,00
        Imposto = ZERO, pois 8.820,00 <= 12.000,00
        */

        Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);
        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComAteDoisDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.ZERO, imposto);
    }

    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComAteDoisDependentesImpostoFaixa2() {
        /*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 2% sobre 18.000,00 = 360,00
        Base Líquida = 18.000,00 - 360,00 = 17.640,00
        Imposto = (17.640,00 - 12.000,00) * 0,15 = 846,00
        */

        Currency totalRendimentos = Currency.valueOf(20000.00);
        Currency contribuicao = Currency.valueOf(2000.00);
        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComAteDoisDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(846.00), imposto);
    }

    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComAteDoisDependentesImpostoFaixa3() {
    	 /*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 2% sobre 27.000,00 = 540,00
        Base Líquida = 27.000 - 540,00 = 26.460,00
        Imposto = (26.460 - 24.000,00) * 0,275 =  676,50 + 1.800 = 2.476,50
        */

        Currency totalRendimentos = Currency.valueOf(30000.00);
        Currency contribuicao = Currency.valueOf(3000.00);
        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComAteDoisDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(2476.50), imposto);

    }


    /* Cálculo COMPLETO - Contribuinte NÃO-IDOSO com TRÊS A CINCO DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComTresACincoDependentesImpostoFaixa1() {

    	/*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 3,5% sobre 9.000,00 = 315,00
        Base Líquida = 9.000,00 - 315,00 = 8.685,00
        Imposto = ZERO, pois 8.685,00 <= 12.000,00
        */

        Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);
        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComTresACincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.ZERO, imposto);


    }

    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComTresACincoDependentesImpostoFaixa2() {
    	/*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 3,5% sobre 18.000,00 = 630,00
        Base Líquida = 18.000,00 - 630,00 = 17.370,00
        Imposto = (17.370,00 - 12.000) * 0,15 = 805,50
        */

        Currency totalRendimentos = Currency.valueOf(20000.00);
        Currency contribuicao = Currency.valueOf(2000.00);

        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComTresACincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(805.50), imposto);
    }

    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComTresACincoDependentesImpostoFaixa3() {
    	/*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 3,5% sobre 27.000,00 = 945,00
        Base Líquida = 27.000,00 - 945,00 = 26.055,00
        Imposto = (26.055,00 - 24.000) * 0,275 = 565,12 + 1.800,00 = 2.365,13
                */
        Currency totalRendimentos = Currency.valueOf(30000.00);
        Currency contribuicao = Currency.valueOf(3000.00);

        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComTresACincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(2365.12), imposto);
    }

    /* Cálculo COMPLETO - Contribuinte NÃO-IDOSO com MAIS DE CINCO DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComMaisDeCincoDependentesImpostoFaixa1() {

		/*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 5% sobre 9.000,00 = 450,00
        Base Líquida = 9.000,00 - 450,00 = 8.550,00
        Imposto = ZERO, pois 8.550,00 <= 12.000,00
        */

        Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);

        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComMaisDeCincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.ZERO, imposto);

    }

    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComMaisDeCincoDependentesImpostoFaixa2() {

		/*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 5% sobre 18.000,00 = 900,00
        Base Líquida = 18.000,00 - 900,00 = 17.100,00
        Imposto = (17.100,00 - 12.000) * 0,15 = 765,00
        */

        Currency totalRendimentos = Currency.valueOf(20000.00);
        Currency contribuicao = Currency.valueOf(2000.00);

        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComMaisDeCincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(765.00), imposto);

    }

    @Test
    public void validaCalculoCompletoContribuinteNaoIdosoComMaisDeCincoDependentesImpostoFaixa3() {
    	/*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 5% sobre 27.000,00 = 1.350,00
        Base Líquida = 27.000,00 - 1.350,00 = 25.650,00
        Imposto = (25.650,00 - 24.000) * 0,275 = 453,75 + 1.800,00 =  2.253,75
        */

        Currency totalRendimentos = Currency.valueOf(30000.00);
        Currency contribuicao = Currency.valueOf(3000.00);

        Contribuinte contribuinte = qualquerContribuinteNaoIdosoComMaisDeCincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(2253.75), imposto);
    }

    /* Cálculo COMPLETO - Contribuinte IDOSO com ATÉ DOIS DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuinteIdosoComAteDoisDependentesImpostoFaixa1() {
    	/*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 3% sobre 9.000,00 = 270,00
        Base Líquida = 9.000,00 - 270,00 = 8.730,00
        Imposto = ZERO, pois 8.730,00 <= 12.000,00
        */

        Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);

        Contribuinte contribuinte = qualquerContribuinteIdosoComAteDoisDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.ZERO, imposto);
    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComAteDoisDependentesImpostoFaixa2() {
    	/*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 3% sobre 18.000,00 = 540,00
        Base Líquida = 18.000,00 - 540,00 = 17.460,00
        Imposto = (17.460,00 - 12.000) * 0,15 = 819,00
        */

        Currency totalRendimentos = Currency.valueOf(20000.00);
        Currency contribuicao = Currency.valueOf(2000.00);

        Contribuinte contribuinte = qualquerContribuinteIdosoComAteDoisDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(819.00), imposto);
    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComAteDoisDependentesImpostoFaixa3() {
    	/*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 3% sobre 27.000,00 = 810,00
        Base Líquida = 27.000,00 - 810,00 = 26.190,00
        Imposto = (26.190,00 - 24.000) * 0,275 = 602,25 + 1.800,00 =  2.402,25
        */

        Currency totalRendimentos = Currency.valueOf(30000.00);
        Currency contribuicao = Currency.valueOf(3000.00);

        Contribuinte contribuinte = qualquerContribuinteIdosoComAteDoisDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(2402.25), imposto);

    }

    /* Cálculo COMPLETO - Contribuinte IDOSO com TRÊS A CINCO DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuinteIdosoComTresACincoDependentesImpostoFaixa1() {

    	/*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 4,5% sobre 9.000,00 = 405,00
        Base Líquida = 9.000,00 - 405,00 = 8.595,00
        Imposto = ZERO, pois 8.595,00 <= 12.000,00
        */

        Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);

        Contribuinte contribuinte = qualquerContribuinteIdosoComTresACincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals((Currency.ZERO), imposto);
    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComTresACincoDependentesImpostoFaixa2() {
    	/*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 4,5% sobre 18.000,00 = 810,00
        Base Líquida = 18.000,00 - 810,00 = 17.190,00
        Imposto = (17.190,00 - 12.000,00) * 0,15 = 778,50
        */

        Currency totalRendimentos = Currency.valueOf(20000.00);
        Currency contribuicao = Currency.valueOf(2000.00);

        Contribuinte contribuinte = qualquerContribuinteIdosoComTresACincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(778.50), imposto);
    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComTresACincoDependentesImpostoFaixa3() {

    	/*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 4,5% sobre 27.000,00 = 1.215,00
        Base Líquida = 27.000,00 - 1.215,00 = 25.785,00
        Imposto = (25.785,00 - 24.000) * 0,275 = 490,87  + 1.800,00 =  2.290,88
        */

        Currency totalRendimentos = Currency.valueOf(30000.00);
        Currency contribuicao = Currency.valueOf(3000.00);

        Contribuinte contribuinte = qualquerContribuinteIdosoComTresACincoDependentes(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte);

        assertEquals(Currency.valueOf(2290.88), imposto);


    }

    /* Cálculo COMPLETO - Contribuinte IDOSO com MAIS DE CINCO DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuinteIdosoComMaisDeCincoDependentesImpostoFaixa1() {

    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComMaisDeCincoDependentesImpostoFaixa2() {

    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComMaisDeCincoDependentesImpostoFaixa3() {

    }

    private Contribuinte qualquerContribuinteNaoIdosoComAteDoisDependentes(Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinteNaoIdoso(2, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteNaoIdosoComTresACincoDependentes(Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinteNaoIdoso(4, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteNaoIdosoComMaisDeCincoDependentes(Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinteNaoIdoso(8, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteIdosoComAteDoisDependentes(Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinteIdoso(2, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteIdosoComTresACincoDependentes(Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinteIdoso(4, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteIdosoComMaisDeCincoDependentes(Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinteIdoso(8, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteNaoIdoso(int dependentes, Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinte(50, dependentes, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteIdoso(int dependentes, Currency totalRendimentos, Currency contribuicao) {
        return qualquerContribuinte(70, dependentes, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinte(int idade, int dependentes, Currency totalRendimentos, Currency contribuicao) {
        return new Contribuinte(qualquerPessoaFisica(idade), totalRendimentos, contribuicao, dependentes);
    }

    private PessoaFisica qualquerPessoaFisica(int idade) {
        return new PessoaFisica("Maria Silva", "00011122233", idade);
    }

    private CalculadoraIrpf calculadora = new CalculadoraIrpfCompleto();
}
