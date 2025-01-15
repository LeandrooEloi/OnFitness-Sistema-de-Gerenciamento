package view;

import controller.AlunoController;
import model.Aluno;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.Color;

public class FinanceiroView extends JFrame {
    private JTable tabelaAlunos;
    private DefaultTableModel modeloTabela;
    private AlunoController alunoController;

    public FinanceiroView() {
        alunoController = new AlunoController();

        // Configurações principais da janela
        setTitle("Financeiro - Pagamento de Mensalidades");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Adicionando JLabel para imagem de fundo
        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 800, 400);
        lblBackground.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\VAIIII!!!.jpg")); // Substitua pelo caminho da sua imagem
        getContentPane().add(lblBackground);

        // Tabela para exibir os alunos
        tabelaAlunos = new JTable();
        modeloTabela = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nome", "Endereço", "Modalidade", "Peso", "Altura", "Mensalidade", "Status"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede a edição direta na tabela
            }
        };
        tabelaAlunos.setModel(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        scrollPane.setBounds(20, 50, 750, 200);
        lblBackground.add(scrollPane); // Adiciona ao JLabel de fundo

        // Botão para realizar pagamento
        JButton btnPagar = new JButton("Realizar Pagamento");
        btnPagar.setBackground(new Color(0, 0, 255));
        btnPagar.setForeground(new Color(255, 255, 255));
        btnPagar.setBounds(200, 270, 150, 30);
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabelaAlunos.getSelectedRow();
                if (linhaSelecionada != -1) {
                    int alunoId = (int) modeloTabela.getValueAt(linhaSelecionada, 0);
                    realizarPagamento(alunoId);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um aluno para realizar o pagamento.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        lblBackground.add(btnPagar); // Adiciona ao JLabel de fundo

        // Botão para voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(new Color(255, 255, 255));
        btnVoltar.setBackground(new Color(0, 128, 128));
        btnVoltar.setBounds(400, 270, 120, 30);
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
            }
        });
        lblBackground.add(btnVoltar); // Adiciona ao JLabel de fundo

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
                        aluno.getEndereco(),
                        aluno.getModalidade(),
                        aluno.getPeso(),
                        aluno.getAltura(),
                        aluno.getMensalidade(),
                        aluno.isStatusMensalidade() ? "OK" : "Em atraso"
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os alunos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void realizarPagamento(int alunoId) {
        try {
            // Atualiza o status da mensalidade para "OK"
            List<Aluno> alunos = alunoController.listarAlunos();
            for (Aluno aluno : alunos) {
                if (aluno.getId() == alunoId) {
                    aluno.setStatusMensalidade(true); // Define como pago
                    alunoController.atualizarAluno(aluno); // Atualiza no banco
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");
            carregarAlunos(); // Atualiza a tabela
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar o pagamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinanceiroView financeiroView = new FinanceiroView();
            financeiroView.setVisible(true);
        });
    }
}
