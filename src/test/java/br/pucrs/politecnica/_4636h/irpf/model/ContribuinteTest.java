package br.pucrs.politecnica._4636h.irpf.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContribuinteTest {

    @Test
    public void nomeValidoDeveInstanciarContribuinte() {
        String nome = nomeValido();
        Contribuinte contribuinte = qualquerContribuinteComNome(nome);

        assertEquals(nome, contribuinte.getNome());
    }

    @Test
    public void nomeInvalidoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComNome(null));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComNome(""));
    }

    @Test
    public void cpfValidoDeveInstanciarContribuinte() {
        String cpf = cpfValido();
        Contribuinte contribuinte = qualquerContribuinteComCPF(cpf);

        assertEquals(cpf, contribuinte.getCpf());
    }

    @Test
    public void cpfInvalidoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComCPF(null));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComCPF(""));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComCPF("sakdj"));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComCPF("9998887770"));
    }

    @Test
    public void idadeValidaDeveInstanciarContribuinte() {
        Integer idade = 80;
        Contribuinte contribuinte = qualquerContribuinteComIdade(idade);

        assertEquals(idade, contribuinte.getIdade());
    }

    @Test
    public void idadeInvalidaDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComIdade(null));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComIdade(0));
    }

    @Test
    public void totalRendimentosValidoDeveInstanciarContribuinte() {
        Currency totalRendimentos = Currency.valueOf(25000.00);
        Contribuinte contribuinte = qualquerContribuinteComTotalRendimentos(totalRendimentos);

        assertEquals(totalRendimentos, contribuinte.getTotalRendimentos());
    }

    @Test
    public void totalRendimentosInvalidoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComTotalRendimentos(null));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComTotalRendimentos(Currency.ZERO));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComTotalRendimentos(Currency.valueOf(-1)));
    }

    @Test
    public void contribuicaoPrevidenciariaValidoDeveInstanciarContribuinte() {
        Currency contribuicaoPrevidenciaria = Currency.valueOf(25000.00);
        Contribuinte contribuinte = qualquerContribuinteComContribuicaoPrevidenciaria(contribuicaoPrevidenciaria);

        assertEquals(contribuicaoPrevidenciaria, contribuinte.getContribuicaoPrevidenciaria());
    }

    @Test
    public void contribuicaoPrevidenciariaInvalidoDeveLancarExcecao() {
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComContribuicaoPrevidenciaria(null));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComContribuicaoPrevidenciaria(Currency.ZERO));
        assertThrows(IllegalArgumentException.class, () -> qualquerContribuinteComContribuicaoPrevidenciaria(Currency.valueOf(-1)));
    }
    
    private static Contribuinte qualquerContribuinteComNome(String nome) {
        return new Contribuinte(nome, cpfValido(), idadeValida(), totalRendimentosValido(),
                contribuicaoPrevidenciariaValida());
    }

    private static Contribuinte qualquerContribuinteComCPF(String cpf) {
        return new Contribuinte(nomeValido(), cpf, idadeValida(), totalRendimentosValido(),
                contribuicaoPrevidenciariaValida());
    }

    private static Contribuinte qualquerContribuinteComIdade(Integer idade) {
        return new Contribuinte(nomeValido(), cpfValido(), idade, totalRendimentosValido(),
                contribuicaoPrevidenciariaValida());
    }

    private static Contribuinte qualquerContribuinteComTotalRendimentos(Currency totalRendimentos) {
        return new Contribuinte(nomeValido(), cpfValido(), idadeValida(), totalRendimentos,
                contribuicaoPrevidenciariaValida());
    }

    private static Contribuinte qualquerContribuinteComContribuicaoPrevidenciaria(Currency contribuicaoPrevidenciaria) {
        return new Contribuinte(nomeValido(), cpfValido(), idadeValida(), totalRendimentosValido(),
                contribuicaoPrevidenciaria);
    }

    private static String nomeValido() {
        return "Maria Silva";
    }

    private static String cpfValido() {
        return "00011122233";
    }

    private static Integer idadeValida() {
        return 19;
    }

    private static Currency totalRendimentosValido() {
        return Currency.valueOf(35000.00);
    }

    private static Currency contribuicaoPrevidenciariaValida() {
        return Currency.valueOf(1000.00);
    }

}
