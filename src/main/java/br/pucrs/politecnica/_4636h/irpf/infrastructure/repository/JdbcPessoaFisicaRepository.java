package br.pucrs.politecnica._4636h.irpf.infrastructure.repository;

import br.pucrs.politecnica._4636h.irpf.model.PessoaFisica;
import br.pucrs.politecnica._4636h.irpf.model.exception.PessoaFisicaNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPessoaFisicaRepository implements PessoaFisicaRepository {

    private final Connection conn;

    public JdbcPessoaFisicaRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public PessoaFisica findByCPF(String cpf) {
        PessoaFisica pf = null;

        try {
            try (ResultSet rs = findByCPFStatement(cpf).executeQuery()) {
                if (!rs.next()) {
                    throw new PessoaFisicaNotFoundException(cpf);
                }

                pf = carregaPessoaFisica(rs);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return pf;
    }

    private PreparedStatement findByCPFStatement(String cpf) throws SQLException {
        final String query = "SELECT * FROM pessoa_fisica WHERE cpf = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, cpf);
        return ps;
    }

    private PessoaFisica carregaPessoaFisica(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        Integer idade = rs.getInt("idade");
        return new PessoaFisica(nome, cpf, idade);
    }

    @Override
    public void insert(PessoaFisica pf) {
        try {
            insertStatement(pf).execute();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private PreparedStatement insertStatement(PessoaFisica pf) throws SQLException {
        final String query = "INSERT INTO pessoa_fisica (nome, cpf, idade) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, pf.getNome());
        ps.setString(2, pf.getCpf());
        ps.setInt(3, pf.getIdade());
        return ps;
    }
}
