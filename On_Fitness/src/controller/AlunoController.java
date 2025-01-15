package controller;

import dao.AlunoDAO;
import model.Aluno;
import java.sql.SQLException;
import java.util.List;

public class AlunoController {
    private AlunoDAO alunoDAO;

    public AlunoController() {
        this.alunoDAO = new AlunoDAO();
    }

    public void salvarAluno(Aluno aluno) throws SQLException {
        alunoDAO.salvar(aluno);
    }

    public List<Aluno> listarAlunos() throws SQLException {
        return alunoDAO.listarTodos();
    }

    public void atualizarAluno(Aluno aluno) throws SQLException {
        alunoDAO.atualizar(aluno);
    }

    public void excluirAluno(int id) throws SQLException {
        alunoDAO.excluir(id);
    }
}