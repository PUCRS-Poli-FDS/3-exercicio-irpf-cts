package br.pucrs.politecnica._4636h.irpf.model;

public class Contribuinte {

	private PessoaFisica pessoa;
	private Currency totalRendimentos;
	private Currency contribuicaoPrevidenciaria;
	private Integer numDependentes;

	public Contribuinte(PessoaFisica pessoa,
						Currency totalRendimentos,
						Currency contribuicaoPrevidenciaria) {
		this(pessoa, totalRendimentos, contribuicaoPrevidenciaria, 0);
	}

	public Contribuinte(PessoaFisica pessoa,
						Currency totalRendimentos,
						Currency contribuicaoPrevidenciaria,
						Integer numDependentes) {
		this.pessoa = pessoa;
		this.totalRendimentos = totalRendimentos;
		this.contribuicaoPrevidenciaria = contribuicaoPrevidenciaria;
		this.numDependentes = numDependentes;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
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

	@Override
	public String toString() {
		return "Contribuinte{" +
				"pessoa=" + pessoa +
				", totalRendimentos=" + totalRendimentos +
				", contribuicaoPrevidenciaria=" + contribuicaoPrevidenciaria +
				", numDependentes=" + numDependentes +
				'}';
	}
}
