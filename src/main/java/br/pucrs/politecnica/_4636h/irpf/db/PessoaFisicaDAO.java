package br.pucrs.politecnica._4636h.irpf.db;

import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;

public interface PessoaFisicaDAO {

    PessoaFisica findByCPF(String cpf);
    void insert(PessoaFisica pessoa);

}
