package br.cin.ufpe.manager.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.cin.ufpe.manager.business.ControladorPrincipal;
import br.cin.ufpe.manager.entity.Administrador;
import br.cin.ufpe.manager.entity.TipoRepositorio;


public class JanelaAdicionaAdmin {
	
	
	public static void main(String[] args) {

		//criação da janela de cadastro 
		JFrame janelaAddAdmin = new JFrame("Adicionar administrador");
		janelaAddAdmin.setBounds(450, 450, 450, 450); //dimenões da janela
		janelaAddAdmin.setLayout(new GridLayout(3, 1, 0, 10));
		janelaAddAdmin.setLocationRelativeTo(null); //centralizar a janela na tela

		//criação dos painéis que abrigam o conteúdo da janela
		final JPanel panelPrincipalAdmin = new JPanel();
		final JPanel panelBotaoAdmin = new JPanel();

		//criação dos campos de preencher
		final JLabel labelnome = new JLabel();
		labelnome.setText("Nome:");
		final JTextField txtNome = new JTextField();
		txtNome.setBounds(5, 0, 60, 30);

		final JLabel labelcpf = new JLabel();
		labelcpf.setText("CPF:");
		final JTextField txtCpf = new JTextField();
		txtCpf.setBounds(5, 80, 60, 30);

		final JLabel labelemail = new JLabel();
		labelemail.setText("E-mail:");
		final JTextField txtEmail = new JTextField();
		txtEmail.setBounds(5, 0, 60, 30);

		//criação do botão adicionar
		JButton adicionarAdmin = new JButton();
		adicionarAdmin.setBounds(0, 0, 10, 10);
		adicionarAdmin.setText("Adicionar");

		//adicionando os conteúdos aos paineis
		panelPrincipalAdmin.add(labelnome);
		panelPrincipalAdmin.add(txtNome);
		panelPrincipalAdmin.add(labelcpf);
		panelPrincipalAdmin.add(txtCpf);
		panelPrincipalAdmin.add(labelemail);
		panelPrincipalAdmin.add(txtEmail);
		panelBotaoAdmin.add(adicionarAdmin);

		//dimensões do painel do botão
		panelBotaoAdmin.setBounds(0, 0, 12, 12);

		//definição dos layouts dos paineis
		panelPrincipalAdmin.setLayout(new BoxLayout(panelPrincipalAdmin, BoxLayout.Y_AXIS));
		janelaAddAdmin.add(panelPrincipalAdmin);
		panelBotaoAdmin.setLayout(new BoxLayout(panelBotaoAdmin, BoxLayout.Y_AXIS));
		janelaAddAdmin.add(panelBotaoAdmin);

		//AQUI NO ADM O REPOSITÓRIO É BD TAMBÉM?
		//armazenando dados
		final ControladorPrincipal cp = new ControladorPrincipal(TipoRepositorio.BD);

		//ação do botão adicionar
		ActionListener inserirAdmin = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Administrador u = new Administrador();
				u.setCpf(txtCpf.getText());
				u.setNome(txtNome.getText());
				u.setNome(txtEmail.getText());
				cp.getCadastroPessoa().inserirNovaPessoa(u);
				System.out.println(u.getNome() + " Foi inserido!");
			}
		};
		
		adicionarAdmin.addActionListener(inserirAdmin);
		janelaAddAdmin.pack();
		janelaAddAdmin.setVisible(true);
	}

}
