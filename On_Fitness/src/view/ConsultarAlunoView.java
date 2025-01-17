package view;

import controller.AlunoController;
import model.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ConsultarAlunoView extends JFrame {
    private JTable tabelaAlunos;
    private DefaultTableModel modeloTabela;
    private AlunoController alunoController;
    private JLabel lblFundo;

    public ConsultarAlunoView() {
        alunoController = new AlunoController();

        // Configurações principais da janela
        setTitle("Consulta de Alunos");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Adiciona imagem de fundo
        lblFundo = new JLabel();
        lblFundo.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\VAIIII!!!.jpg"));
        lblFundo.setBounds(0, 0, 900, 500);
        getContentPane().add(lblFundo);

        // Tabela para exibir os alunos
        tabelaAlunos = new JTable();
        modeloTabela = new DefaultTableModel(new Object[][]{}, new String[]{
                "ID", "Nome", "Telefone", "Endereço", "Modalidade", "Peso", "Altura", "Mensalidade", "Status"
        }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // Impede edição da coluna ID
            }
        };
        tabelaAlunos.setModel(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        scrollPane.setBounds(20, 50, 850, 300);
        lblFundo.add(scrollPane);

        // Botão para salvar alterações
        JButton btnSalvar = new JButton("Salvar Alterações");
        btnSalvar.setBackground(new Color(0, 0, 255));
        btnSalvar.setForeground(new Color(255, 255, 255));
        btnSalvar.setBounds(200, 370, 150, 30);
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });
        lblFundo.add(btnSalvar);

        // Botão para excluir aluno
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setBackground(new Color(255, 0, 0));
        btnExcluir.setForeground(new Color(255, 255, 255));
        btnExcluir.setBounds(400, 370, 120, 30);
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaAlunos.getSelectedRow();
                if (linhaSelecionada != -1) {
                    int alunoId = (int) modeloTabela.getValueAt(linhaSelecionada, 0);
                    excluirAluno(alunoId);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um aluno para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        lblFundo.add(btnExcluir);

        // Botão para voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBackground(new Color(0, 128, 128));
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setBounds(580, 370, 120, 30);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
            }
        });
        lblFundo.add(btnVoltar);

        carregarAlunos(); // Carrega os dados ao abrir a tela
    }

    private void carregarAlunos() {
        try {
            List<Aluno> alunos = alunoController.listarAlunos();
            modeloTabela.setRowCount(0); // Limpa a tabela
            for (Aluno aluno : alunos) {
                modeloTabela.addRow(new Object[]{
                        aluno.getId(),
                        aluno.getNome(),
                        aluno.getTelefone(),
                        aluno.getEndereco(),
                        aluno.getModalidade(),
                        aluno.getPeso(),
                        aluno.getAltura(),
                        aluno.getMensalidade(),
                        aluno.isStatusMensalidade() ? "Pago" : "Pendente"
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os alunos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void salvarAlteracoes() {
        int linhas = modeloTabela.getRowCount();
        boolean sucesso = true;

        for (int i = 0; i < linhas; i++) {
            try {
                // Recupera os dados da tabela e atualiza o banco
                Aluno aluno = new Aluno();
                aluno.setId((int) modeloTabela.getValueAt(i, 0));
                aluno.setNome((String) modeloTabela.getValueAt(i, 1));
                aluno.setTelefone((String) modeloTabela.getValueAt(i, 2));
                aluno.setEndereco((String) modeloTabela.getValueAt(i, 3));
                aluno.setModalidade((String) modeloTabela.getValueAt(i, 4));
                aluno.setPeso(Double.parseDouble(modeloTabela.getValueAt(i, 5).toString()));
                aluno.setAltura(Double.parseDouble(modeloTabela.getValueAt(i, 6).toString()));
                aluno.setMensalidade(Double.parseDouble(modeloTabela.getValueAt(i, 7).toString()));
                aluno.setStatusMensalidade("Pago".equalsIgnoreCase((String) modeloTabela.getValueAt(i, 8)));

                alunoController.atualizarAluno(aluno);
            } catch (SQLException e) {
                sucesso = false;
                JOptionPane.showMessageDialog(null, "Erro ao salvar alterações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                sucesso = false;
                JOptionPane.showMessageDialog(null, "Erro nos dados: Verifique os valores inseridos.\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Alterações salvas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            carregarAlunos();
        }
    }

    private void excluirAluno(int alunoId) {
        int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                alunoController.excluirAluno(alunoId);
                JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
                carregarAlunos(); // Atualiza a tabela após a exclusão
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir o aluno: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultarAlunoView consultarAlunoView = new ConsultarAlunoView();
            consultarAlunoView.setVisible(true);
        });
    }
}
