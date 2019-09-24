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

}
