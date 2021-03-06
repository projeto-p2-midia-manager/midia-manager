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

/**
 * Janela de cadastro de Usuarios usando Swing
 * 
 * @author Beatriz Sena
 *
 */
public class JanelaAdicionaUsuario {

	public static void main(String[] args) {

		// criacao da janela de cadastro
		JFrame janelaAddUsuario = new JFrame("Adicionar usuário");
		janelaAddUsuario.setBounds(0, 0, 850, 850); // dimenões da janela
		janelaAddUsuario.setLayout(new GridLayout(3, 1, 0, 10));
		janelaAddUsuario.setLocationRelativeTo(null); // centralizar a janela na tela

		// criacao dos paineis que abrigam o conteudo da janela
		final JPanel panelPrincipalUsuario = new JPanel();
		final JPanel panelBotaoUsuario = new JPanel();

		// criacao dos campos de preencher
		final JLabel labelnome = new JLabel();
		labelnome.setText("Nome:");
		final JTextField txtNome = new JTextField();
		txtNome.setBounds(5, 0, 60, 30);

		final JLabel labelcpf = new JLabel();
		labelcpf.setText("CPF:");
		final JTextField txtCpf = new JTextField();
		txtCpf.setBounds(5, 80, 60, 30);

		// criacao do botao adicionar
		JButton adicionarUsuario = new JButton();
		adicionarUsuario.setBounds(0, 0, 10, 10);
		adicionarUsuario.setText("Adicionar");

		// adicionando os conteudos aos paineis
		panelPrincipalUsuario.add(labelnome);
		panelPrincipalUsuario.add(txtNome);
		panelPrincipalUsuario.add(labelcpf);
		panelPrincipalUsuario.add(txtCpf);
		panelBotaoUsuario.add(adicionarUsuario);

		// dimensoes do painel do botao
		panelBotaoUsuario.setBounds(0, 0, 12, 12);

		// definicao dos layouts dos paineis
		panelPrincipalUsuario.setLayout(new BoxLayout(panelPrincipalUsuario,
				BoxLayout.Y_AXIS));
		janelaAddUsuario.add(panelPrincipalUsuario);
		panelBotaoUsuario.setLayout(new BoxLayout(panelBotaoUsuario,
				BoxLayout.Y_AXIS));
		janelaAddUsuario.add(panelBotaoUsuario);

		// armazenando dados
		final ControladorPrincipal cp = new ControladorPrincipal(
				TipoRepositorio.BD);

		// acao do botao adicionar
		ActionListener inserirUsuario = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();
				u.setCpf(txtCpf.getText());
				u.setNome(txtNome.getText());
				cp.getCadastroPessoa().inserirNovaPessoa(u);
				System.out.println(u.getNome() + " Foi inserido!");
			}
		};
		adicionarUsuario.addActionListener(inserirUsuario);
		janelaAddUsuario.pack();
		janelaAddUsuario.setVisible(true);
	}

}
