package br.pucrs.politecnica._4636h.irpf;

import br.pucrs.politecnica._4636h.irpf.db.ContribuinteDaoJDBC;
import br.pucrs.politecnica._4636h.irpf.db.DB;
import br.pucrs.politecnica._4636h.irpf.model.ContribuinteDAO;

// m�todo main para testar conex�o com banco de dados.

public class App1 {
	public static void main (String [] args) {
		ContribuinteDAO contribuinte = new ContribuinteDaoJDBC(DB.getConnection());
		System.out.println(contribuinte.findByCPF("75098814050"));
	}

}
