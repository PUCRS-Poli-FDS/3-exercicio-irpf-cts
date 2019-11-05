package br.pucrs.politecnica._4636h.irpf;

import br.pucrs.politecnica._4636h.irpf.db.ContribuinteDaoJDBC;
import br.pucrs.politecnica._4636h.irpf.db.DB;
import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.ContribuinteDAO;

// método main para testes

public class App1 {
	public static void main (String [] args) {
		
		ContribuinteDAO contribuinteDAO = new ContribuinteDaoJDBC(DB.getConnection());
		/*
		System.out.println("## Teste findByCPF ##");		
		System.out.println(contribuinteDAO.findByCPF("75098814050"));
		*/
		
		/*
		System.out.println("## Teste insert ##");
		Contribuinte contribuinte1 = new Contribuinte();
		contribuinte1.setNome("Marco Polo");
		contribuinte1.setCpf("50098814040");
		contribuinte1.setIdade(45);
		contribuinte1.setNumDependentes(2);		
		contribuinteDAO.insert(contribuinte1);
		*/
	}

}
