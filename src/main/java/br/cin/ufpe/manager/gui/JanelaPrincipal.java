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
import br.cin.ufpe.manager.entity.TipoRepositorio;
import br.cin.ufpe.manager.entity.Usuario;

public class JanelaPrincipal {
	public static void main(String[] args) {
		
		
		//criação da janela principal
		JFrame janelaPrincipal = new JFrame("MIDIA MANAGER");
		janelaPrincipal.setBounds(0, 0, 850, 850); //dimenões da janela
		janelaPrincipal.setLayout(new GridLayout(3, 1, 0, 10));
		
		//criação dos painéis que abrigam o conteúdo da janela
		final JPanel panelBotaoJanelaAdmin = new JPanel();
		final JPanel panelBotaoJanelaUsuario = new JPanel();
		
//		//criação dos campos de preencher
//		final JLabel labelnome = new JLabel();
//		labelnome.setText("Nome:");
//		final JTextField txtNome = new JTextField();
//		txtNome.setBounds(5, 0, 60, 30);
//		
//		final JLabel labelcpf = new JLabel();
//		labelcpf.setText("CPF:");
//		final JTextField txtCpf = new JTextField();
//		txtCpf.setBounds(5, 80, 60, 30);

		//criação do botão que abre janela adicionarUsuário
		JButton janelaUsuario = new JButton();
		janelaUsuario.setBounds(0, 0, 10, 10);
		janelaUsuario.setText("Adicionar Usuário");
		
		//criação do botão que abre janela adicionarAdmin
			JButton janelaAdmin = new JButton();
			janelaAdmin.setBounds(0, 0, 10, 10);
			janelaAdmin.setText("Adicionar Admin");
		
		//adicionando os conteúdos aos paineis
//		panelBotaoJanelaAdmin.add(labelnome);
//		panelBotaoJanelaAdmin.add(txtNome);
//		panelBotaoJanelaAdmin.add(labelcpf);
//		panelBotaoJanelaAdmin.add(txtCpf);
		panelBotaoJanelaUsuario.add(janelaAdmin);
		panelBotaoJanelaAdmin.add(janelaUsuario);
		
		//dimensões do painel do botão
		panelBotaoJanelaUsuario.setBounds(0, 0, 12, 12);
		panelBotaoJanelaAdmin.setBounds(0, 0, 12, 12);
		
		//definição dos layouts dos paineis
		panelBotaoJanelaAdmin.setLayout(new BoxLayout(panelBotaoJanelaAdmin, BoxLayout.Y_AXIS));
		janelaPrincipal.add(panelBotaoJanelaAdmin);
		panelBotaoJanelaUsuario.setLayout(new BoxLayout(panelBotaoJanelaUsuario, BoxLayout.Y_AXIS));
		janelaPrincipal.add(panelBotaoJanelaUsuario);
		
		//armazenando dados
//		final ControladorPrincipal cp = new ControladorPrincipal(TipoRepositorio.BD);
		
		//ação do botão adicionar
		ActionListener chamaJanelaUsuario = new ActionListener() {
			  public void actionPerformed(ActionEvent e) {

				  
			  }
			};
			
			ActionListener chamaJanelaAdmin = new ActionListener() {
				  public void actionPerformed(ActionEvent e) {

					  
				  }
				};
			
	  janelaAdmin.addActionListener(chamaJanelaAdmin);
	  janelaAdmin.addActionListener(chamaJanelaUsuario);
	  janelaPrincipal.pack();
		janelaPrincipal.setVisible(true);
	}
}
