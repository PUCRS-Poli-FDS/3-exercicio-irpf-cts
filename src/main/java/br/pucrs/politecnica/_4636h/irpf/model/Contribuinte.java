package br.pucrs.politecnica._4636h.irpf.model;

public class Contribuinte {

    private final String nome;
    private final String cpf;
    private final Integer idade;
    private final Currency totalRendimentos;
    private final Currency contribuicaoPrevidenciaria;
    private final Integer numDependentes;

    public Contribuinte(String nome,
                        String cpf,
                        Integer idade,
                        Currency totalRendimentos,
                        Currency contribuicaoPrevidenciaria) {
        this(nome, cpf, idade, totalRendimentos, contribuicaoPrevidenciaria, 0);
    }

    public Contribuinte(String nome,
                        String cpf,
                        Integer idade,
                        Currency totalRendimentos,
                        Currency contribuicaoPrevidenciaria,
                        Integer numDependentes) {
        validarNome(nome);
        validarCPF(cpf);
        validarIdade(idade);
        validarTotalRendimentos(totalRendimentos);
        validarContribuicaoPrevidenciaria(contribuicaoPrevidenciaria);

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.totalRendimentos = totalRendimentos;
        this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
        this.numDependentes = numDependentes;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getNumDependentes() {
        return numDependentes;
    }

    public Currency getTotalRendimentos() {
        return totalRendimentos;
    }

    public Currency getContribuicaoPrevidenciaria() {
        return contribuicaoPrevidenciaria;
    }

    private static void validarNome(String nome) {
        if (nome == null || nome.length() < 1) {
            throw new IllegalArgumentException("Nome inválido!");
        }
    }

    private static void validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+")) {
            throw new IllegalArgumentException("CPF inválido!");
        }
    }

    private static void validarIdade(Integer idade) {
        if (idade == null || idade <= 0) {
            throw new IllegalArgumentException("Idade inválida!");
        }
    }

    private static void validarTotalRendimentos(Currency totalRendimentos) {
        if (totalRendimentos == null || totalRendimentos.compareTo(Currency.ZERO) <= 0) {
            throw new IllegalArgumentException("Total de Rendimentos inválido!");
        }
    }

    private static void validarContribuicaoPrevidenciaria(Currency contribuicaoPrevidenciaria) {
        if (contribuicaoPrevidenciaria == null || contribuicaoPrevidenciaria.compareTo(Currency.ZERO) <= 0) {
            throw new IllegalArgumentException("Contribuição Previdenciária inválida!");
        }
    }

    @Override
    public String toString() {
        return "Contribuinte{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", totalRendimentos=" + totalRendimentos +
                ", contribuicaoPrevidenciaria=" + contribuicaoPrevidenciaria +
                ", numDependentes=" + numDependentes +
                '}';
    }
}
