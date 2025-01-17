package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class TelaPrincipalView extends JFrame {
    public TelaPrincipalView() {
        // Configurações principais da janela
        setTitle("Sistema ONFitness - Menu Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Menu Cadastro de Aluno
        JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
        btnCadastrarAluno.setBackground(new Color(0, 0, 255));
        btnCadastrarAluno.setForeground(new Color(255, 255, 255));
        btnCadastrarAluno.setBounds(10, 11, 177, 30);
        btnCadastrarAluno.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlunoCadastroView cadastroAlunoView = new AlunoCadastroView();
                cadastroAlunoView.setVisible(true);
            }
        });
        getContentPane().add(btnCadastrarAluno); 

        // Menu Consultar Aluno
        JButton btnConsultarAluno = new JButton("Consultar Alunos");
        btnConsultarAluno.setBackground(new Color(0, 128, 128));
        btnConsultarAluno.setForeground(new Color(255, 255, 255));
        btnConsultarAluno.setBounds(10, 48, 177, 30);
        btnConsultarAluno.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnConsultarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarAlunoView consultarAlunoView = new ConsultarAlunoView();
                consultarAlunoView.setVisible(true);
            }
        });
        getContentPane().add(btnConsultarAluno); 

        // Menu Cadastro de Instrutor
        JButton btnCadastrarInstrutor = new JButton("Cadastrar Instrutor");
        btnCadastrarInstrutor.setForeground(new Color(255, 255, 255));
        btnCadastrarInstrutor.setBackground(new Color(0, 0, 255));
        btnCadastrarInstrutor.setBounds(193, 11, 177, 30);
        btnCadastrarInstrutor.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnCadastrarInstrutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroInstrutorView cadastroInstrutorView = new CadastroInstrutorView();
                cadastroInstrutorView.setVisible(true);
            }
        });
        getContentPane().add(btnCadastrarInstrutor); // Adiciona diretamente ao contentPane

        // Menu Consultar Instrutores
        JButton btnConsultarInstrutor = new JButton("Consultar Instrutores");
        btnConsultarInstrutor.setBackground(new Color(0, 128, 128));
        btnConsultarInstrutor.setForeground(new Color(255, 255, 255));
        btnConsultarInstrutor.setBounds(193, 48, 177, 30);
        btnConsultarInstrutor.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnConsultarInstrutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarInstrutorView consultarInstrutorView = new ConsultarInstrutorView();
                consultarInstrutorView.setVisible(true);
            }
        });
        getContentPane().add(btnConsultarInstrutor); // Adiciona diretamente ao contentPane

        // Menu Financeiro
        JButton btnFinanceiro = new JButton("Financeiro");
        btnFinanceiro.setForeground(new Color(255, 255, 255));
        btnFinanceiro.setBackground(new Color(255, 0, 0));
        btnFinanceiro.setBounds(376, 11, 177, 30);
        btnFinanceiro.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        btnFinanceiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FinanceiroView financeiroView = new FinanceiroView();
                financeiroView.setVisible(true);
            }
        });
        getContentPane().add(btnFinanceiro); // Adiciona diretamente ao contentPane
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(240, 240, 240));
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\VAIVAI.jpg"));
        lblNewLabel.setBounds(35, -26, 673, 400);
        getContentPane().add(lblNewLabel);
        
        JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Dev Leandro Oliveira");
        lblNewJgoodiesTitle.setForeground(new Color(255, 255, 255));
        lblNewJgoodiesTitle.setBounds(432, 336, 121, 14);
        getContentPane().add(lblNewJgoodiesTitle);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipalView telaPrincipalView = new TelaPrincipalView();
            telaPrincipalView.setVisible(true);
        });
    }
}
