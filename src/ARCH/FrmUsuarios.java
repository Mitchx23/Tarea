package ARCH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.security.auth.x500.X500Principal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bean.*;
import utils.MySQLConexion;




public class FrmUsuarios extends JFrame {
	

	private JPanel contentPane;
	private JTable tblUsuarios;
	private JButton btnNuevo;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAtras;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private JTextField txtTelefono;
	private JTextField txtId;

	

	/**
	 * Create the frame.
	 */
	public FrmUsuarios() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1139, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		tblUsuarios = new JTable();
		tblUsuarios.setBounds(52, 98, 753, 208);
		tblUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Apellido", "Telefono", "Email", "Usuario"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(116);
		tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(107);
		tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(141);
		tblUsuarios.getColumnModel().getColumn(3).setPreferredWidth(140);
		tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(126);
		tblUsuarios.setBackground(Color.WHITE);
		panel.add(tblUsuarios);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(Color.LIGHT_GRAY);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciando txtfiles 
				String nombre = txtNombre.getText();
				String Apellido = txtApellido.getText();
				String Telefono = txtTelefono.getText();
				String Email = txtEmail.getText();
				String Usuario = txtUsuario.getText();
				
				try {
					//coneccion a la base de datos
					Connection con = (Connection) MySQLConexion.getConexion();
					PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios (nombre, apellido, telefono, email, usuario, clave) VALUES (?,?,?,?,?,?)");
					ps.setString(1, nombre);
					ps.setString(2, Apellido);
					ps.setString(3, Telefono);
					ps.setString(4, Email);
					ps.setString(5, Usuario);
					ps.setString(6, "1234");
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registro guardado");
					limpiar();
					cargarTabla();
					
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				}
				
			
			}
		});
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNuevo.setBounds(52, 331, 135, 31);
		panel.add(btnNuevo);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instanciando txtfiles 
				int idusuarios = Integer.parseInt(txtId.getText());
				String nombre = txtNombre.getText();
				String apellido = txtApellido.getText();
				String telefono = txtTelefono.getText();
				String email = txtEmail.getText();
				String usuario = txtUsuario.getText();
				
				try {
					//coneccion a la base de datos y pasando parametros
					Connection con = (Connection) MySQLConexion.getConexion();
					PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET nombre=?, apellido=?, telefono=?, email=?, usuario=? WHERE idusuarios=?");
					ps.setString(1, nombre);
					ps.setString(2, apellido);
					ps.setString(3, telefono);
					ps.setString(4, email);
					ps.setString(5, usuario);
					ps.setInt(6, idusuarios);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro Modificado");
					limpiar();
					cargarTabla();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				}
			}
		});
		btnActualizar.setBackground(Color.LIGHT_GRAY);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnActualizar.setBounds(241, 331, 135, 31);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//instanciando txtfiles 
				int idusuarios = Integer.parseInt(txtId.getText());
				
				
				try {
					//coneccion a la base de datos y pasando parametros
					Connection con = (Connection) MySQLConexion.getConexion();
					PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios  WHERE idusuarios=?");
					ps.setInt(1, idusuarios);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
					limpiar();
					cargarTabla();
					
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				}
				
			
				
			}
		});
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminar.setBounds(451, 331, 135, 31);
		panel.add(btnEliminar);
		
		btnAtras = new JButton("<---------");
		btnAtras.setBackground(Color.LIGHT_GRAY);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmSelecion selecion = new FrmSelecion();
				selecion.setVisible(true);
				dispose();

			}
		});
		btnAtras.setBounds(658, 331, 135, 31);
		panel.add(btnAtras);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 71, 123, 22);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(185, 71, 110, 22);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(342, 71, 145, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(501, 65, 145, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Usuario");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(670, 73, 135, 18);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(865, 71, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(1039, 72, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(845, 257, 74, 22);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Usuaio");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(1023, 261, 74, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Telefono");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(940, 168, 58, 14);
		panel.add(lblNewLabel_9);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(832, 95, 110, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(1003, 95, 110, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(832, 286, 110, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(1003, 286, 110, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(916, 196, 110, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(1115, 41, 10, 20);
		panel.add(txtId);
		txtId.setColumns(10);
	}
	
	private void limpiar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtUsuario.setText("");
	}
	
	private void cargarTabla() {
		
		//organizacion de la tabla de datos
		DefaultTableModel modeloTabla =  (javax.swing.table.DefaultTableModel) tblUsuarios.getModel();
		modeloTabla.setRowCount(0);
		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;
		
		try {
			//coneccion a la base de datos
			 Connection con = (Connection) MySQLConexion.getConexion();
			 ps = con.prepareStatement("SELECT nombre, apellido, telefono, email, usuario FROM	usuarios");
			
		     rs = ps.executeQuery();
		     rsmd = rs.getMetaData();
		     columnas = rsmd.getColumnCount();
		     
		     while (rs.next()) {
				Object[] fila = new Object[columnas];
				for (int indice = 0; indice<columnas; indice++) {
					fila[indice] = rs.getObject(indice + 1);
				}
				modeloTabla.addRow(fila);		
			}
		     
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
	}

	


	private DefaultTableModel DefaultTableModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
