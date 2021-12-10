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




public class FrmProductos extends JFrame {
	

	private JPanel contentPane;
	private JTable tblProducto;
	private JButton btnNuevo;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JButton btnAtras;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JTextField txtCantidaddisp;
	private JTextField txtCategoria;
	private JTextField txtId;

	

	/**
	 * Create the frame.
	 */
	public FrmProductos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 1139, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		tblProducto = new JTable();
		tblProducto.setBounds(52, 98, 753, 208);
		tblProducto.setModel(new DefaultTableModel(
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
				"Nombre", "Marca", "Categoria", "Precio", "Cant.Disp"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblProducto.getColumnModel().getColumn(0).setPreferredWidth(116);
		tblProducto.getColumnModel().getColumn(1).setPreferredWidth(107);
		tblProducto.getColumnModel().getColumn(2).setPreferredWidth(141);
		tblProducto.getColumnModel().getColumn(3).setPreferredWidth(140);
		tblProducto.getColumnModel().getColumn(4).setPreferredWidth(126);
		tblProducto.setBackground(Color.WHITE);
		panel.add(tblProducto);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(Color.ORANGE);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
				String marca = txtMarca.getText();
				String categoria = txtCategoria.getText();
				String precio = txtPrecio.getText();
				String cantidaddisp = txtCantidaddisp.getText();
				
				try {
					
					Connection con = (Connection) MySQLConexion.getConexion();
					PreparedStatement ps = con.prepareStatement("INSERT INTO productos (nombre, marca, categoria, precio, cantidaddisp) VALUES (?,?,?,?,?)");
					ps.setString(1, nombre);
					ps.setString(2, marca);
					ps.setString(3, categoria);
					ps.setString(4, precio);
					ps.setString(5, cantidaddisp);
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registro guardado");
					limpiar();
					
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
				
				int idproductos = Integer.parseInt(txtId.getText());
				String nombre = txtNombre.getText();
				String marca = txtMarca.getText();
				String categoria = txtCategoria.getText();
				String precio = txtPrecio.getText();
				String cantidaddisp = txtCantidaddisp.getText();
				
				try {
					
					Connection con = (Connection) MySQLConexion.getConexion();
					PreparedStatement ps = con.prepareStatement("UPDATE productos SET nombre=?,  marca=?, categoria=?, precio=?, cantidaddisp=? WHERE idproductos=?");
					ps.setString(1, nombre);
					ps.setString(2, marca);
					ps.setString(3, categoria);
					ps.setString(4, precio);
					ps.setString(5, cantidaddisp);
					ps.setInt(6, idproductos);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro Modificado");
					limpiar();
					cargarTabla();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				}
			}
		});
		btnActualizar.setBackground(Color.ORANGE);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnActualizar.setBounds(248, 331, 135, 31);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int idproductos = Integer.parseInt(txtId.getText());
				
				
				try {
					
					Connection con = (Connection) MySQLConexion.getConexion();
					PreparedStatement ps = con.prepareStatement("DELETE FROM productos  WHERE idproductos=?");
					ps.setInt(1, idproductos);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
					limpiar();
					cargarTabla();
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(null, e2.toString());
				}
				
			}
		});
		btnEliminar.setBackground(Color.ORANGE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminar.setBounds(451, 331, 135, 31);
		panel.add(btnEliminar);
		
		btnAtras = new JButton("<---------");
		btnAtras.setBackground(Color.ORANGE);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmSelecion selecion = new FrmSelecion();
				selecion.setVisible(true);
				dispose();

			}
		});
		btnAtras.setBounds(670, 331, 135, 31);
		panel.add(btnAtras);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 71, 123, 22);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Marca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(185, 71, 110, 22);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(342, 71, 145, 22);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(501, 65, 145, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cant.Dispo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(670, 73, 135, 18);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(865, 71, 46, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Marca");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(1039, 72, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Precio");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(848, 245, 74, 22);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cant.Dispo");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(1023, 249, 74, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Categoria");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(937, 160, 58, 18);
		panel.add(lblNewLabel_9);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(832, 95, 110, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(1003, 95, 110, 20);
		panel.add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(832, 286, 110, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidaddisp = new JTextField();
		txtCantidaddisp.setBounds(1003, 286, 110, 20);
		panel.add(txtCantidaddisp);
		txtCantidaddisp.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(913, 189, 110, 20);
		panel.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(1115, 41, 10, 20);
		panel.add(txtId);
		txtId.setColumns(10);
	}
	
	private void limpiar() {
		txtNombre.setText("");
		txtMarca.setText("");
		txtCategoria.setText("");
		txtPrecio.setText("");
		txtCantidaddisp.setText("");
	}
	
	private void cargarTabla() {
		DefaultTableModel modeloTabla =  (javax.swing.table.DefaultTableModel) tblProducto.getModel();
		modeloTabla.setRowCount(0);
		PreparedStatement ps;
		ResultSet rs;
		ResultSetMetaData rsmd;
		int columnas;
		
		try {
			Connection con = (Connection) MySQLConexion.getConexion();
		     ps = con.prepareStatement("SELECT nombre, marca, categoria, precio, cantidaddisp FROM	productos");
			
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
