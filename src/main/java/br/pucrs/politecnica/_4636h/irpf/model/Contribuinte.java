package br.pucrs.politecnica._4636h.irpf.model;

public class Contribuinte {

	private String nome;
	private String cpf;
	private Integer idade;
	private Currency totalRendimentos;
	private Currency contribuicaoPrevidenciaria;
	private Integer numDependentes;

	public Contribuinte() {

	}

	public Contribuinte(String nome, String cpf, Integer idade, Currency totalRendimentos,
			Currency contribuicaoPrevidenciaria) {
		this(nome, cpf, idade, totalRendimentos, contribuicaoPrevidenciaria, 0);
	}

	public Contribuinte(String nome, String cpf, Integer idade, Currency totalRendimentos,
			Currency contribuicaoPrevidenciaria, Integer numDependentes) {
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
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setTotalRendimentos(Currency totalRendimentos) {
		this.totalRendimentos = totalRendimentos;
	}

	public void setContribuicaoPrevidenciaria(Currency contribuicaoPrevidenciaria) {
		this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
	}

	public void setNumDependentes(Integer numDependentes) {
		this.numDependentes = numDependentes;
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
