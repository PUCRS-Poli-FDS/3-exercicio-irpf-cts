package br.pucrs.politecnica._4636h.irpf.model;

import java.util.List;

public interface ContribuinteDAO {

	void insert(Contribuinte contribuinte);

	void update(Contribuinte contribuinte);

	List<Contribuinte> list();

	void delete(String cpf);

	Contribuinte findByCPF(String cpf);

}
