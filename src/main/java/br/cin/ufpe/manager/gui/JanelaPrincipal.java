package br.cin.ufpe.manager.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Janela principal da aplicacao usando Swing
 * 
 * @author Beatriz Sena
 *
 */
public class JanelaPrincipal {
	public static void main(String[] args) {

		// criacao da janela principal
		JFrame janelaPrincipal = new JFrame("MIDIA MANAGER");
		janelaPrincipal.setBounds(0, 0, 850, 850); // dimenões da janela
		janelaPrincipal.setLayout(new GridLayout(3, 1, 0, 10));

		// criacao dos painéis que abrigam o conteúdo da janela
		final JPanel panelBotaoJanelaAdmin = new JPanel();
		final JPanel panelBotaoJanelaUsuario = new JPanel();

		// criacao do botao que abre janela adicionarUsuário
		JButton janelaUsuario = new JButton();
		janelaUsuario.setBounds(0, 0, 10, 10);
		janelaUsuario.setText("Adicionar Usuário");

		// criacao do botao que abre janela adicionarAdmin
		JButton janelaAdmin = new JButton();
		janelaAdmin.setBounds(0, 0, 10, 10);
		janelaAdmin.setText("Adicionar Admin");

		// dimensoes do painel do botao
		panelBotaoJanelaUsuario.setBounds(0, 0, 12, 12);
		panelBotaoJanelaAdmin.setBounds(0, 0, 12, 12);

		// definicao dos layouts dos paineis
		panelBotaoJanelaAdmin.setLayout(new BoxLayout(panelBotaoJanelaAdmin, BoxLayout.Y_AXIS));
		janelaPrincipal.add(panelBotaoJanelaAdmin);
		panelBotaoJanelaUsuario.setLayout(new BoxLayout(panelBotaoJanelaUsuario, BoxLayout.Y_AXIS));
		janelaPrincipal.add(panelBotaoJanelaUsuario);

		// acao do botao adicionar
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
