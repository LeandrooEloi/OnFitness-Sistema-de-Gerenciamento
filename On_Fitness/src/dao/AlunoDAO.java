package dao;

import model.Aluno;
import util.ConexaoDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public void salvar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (nome, endereco, telefone, modalidade, peso, altura, mensalidade, status_mensalidade) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getModalidade());
            stmt.setDouble(5, aluno.getPeso());
            stmt.setDouble(6, aluno.getAltura());
            stmt.setDouble(7, aluno.getMensalidade());
            stmt.setBoolean(8, aluno.isStatusMensalidade());
            stmt.executeUpdate();
        }
    }

    public List<Aluno> listarTodos() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (Connection conn = ConexaoDB.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setModalidade(rs.getString("modalidade"));
                aluno.setPeso(rs.getDouble("peso"));
                aluno.setAltura(rs.getDouble("altura"));
                aluno.setMensalidade(rs.getDouble("mensalidade"));
                aluno.setStatusMensalidade(rs.getBoolean("status_mensalidade"));
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public void atualizar(Aluno aluno) throws SQLException {
        String sql = "UPDATE alunos SET nome = ?, endereco = ?, telefone = ?, modalidade = ?, peso = ?, altura = ?, mensalidade = ?, status_mensalidade = ? WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getEndereco());
            stmt.setString(3, aluno.getTelefone());
            stmt.setString(4, aluno.getModalidade());
            stmt.setDouble(5, aluno.getPeso());
            stmt.setDouble(6, aluno.getAltura());
            stmt.setDouble(7, aluno.getMensalidade());
            stmt.setBoolean(8, aluno.isStatusMensalidade());
            stmt.setInt(9, aluno.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (Connection conn = ConexaoDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}