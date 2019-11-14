package br.pucrs.politecnica._4636h.irpf.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.pucrs.politecnica._4636h.irpf.model.Contribuinte;
import br.pucrs.politecnica._4636h.irpf.model.ContribuinteDAO;
import br.pucrs.politecnica._4636h.irpf.model.Currency;

public class ContribuinteDaoJDBC implements ContribuinteDAO {

	private Connection conn;

	public ContribuinteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Contribuinte obj) {
		try {
			String insert = "INSERT INTO contribuintes " 
					+ "(nome, cpf, idade, total_rendimentos, contribuicao_prev, num_dependentes) " 
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?) ";

			conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(insert);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setInt(3, obj.getIdade());
			st.setBigDecimal(4, obj.getTotalRendimentos().getValue());
			st.setBigDecimal(5, obj.getContribuicaoPrevidenciaria().getValue());			
			st.setInt(6, obj.getNumDependentes());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public void update(Contribuinte obj) {
		String sql = "UPDATE contribuintes SET " 
				+ "nome = ?, cpf = ?, idade = ?, total_rendimentos = ?, contribuicao_prev = ?, num_dependentes = ? "
				+ "WHERE cpf = ? ";
		try {
			conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setInt(3, obj.getIdade());
			st.setBigDecimal(4, obj.getTotalRendimentos().getValue());
			st.setBigDecimal(5, obj.getContribuicaoPrevidenciaria().getValue());
			st.setInt(6, obj.getNumDependentes());
			st.setString(7, obj.getCpf());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteByCpf(String cpf) {
		String sql = "DELETE FROM contribuintes WHERE cpf = ? ";
		try {
			conn = DB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, cpf);
			st.executeUpdate();
						
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		

	}

	@Override
	public Contribuinte findByCPF(String cpf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM contribuintes WHERE contribuintes.cpf = ?");
			st.setString(1, cpf);
			rs = st.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String cpf2 = rs.getString("cpf");
				Integer idade = rs.getInt("idade");
				Currency totalRendimentos = Currency.valueOf(rs.getBigDecimal("total_rendimentos"));
				Currency contribuicao = Currency.valueOf(rs.getBigDecimal("contribuicao_prev"));
				Integer numDependentes = rs.getInt("num_dependentes");
				return new Contribuinte(nome, cpf2, idade, totalRendimentos, contribuicao, numDependentes);
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public List<Contribuinte> findaAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM contribuintes ");
			rs = st.executeQuery();
			List<Contribuinte> contribuintes = new ArrayList<>();
			while (rs.next()) {
				String nome = rs.getString("nome");
				String cpf2 = rs.getString("cpf");
				Integer idade = rs.getInt("idade");
				Currency totalRendimentos = Currency.valueOf(rs.getBigDecimal("total_rendimentos"));
				Currency contribuicao = Currency.valueOf(rs.getBigDecimal("contribuicao_prev"));
				Integer numDependentes = rs.getInt("num_dependentes");
				contribuintes.add(new Contribuinte(nome, cpf2, idade, totalRendimentos, contribuicao, numDependentes));
			}
			return contribuintes;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
