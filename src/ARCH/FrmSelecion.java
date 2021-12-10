package ARCH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmSelecion extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FrmSelecion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 64, 64));
		panel.setBounds(0, 0, 865, 374);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//para mostrar el frm de los usuarios
				FrmUsuarios abrir = new FrmUsuarios();
				abrir.setVisible(true);
				dispose();
			}
		});
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setBackground(Color.LIGHT_GRAY);
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUsuarios.setBounds(67, 66, 175, 128);
		panel.add(btnUsuarios);
		
		JButton btnProductos = new JButton("PRODUCTOS");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//para mostrar el frm de los productos
				FrmProductos abrir = new FrmProductos();
				abrir.setVisible(true);
				dispose();
			}
		});
		btnProductos.setBackground(Color.LIGHT_GRAY);
		btnProductos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProductos.setForeground(Color.BLACK);
		btnProductos.setBounds(345, 66, 175, 128);
		panel.add(btnProductos);
		
		JButton btnCerrar = new JButton("CERRAR SECCION");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login abrir= new Login();
				abrir.setVisible(true);
				dispose();

			}
		});
		btnCerrar.setBounds(607, 39, 160, 43);
		panel.add(btnCerrar);
	}
}
