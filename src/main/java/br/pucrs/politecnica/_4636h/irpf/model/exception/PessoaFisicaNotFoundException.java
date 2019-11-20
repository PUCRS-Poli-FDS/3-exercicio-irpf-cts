package br.pucrs.politecnica._4636h.irpf.model.exception;

public class PessoaFisicaNotFoundException extends RuntimeException {

    private final String cpf;

    public PessoaFisicaNotFoundException(String cpf) {
        super(error(cpf));
        this.cpf = cpf;
    }

    private static final String error(String cpf) {
        return "Pessoa física não encontrada: " + cpf;
    }
}
