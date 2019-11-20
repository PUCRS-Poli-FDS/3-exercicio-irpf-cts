package br.pucrs.politecnica._4636h.irpf.infrastructure.repository;

import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;

public interface PessoaFisicaRepository {

    PessoaFisica findByCPF(String cpf);
    void insert(PessoaFisica pessoa);

}
