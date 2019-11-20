package br.pucrs.politecnica._4636h.irpf.model;

public class PessoaFisica {

    private final String nome;
    private final String cpf;
    private final Integer idade;

    public PessoaFisica(String nome, String cpf, Integer idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                '}';
    }
}
