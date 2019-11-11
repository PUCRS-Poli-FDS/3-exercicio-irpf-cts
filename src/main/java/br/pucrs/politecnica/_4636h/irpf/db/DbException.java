package br.pucrs.politecnica._4636h.irpf.db;

import br.pucrs.politecnica._4636h.irpf.model.ContribuinteDAO;

public class DbException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DbException (String msg) {
		super(msg);
	}
	
	
}


