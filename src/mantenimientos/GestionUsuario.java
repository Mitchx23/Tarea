package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Usuario;
import utils.MySQLConexion;

public class GestionUsuario {
	
	/**public Usuario12 actualizarUsuario(Usuario usu ) {Usuario usuario = null;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
	
		con = MySQLConexion.getConexion();
	
		String sql = "update usuarios set" + " usuario = ?" + " and clave =  ?" + " and nombre = ?" + " apellido = ?" + "telefono = ?" + "email ";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, usu.getUsuario());
		pst.setString(2, usu.getClave());
		
		rs = pst.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuario(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			
		}
		
		
		
	} catch (Exception e) {
	System.out.println("Error en obtener usuario");
	}
	
	
	return usuario;
	
}
**/	

public Usuario obtenerUsuario(Usuario usu){
	//instanciamos algunos objetos
	Usuario usuario = null;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		//connecion a base de datos y verificando usuarios
	
		con = MySQLConexion.getConexion();
	
		String sql = "select*from usuarios where usuario = ? and clave =  ? ";
		
		pst = con.prepareStatement(sql);
		
		pst.setString(1, usu.getUsuario());
		pst.setString(2, usu.getClave());
		
		rs = pst.executeQuery();
		
		while (rs.next()) {
			usuario = new Usuario(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			
		}
		
		
		
	} catch (Exception e) {
	System.out.println("Error en obtener usuario");
	}
	
	
	return usuario;
	
}
	


}


