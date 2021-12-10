package ARCH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimientos.GestionUsuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 407, 491);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 0));
		panel_1.setBounds(40, 93, 332, 321);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(55, 55, 211, 25);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Clave");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(55, 182, 211, 25);
		panel_1.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBounds(55, 117, 211, 32);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(55, 258, 211, 32);
		panel_1.add(txtContraseña);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(204, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(102, 0, 255));
		lblNewLabel.setBounds(84, 33, 220, 49);
		panel.add(lblNewLabel);
		
		JButton btnRegistro = new JButton("Registrar");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abriendo frm del registro
				FrmRegistro abrir= new FrmRegistro();
				abrir.setVisible(true);
				dispose();

			}
		});
		btnRegistro.setBackground(Color.ORANGE);
		btnRegistro.setForeground(new Color(255, 0, 0));
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRegistro.setBounds(236, 443, 136, 23);
		panel.add(btnRegistro);
		
		JButton btnLogin = new JButton("Loguease");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login();
			}
		});
		btnLogin.setForeground(new Color(0, 0, 255));
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setBounds(40, 443, 136, 23);
		panel.add(btnLogin);
	}

	protected void Login() {
		//Confuguracion del boton loguearse
		String usuario = txtUsuario.getText();
		String clave = String.valueOf(txtContraseña.getPassword());

		//Coneccion a la clase Gestion de usuarios
		GestionUsuario gestionUsuario = new GestionUsuario();

		Usuario usuario2 = new Usuario();
		usuario2.setUsuario(usuario);
		usuario2.setClave(clave);

		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);

		if (usu != null) {
			this.dispose();
			
			FrmSelecion selecion = new FrmSelecion();
			selecion.setVisible(true);
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");

		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
			limpiar();
		}

	}
	
	private void limpiar() {
		txtContraseña.setText("");
		txtUsuario.setText("");
	}
		
	
}
