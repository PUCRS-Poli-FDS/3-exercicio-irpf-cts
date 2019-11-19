package br.pucrs.politecnica._4636h.irpf.model;

import java.util.List;

public interface ContribuinteDAO {

	void insert(Contribuinte obj);

	void update(Contribuinte obj);

	void deleteByCpf(String cpf);

	Contribuinte findByCPF(String cpf);
	
	List<Contribuinte> findaAll();

}
