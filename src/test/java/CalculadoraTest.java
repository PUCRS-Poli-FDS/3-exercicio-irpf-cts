
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CalculadoraTest {

    /* Cálculo COMPLETO - Contribuinte PADRÃO com ATÉ DOIS DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuintePadraoComAteDoisDependentesImpostoFaixa1() {
        /*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 2% sobre 9.000,00 = 180,00
        Base Líquida = 9.000,00 - 180,00 = 8.820,00
        Imposto = ZERO, pois 8.820,00 <= 12.000,00
        */

        Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);
        Contribuinte contribuinte = qualquerContribuinteSimplificado(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte, "completo");

        assertEquals(Currency.ZERO, imposto);
    }

    @Test
    public void validaCalculoCompletoContribuintePadraoComAteDoisDependentesImpostoFaixa2() {
        /*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 2% sobre 18.000,00 = 360,00
        Base Líquida = 18.000,00 - 360,00 = 17.640,00
        Imposto = (17.640,00 - 12.000,00) * 0,15 = 846,00
        */

        Currency totalRendimentos = Currency.valueOf(20000.00);
        Currency contribuicao = Currency.valueOf(2000.00);
        Contribuinte contribuinte = qualquerContribuinteSimplificado(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte, "completo");

        assertEquals(Currency.valueOf(846.00), imposto);
    }

    @Test
    public void validaCalculoCompletoContribuintePadraoComAteDoisDependentesImpostoFaixa3() {
    	 /*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 2% sobre 27.000,00 = 540,00
        Base Líquida = 27.000 - 540,00 = 26.460,00
        Imposto = (26.460 - 24.000,00) * 0,275 =  676,50 + 1.800 = 2.476,50
        */
    	
    	Currency totalRendimentos = Currency.valueOf(30000.00);
    	Currency contribuicao = Currency.valueOf(3000.00);
    	Contribuinte contribuinte = qualquerContribuinteSimplificado(totalRendimentos, contribuicao);

    	Currency imposto = calculadora.calcular(contribuinte, "completo");
    	
    	assertEquals(Currency.valueOf(2476.50), imposto);
    	
    }


    /* Cálculo COMPLETO - Contribuinte PADRÃO com TRÊS A CINCO DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuintePadraoComTresACincoDependentesImpostoFaixa1() {

    	/*
        Base Calculo = 10.000,00 - 1.000,00 = 9.000,00
        Desconto = 3,5% sobre 9.000,00 = 315,00
        Base Líquida = 9.000,00 - 315,00 = 8.685,00
        Imposto = ZERO, pois 8.685,00 <= 12.000,00
        */
    	
    	Currency totalRendimentos = Currency.valueOf(10000.00);
        Currency contribuicao = Currency.valueOf(1000.00);
        Contribuinte contribuinte = qualquerContribuinteCompleto(40, 4, totalRendimentos, contribuicao);
        
        Currency imposto = calculadora.calcular(contribuinte, "completo");

        assertEquals(Currency.ZERO, imposto);
        
        
    }

    @Test
    public void validaCalculoCompletoContribuintePadraoComTresACincoDependentesImpostoFaixa2() {
    	/*
        Base Calculo = 20.000,00 - 2.000,00 = 18.000,00
        Desconto = 3,5% sobre 18.000,00 = 630,00
        Base Líquida = 18.000,00 - 630,00 = 17.370,00
        Imposto = (17.370,00 - 12.000) * 0,15 = 805,50
        */
    	
    	Currency totalRendimentos = Currency.valueOf(20000.00);
    	Currency contribuicao = Currency.valueOf(2000.00);
    	
    	Contribuinte contribuinte = qualquerContribuinteCompleto(40, 5, totalRendimentos, contribuicao);
    	
    	Currency imposto = calculadora.calcular(contribuinte, "completo");    	
    	
    	assertEquals(Currency.valueOf(805.50), imposto);
    }

    @Test
    public void validaCalculoCompletoContribuintePadraoComTresACincoDependentesImpostoFaixa3() {
    	/*
        Base Calculo = 30.000,00 - 3.000,00 = 27.000,00
        Desconto = 3,5% sobre 27.000,00 = 945,00
        Base Líquida = 27.000,00 - 945,00 = 26.055,00
        Imposto = (26.055,00 - 24.000) * 0,275 = 565,12 + 1.800,00 = 2.365,13
                */
    	Currency totalRendimentos = Currency.valueOf(30000.00);
    	Currency contribuicao = Currency.valueOf(3000.00);
    	
    	Contribuinte contribuinte = qualquerContribuinteCompleto(45, 3, totalRendimentos, contribuicao);
    	
    	Currency imposto = calculadora.calcular(contribuinte, "completo");
    	
    	assertEquals(Currency.valueOf(2365.12), imposto);
    	}

    /* Cálculo COMPLETO - Contribuinte PADRÃO com MAIS DE CINCO DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuintePadraoComMaisDeCincoDependentesImpostoFaixa1() {

    }

    @Test
    public void validaCalculoCompletoContribuintePadraoComMaisDeCincoDependentesImpostoFaixa2() {

    }

    @Test
    public void validaCalculoCompletoContribuintePadraoComMaisDeCincoDependentesImpostoFaixa3() {

    }

    /* Cálculo COMPLETO - Contribuinte IDOSO com ATÉ DOIS DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuinteIdosoComAteDoisDependentesImpostoFaixa1() {

    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComAteDoisDependentesImpostoFaixa2() {

    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComAteDoisDependentesImpostoFaixa3() {

    }

    /* Cálculo COMPLETO - Contribuinte IDOSO com TRÊS A CINCO DEPENDENTES */
    @Test
    public void validaCalculoCompletoContribuinteIdosoComTresACincoDependentesImpostoFaixa1() {

    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComTresACincoDependentesImpostoFaixa2() {

    }

    @Test
    public void validaCalculoCompletoContribuinteIdosoComTresACincoDependentesImpostoFaixa3() {

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
        Contribuinte contribuinte = qualquerContribuinteSimplificado(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte, "simplificado");

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
        Contribuinte contribuinte = qualquerContribuinteSimplificado(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte, "simplificado");

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
        Contribuinte contribuinte = qualquerContribuinteSimplificado(totalRendimentos, contribuicao);

        Currency imposto = calculadora.calcular(contribuinte, "simplificado");

        assertEquals(Currency.valueOf(2253.75), imposto);

    }

    private Contribuinte qualquerContribuinteSimplificado(Currency totalRendimentos, Currency contribuicao) {
        return new Contribuinte("Maria Silva", "00011122233", 45, totalRendimentos, contribuicao);
    }

    private Contribuinte qualquerContribuinteCompleto(int idade, int dependentes, Currency totalRendimentos, Currency contribuicao) {
        return new Contribuinte("Maria Silva", "00011122233", idade, totalRendimentos, contribuicao, dependentes);
    }

    private Calculadora calculadora = new Calculadora();

}
