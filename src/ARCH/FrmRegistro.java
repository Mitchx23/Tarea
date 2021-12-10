package ARCH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import utils.MySQLConexion;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FrmRegistro extends JFrame {
	MySQLConexion cc = new MySQLConexion();
	Connection con = (Connection) cc.getConexion();

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;


	/**
	 * Create the frame.
	 */
	public FrmRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 0, 872, 555);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 51, 204));
		panel_1.setBounds(29, 64, 806, 411);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(45, 115, 205, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(45, 276, 205, 20);
		panel_1.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(529, 115, 205, 20);
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(76, 75, 129, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(76, 228, 129, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(568, 75, 129, 29);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(568, 236, 129, 29);
		panel_1.add(lblNewLabel_4);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(529, 276, 205, 20);
		panel_1.add(txtContraseña);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(199, 11, 439, 42);
		panel.add(lblNewLabel);
		
		JButton btnRegistra = new JButton("Registrar");
		btnRegistra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = txtUsuario.getText();
				String clave = String.valueOf(txtContraseña.getPassword());
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				//Pasandole los aparametros 
				String sql ="Insert into usuarios (usuario, clave, nombre, apellido) values (?,?,?,?)";
				
				try {
					//connecion a base de datos y instanciar ls txtfiles
					PreparedStatement pst = con.prepareStatement(sql);
					
					pst.setString(1, usuario);
					pst.setString(2, clave);
					pst.setString(3, nombre);
					pst.setString(4, apellido);
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Registro Completado");
					limpiar();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Registro no Valido");
				}
				
				
				
			}
		});
		
		
		btnRegistra.setForeground(new Color(51, 0, 255));
		btnRegistra.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRegistra.setBackground(new Color(0, 255, 255));
		btnRegistra.setBounds(39, 511, 230, 33);
		panel.add(btnRegistra);
		
		JButton btnNewButton_1 = new JButton("Loguease");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Abrien el frm del login
				Login abrir= new Login();
				abrir.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setBounds(605, 497, 230, 33);
		panel.add(btnNewButton_1);
	}
	
	private void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtContraseña.setText("");
		txtUsuario.setText("");
	}
}
